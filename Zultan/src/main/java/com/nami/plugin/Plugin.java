package com.nami.plugin;

import com.nami.api.plugin.APIPlugin;
import com.nami.plugin.modules.chatutils.MDL_ChatUtils;
import com.nami.plugin.modules.coords.MDL_Coords;
import com.nami.plugin.modules.gamemode.MDL_Gamemode;

public class Plugin extends APIPlugin {

	@Override
	public void onPluginEnable() {
		addModule(new MDL_Coords(this));
		addModule(new MDL_Gamemode(this));
		addModule(new MDL_ChatUtils(this));
	}

	@Override
	public void onPluginDisable() {

	}

}
