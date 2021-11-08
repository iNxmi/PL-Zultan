package com.nami.api.evt;

import org.bukkit.event.Listener;

import com.nami.api.sys.APIModule;

public class APIEvent implements Listener {

	private APIModule module;

	public APIEvent(APIModule module) {
		this.module = module;
	}

	public APIModule getModule() {
		return module;
	}

}
