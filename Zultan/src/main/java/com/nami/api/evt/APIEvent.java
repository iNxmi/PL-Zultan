package com.nami.api.evt;

import org.bukkit.event.Listener;

import com.nami.api.sys.APIPlugin;

public class APIEvent implements Listener {

	//TODO make this shit work
	
	private APIPlugin plugin;

	public APIEvent(APIPlugin plugin) {
		this.plugin = plugin;
	}

	public APIPlugin getPlugin() {
		return plugin;
	}

}
