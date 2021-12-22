package com.nami.plugin.modules.chatutils.cmd;

import com.nami.api.cmd.APICommand;
import com.nami.api.cmd.CommandCase.SenderScope;
import com.nami.api.sys.APIModule;
import com.nami.plugin.modules.chatutils.cmd.run.RUN_Clear;

public class CMD_ChatUtils extends APICommand {

	public CMD_ChatUtils(APIModule module) {
		super(module, "chatutils");

		addCase(new RUN_Clear(), "clear", "zultan.chatutils.clear", SenderScope.BOTH);
	}

}
