package com.nami.plugin.modules.chatutils;

import com.nami.api.sys.APIModule;
import com.nami.api.sys.APIPlugin;
import com.nami.plugin.modules.chatutils.cmd.CMD_ChatUtils;

public class MDL_ChatUtils extends APIModule {

	public MDL_ChatUtils(APIPlugin plugin) {
		super(plugin, "chatutils", false);

		addCommand(new CMD_ChatUtils(this));
	}

}
