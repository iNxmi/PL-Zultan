package com.nami.plugin.modules.chatutils.cmd;

import com.nami.api.plugin.module.APIModule;
import com.nami.api.plugin.module.command.APICommand;
import com.nami.api.plugin.module.command.CommandCase.SenderScope;
import com.nami.plugin.modules.chatutils.cmd.run.RUN_Clear;

public class CMD_ChatUtils extends APICommand {

	public CMD_ChatUtils(APIModule module) {
		super(module, "chatutils");

		addCase(new RUN_Clear(), "clear", "zultan.chatutils.clear", SenderScope.BOTH);
	}

}
