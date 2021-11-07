package com.nami.plugin.modules.coords;

import com.nami.api.sys.APIModule;
import com.nami.api.sys.APIPlugin;
import com.nami.plugin.modules.coords.cmd.CMD_coords;

public class MDL_Coords extends APIModule {

	public MDL_Coords(APIPlugin plugin) {
		super(plugin, "coords", true);

		addCommand(new CMD_coords(this));
	}

}
