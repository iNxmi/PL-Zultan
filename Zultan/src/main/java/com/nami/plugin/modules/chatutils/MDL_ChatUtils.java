package com.nami.plugin.modules.chatutils;

import com.nami.api.plugin.APIPlugin;
import com.nami.api.plugin.module.APIModule;
import com.nami.plugin.modules.chatutils.cmd.CMD_ChatUtils;
import com.nami.plugin.modules.chatutils.evt.EVT_Chat;

public class MDL_ChatUtils extends APIModule {

	public MDL_ChatUtils(APIPlugin plugin) {
		super(plugin, "chatutils", false);

		addCommand(new CMD_ChatUtils(this));
		addEvent(new EVT_Chat(this));
	}

}
