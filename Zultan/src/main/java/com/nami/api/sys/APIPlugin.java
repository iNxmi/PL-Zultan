package com.nami.api.sys;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import com.nami.api.modules.base.MDL_base;
import com.nami.api.util.DataContainer;
import com.nami.api.util.Logger;

public abstract class APIPlugin extends JavaPlugin {

	private String name;
	private File folder;
	private DataContainer<String, Boolean> activeModules;
	private List<APIModule> modules;

	public static Logger logger;

	public APIPlugin(String name) {
		this.name = name;
		this.folder = getDataFolder();
		this.activeModules = new DataContainer<String, Boolean>(folder.getAbsolutePath().concat("/modules.json"));
		this.modules = new ArrayList<APIModule>();

		logger = new Logger(name);

		addModule(new MDL_base(this));
	}

	@Override
	public void onEnable() {
		loadModules();
		
		try {
			activeModules.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onDisable() {
		try {
			activeModules.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadModules() {
		for (APIModule m : modules)
			m.load();
	}

	public DataContainer<String, Boolean> getActiveModules() {
		return activeModules;
	}

	public void addModule(APIModule module) {
		activeModules.getData().put(module.getName(), false);
		modules.add(module);
	}

	public List<APIModule> getModules() {
		return modules;
	}

	public String getPluginName() {
		return name;
	}

}
