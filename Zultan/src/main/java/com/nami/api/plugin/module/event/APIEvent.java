package com.nami.api.plugin.module.event;

import org.bukkit.event.Listener;

import com.nami.api.plugin.module.APIModule;

public class APIEvent implements Listener {

	private APIModule module;
	private boolean enabled;

	public APIEvent(APIModule module) {
		this.module = module;
	}

	public APIModule getModule() {
		return module;
	}

}
