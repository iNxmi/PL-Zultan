package com.nami.api.base;

import com.nami.api.cmd.APICommand;
import com.nami.api.cmd.SenderScope;
import com.nami.api.sys.APIPlugin;

public class CMD_modules extends APICommand {

	public CMD_modules(APIPlugin plugin) {
		super(plugin, "modules");
	}

	@Override
	public void init() {
		addCase(new RUN_List(), "list", getPlugin().getName().concat(".base.modules.list"), SenderScope.BOTH);
		addCase(new RUN_List(), "toggle %", getPlugin().getName().concat(".base.modules.toggle"), SenderScope.BOTH);
	}

}
