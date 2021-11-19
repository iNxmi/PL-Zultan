package com.nami.plugin.modules.gamemode;

import com.nami.api.sys.APIModule;
import com.nami.api.sys.APIPlugin;
import com.nami.plugin.modules.gamemode.cmd.CMD_Gamemode;

public class MDL_Gamemode extends APIModule {

	public MDL_Gamemode(APIPlugin plugin) {
		super(plugin, "gamemode");

		addCommand(new CMD_Gamemode(this));
	}

}
