package com.nami.api.plugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.plugin.java.JavaPlugin;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nami.api.modules.base.MDL_Base;
import com.nami.api.plugin.module.APIModule;
import com.nami.api.util.Logger;

public abstract class APIPlugin extends JavaPlugin {

	private String name;
	private File folder;
	private File enabled;
	private Map<String, APIModule> modules;

	public static Logger logger;

	private ObjectMapper mapper = new ObjectMapper();

	public APIPlugin(String name) {
		this.name = name;
		this.folder = new File(getDataFolder().getAbsolutePath().concat("/").concat(getDescription().getVersion()));
		this.enabled = new File(folder.getAbsolutePath().concat("/").concat("enabled.json"));
		this.modules = new HashMap<>();

		logger = new Logger(name);

		addModule(new MDL_Base(this));
	}

	@Override
	public void onEnable() {
		if (!folder.exists())
			folder.mkdirs();

		loadModules();

		try {
			enableModules();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void enableModules() throws IOException {
		enableModules(loadToEnable());
	}

	private Map<String, Boolean> loadToEnable() throws IOException {
		if (!enabled.exists())
			enabled.createNewFile();

		if (!jsonSyntaxCorrect(enabled) || Files.readAllBytes(enabled.toPath()).length <= 0)
			resetToEnable();

		Map<String, Boolean> toEnable = mapper.readValue(Files.readAllBytes(enabled.toPath()),
				new TypeReference<HashMap<String, Boolean>>() {
				});

		return toEnable;
	}
	
	public void resetToEnable() throws StreamWriteException, DatabindException, IOException {
		Map<String, Boolean> map = new HashMap<>();
		for (Map.Entry<String, APIModule> e : modules.entrySet())
			map.put(e.getKey(), e.getValue().isEnabled());

		mapper.writerWithDefaultPrettyPrinter().writeValue(enabled, map);
	}
	
	private boolean jsonSyntaxCorrect(File file) {
		try {
			mapper.readTree(file);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void onDisable() {

	}

	private void loadModules() {
		for (APIModule m : modules.values())
			m.load();
	}

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
