package com.nami.api.sys;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.plugin.java.JavaPlugin;

import com.nami.api.modules.base.MDL_base;
import com.nami.api.util.Logger;

public abstract class APIPlugin extends JavaPlugin {

	private String name;
	private Map<String, APIModule> modules;

	public static Logger logger;

	public APIPlugin(String name) {
		this.name = name;
		this.modules = new HashMap<>();

		logger = new Logger(name);

		addModule(new MDL_base(this));
	}

	@Override
	public void onEnable() {
		loadModules();
		// TODO load enabled modules from json
	}

	@Override
	public void onDisable() {
		// TODO save enabled modules from json
	}

	public void loadModules() {
		for (APIModule m : modules.values())
			m.load();
	}

	public void addModule(APIModule module) {
		modules.put(module.getID(), module);
	}

	public Map<String, APIModule> getModules() {
		return modules;
	}

	public String getPluginName() {
		return name;
	}

}
