package com.nami.api.modules.base;

import com.nami.api.cmd.APICommand;
import com.nami.api.cmd.SenderScope;
import com.nami.api.sys.APIModule;

public class CMD_modules extends APICommand {

	public CMD_modules(APIModule module) {
		super(module, "modules");
		
		addCase(new RUN_List(), "list", "zultan.base.modules.list", SenderScope.BOTH);
		addCase(new RUN_Toggle(), "toggle %", "zultan.base.modules.toggle", SenderScope.BOTH);
		addCase(new RUN_Reload(), "reload", "zultan.base.modules.reload", SenderScope.BOTH);
	}

}
