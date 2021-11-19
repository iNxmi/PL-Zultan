package com.nami.plugin.modules.gamemode.cmd;

import com.nami.api.cmd.APICommand;
import com.nami.api.cmd.SenderScope;
import com.nami.api.sys.APIModule;
import com.nami.plugin.modules.gamemode.cmd.run.RUN_Gamemode_Other;
import com.nami.plugin.modules.gamemode.cmd.run.RUN_Gamemode_Self;

public class CMD_Gamemode extends APICommand {

	public CMD_Gamemode(APIModule module) {
		super(module, "gamemode");

		addCase(new RUN_Gamemode_Self(), "%number", "zultan.gamemode.self", SenderScope.PLAYER);
		addCase(new RUN_Gamemode_Other(), "%number %player", "zultan.gamemode.other", SenderScope.BOTH);
	}

}
