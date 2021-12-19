package com.nami.api.sys;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.plugin.java.JavaPlugin;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nami.api.modules.base.MDL_base;
import com.nami.api.util.Logger;

public abstract class APIPlugin extends JavaPlugin {

	private String name;
	private File folder;
	private File enabled;
	private Map<String, APIModule> modules;

	public static Logger logger;

	public APIPlugin(String name) {
		this.name = name;
		this.folder = new File(getDataFolder().getAbsolutePath().concat("/").concat(getDescription().getVersion()));
		this.enabled = new File(folder.getAbsolutePath().concat("/").concat("enabled.json"));
		this.modules = new HashMap<>();

		logger = new Logger(name);

		addModule(new MDL_base(this));
	}

	@Override
	public void onEnable() {
		if (!folder.exists())
			folder.mkdirs();

		loadModules();

		enableModules(em());
	}

	private Map<String, Boolean> em() {
		if (!enabled.exists())
			try {
				enabled.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		ObjectMapper om = new ObjectMapper();

		try {
			byte[] data = Files.readAllBytes(enabled.toPath());
			if (data.length <= 0) {
				Map<String, Boolean> map = new HashMap<>();
				for (Map.Entry<String, APIModule> e : modules.entrySet())
					map.put(e.getKey(), e.getValue().isEnabled());

				om.writerWithDefaultPrettyPrinter().writeValue(enabled, map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Boolean> toEnable = null;
		try {
			toEnable = om.readValue(Files.readAllBytes(enabled.toPath()),
					new TypeReference<HashMap<String, Boolean>>() {
					});
		} catch (Exception e) {
			Map<String, Boolean> map = new HashMap<>();
			for (Map.Entry<String, APIModule> e1 : modules.entrySet())
				map.put(e1.getKey(), e1.getValue().isEnabled());

			try {
				om.writerWithDefaultPrettyPrinter().writeValue(enabled, map);
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

		try {
			toEnable = om.readValue(Files.readAllBytes(enabled.toPath()),
					new TypeReference<HashMap<String, Boolean>>() {
					});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return toEnable;
	}

	@Override
	public void onDisable() {

	}

	private void loadModules() {
		for (APIModule m : modules.values())
			m.load();
	}

	// TODO Make shit work right
	private void enableModules(Map<String, Boolean> toEnable) {
		for (Map.Entry<String, Boolean> m : toEnable.entrySet())
			modules.get(m.getKey()).setEnabled(m.getValue());
	}

	public void addModule(APIModule module) {
		modules.put(module.getID(), module);
	}

	public Map<String, APIModule> getModules() {
		return modules;
	}

	public File getFolder() {
		return folder;
	}

	public String getPluginName() {
		return name;
	}

}
