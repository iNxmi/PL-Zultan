package com.nami.api.plugin.module;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.nami.api.plugin.APIPlugin;
import com.nami.api.plugin.module.command.APICommand;
import com.nami.api.plugin.module.event.APIEvent;

public abstract class APIModule {

	private APIPlugin plugin;
	private String id;
	private boolean enabled;

	private File folder;

	private List<APICommand> commands;
	private List<APIEvent> events;

	public APIModule(APIPlugin plugin, String id, boolean enabled) {
		this.plugin = plugin;
		this.id = id.toLowerCase();
		this.enabled = enabled;

		this.folder = new File(plugin.getDataFolder().getAbsolutePath().concat("/").concat(this.id));

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

	public String getID() {
		return id;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public APIPlugin getPlugin() {
		return plugin;
	}

}
