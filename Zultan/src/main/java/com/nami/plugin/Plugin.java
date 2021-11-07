package com.nami.plugin;

import com.nami.api.sys.APIPlugin;
import com.nami.plugin.modules.coords.MDL_Coords;

public class Plugin extends APIPlugin {

	// next 004

	public Plugin() {
		super("Zultan");

		addModule(new MDL_Coords(this), false);
	}

}
