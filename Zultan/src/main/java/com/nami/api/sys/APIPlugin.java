package com.nami.api.sys;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.nami.api.base.MDL_base;
import com.nami.api.util.DataContainer;
import com.nami.api.util.Logger;
import com.nami.api.util.MessageType;

public abstract class APIPlugin extends JavaPlugin {

	private String name;
	private File folder;
	private DataContainer<String, Boolean> activation;
	private Map<String, APIModule> modules;

	public static Logger logger;

	public APIPlugin(String name, int modules) {
		this.name = name;
		this.folder = getDataFolder();
		this.activation = new DataContainer<String, Boolean>(folder.getAbsolutePath().concat("/modules.json"));
		this.modules = new HashMap<String, APIModule>();

		logger = new Logger(name);

		addModule(new MDL_base(this));

		init();
	}

	public abstract void init();

	@Override
	public void onEnable() {
		// TODO make config shit work
		loadModules(activation.getData());
	}

	private void loadModules(Map<String, Boolean> map) {
		modules.get("base").load(this);

		for (Map.Entry<String, Boolean> en : map.entrySet())
			if (en.getValue()) {
				modules.get(en.getKey().toLowerCase()).load(this);

				logger.send(MessageType.INFO, Bukkit.getConsoleSender(), "Loaded Module: " + en.getKey());
			}
	}

	public DataContainer<String, Boolean> getActivation() {
		return activation;
	}

	public void addModule(APIModule module) {
		modules.put(module.getName().toLowerCase(), module);
	}

	public Map<String, APIModule> getModules() {
		return modules;
	}

	public String getPluginName() {
		return name;
	}

}
