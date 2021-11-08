package com.nami.api.sys;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.nami.api.cmd.APICommand;
import com.nami.api.evt.APIEvent;

public abstract class APIModule {

	private APIPlugin plugin;
	private String name;
	private boolean forceEnabled;
	private File folder;

	private List<APICommand> commands;
	private List<APIEvent> events;

	public APIModule(APIPlugin plugin, String name, boolean forceEnabled) {
		this.plugin = plugin;
		this.name = name.toLowerCase();
		this.forceEnabled = forceEnabled;
		this.folder = new File(plugin.getDataFolder().getAbsolutePath().concat("/").concat(name));

		this.commands = new ArrayList<>();
		this.events = new ArrayList<>();

		if (!folder.exists())
			folder.mkdirs();
	}

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
		for (APIEvent event : events)
			plugin.getServer().getPluginManager().registerEvents(event, plugin);
	}

	public File getFolder() {
		return folder;
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
