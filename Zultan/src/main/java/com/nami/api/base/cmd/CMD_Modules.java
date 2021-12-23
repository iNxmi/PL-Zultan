package com.nami.api.base.cmd;

import com.nami.api.base.cmd.run.RUN_List;
import com.nami.api.base.cmd.run.RUN_Reload;
import com.nami.api.base.cmd.run.RUN_Toggle;
import com.nami.api.plugin.module.APIModule;
import com.nami.api.plugin.module.command.APICommand;
import com.nami.api.plugin.module.command.CommandCase.SenderScope;

public class CMD_Modules extends APICommand {

	public CMD_Modules(APIModule module) {
		super(module, "modules");

		addCase(new RUN_List(), "list", "zultan.base.modules.list", SenderScope.BOTH);
		addCase(new RUN_Toggle(), "toggle %string", "zultan.base.modules.toggle", SenderScope.BOTH);
		addCase(new RUN_Reload(), "reload", "zultan.base.modules.reload", SenderScope.BOTH);
	}

}
