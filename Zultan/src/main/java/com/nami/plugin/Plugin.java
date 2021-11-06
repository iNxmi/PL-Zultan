package com.nami.plugin;

import com.nami.api.sys.APIPlugin;
import com.nami.plugin.modules.coords.MDL_Coords;

public class Plugin extends APIPlugin {

	public Plugin() {
		super("Zultan", 2);
	}

	@Override
	public void init() {
		addModule(new MDL_Coords(this));
	}

}
