package com.nami.plugin.modules.coords;

import com.nami.api.cmd.APICommand;
import com.nami.api.cmd.SenderScope;
import com.nami.api.sys.APIModule;

public class CMD_coords extends APICommand {

	public CMD_coords(APIModule module) {
		super(module, "coords");
	}

	@Override
	public void init() {
		addCase(new RUN_Get_Self(), "get", "zultan.coords.get.self", SenderScope.PLAYER);
		addCase(new RUN_Get_Other(), "get %", "zultan.coords.get.other", SenderScope.BOTH);
	}

}
