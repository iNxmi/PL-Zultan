package com.nami.api.sys;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nami.api.cmd.APICommand;
import com.nami.api.evt.APIEvent;
import com.nami.api.util.DataContainer;

public abstract class APIModule {

	private APIPlugin plugin;
	private String name;
	private List<APICommand> commands;
	private List<APIEvent> events;
	private DataContainer<String, String> config;
	private boolean forceEnabled;

	public APIModule(APIPlugin plugin, String name, boolean forceEnabled) {
		try {
			preInit(plugin, name, forceEnabled, false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public APIModule(APIPlugin plugin, String name, boolean forceEnabled, boolean config) {
		try {
			preInit(plugin, name, forceEnabled, config);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void preInit(APIPlugin plugin, String name, boolean forceEnabled, boolean config) throws IOException {
		this.plugin = plugin;
		this.name = name;
		this.forceEnabled = forceEnabled;
		this.commands = new ArrayList<>();
		this.events = new ArrayList<>();

		if (config) {
			String path = plugin.getDataFolder().getAbsolutePath().concat("/").concat(name).concat(".json");
			File file = new File(path);
			this.config = new DataContainer<String, String>(file);

			if (file.exists()) {
				this.config.load();
			} else {
				file.mkdirs();
			}
		}

		onInit();
	}

	public abstract void onInit();

	public void addCommand(APICommand command) {
		commands.add(command);
	}

	public void addEvent(APIEvent event) {
		events.add(event);
	}

	public void load() {
		loadCommands(plugin);
		loadEvents(plugin);
	}

	public void loadCommands(APIPlugin plugin) {
		for (APICommand command : commands)
			plugin.getCommand(command.getName()).setExecutor(command);
	}

	public void loadEvents(APIPlugin plugin) {
		// TODO make events work
//		for (APIEvent event : events)
//			plugin.getServer().getPluginManager().registerEvent(event);
	}

	public List<APICommand> getCommands() {
		return commands;
	}

	public List<APIEvent> getEvents() {
		return events;
	}

	public boolean isForceEnabled() {
		return forceEnabled;
	}

	public String getName() {
		return name;
	}

	public APIPlugin getPlugin() {
		return plugin;
	}

}
