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

		getDescription().getVersion();
	}

	@Override
	public void onEnable() {
		loadModules();

		enableModules();
	}

	@Override
	public void onDisable() {

	}

	private void loadModules() {
		for (APIModule m : modules.values())
			m.load();
	}

	// TODO Make shit work right
	private void enableModules() {
		for (APIModule m : modules.values())
			m.setEnabled(true);
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
