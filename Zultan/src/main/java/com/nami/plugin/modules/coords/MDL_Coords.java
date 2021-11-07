package com.nami.plugin.modules.coords;

import com.nami.api.sys.APIModule;
import com.nami.api.sys.APIPlugin;

public class MDL_Coords extends APIModule {

	public MDL_Coords(APIPlugin plugin) {
		super(plugin, "coords", false);
		
		addCommand(new CMD_coords(this));
	}

}
