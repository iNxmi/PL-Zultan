package com.nami.plugin;

import com.nami.api.sys.APIPlugin;
import com.nami.plugin.modules.coords.MDL_Coords;
import com.nami.plugin.modules.gamemode.MDL_Gamemode;

public class Plugin extends APIPlugin {

	// next 009

	public Plugin() {
		super("Zultan");

		addModule(new MDL_Coords(this));
		addModule(new MDL_Gamemode(this));
	}

}
