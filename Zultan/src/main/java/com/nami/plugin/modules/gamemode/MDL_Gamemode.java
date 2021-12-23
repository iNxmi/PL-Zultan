package com.nami.plugin.modules.gamemode;

import com.nami.api.plugin.APIPlugin;
import com.nami.api.plugin.module.APIModule;
import com.nami.plugin.modules.gamemode.cmd.CMD_Gamemode;

public class MDL_Gamemode extends APIModule {

	public MDL_Gamemode(APIPlugin plugin) {
		super(plugin, "gamemode", false);

		addCommand(new CMD_Gamemode(this));
	}

}
