package com.nami.api.modules.base.cmd;

import com.nami.api.cmd.APICommand;
import com.nami.api.cmd.CommandCase.SenderScope;
import com.nami.api.modules.base.cmd.run.RUN_List;
import com.nami.api.modules.base.cmd.run.RUN_Reload;
import com.nami.api.modules.base.cmd.run.RUN_Toggle;
import com.nami.api.sys.APIModule;

public class CMD_modules extends APICommand {

	public CMD_modules(APIModule module) {
		super(module, "modules");
		
		addCase(new RUN_List(), "list", "zultan.base.modules.list", SenderScope.BOTH);
		addCase(new RUN_Toggle(), "toggle %string", "zultan.base.modules.toggle", SenderScope.BOTH);
		addCase(new RUN_Reload(), "reload", "zultan.base.modules.reload", SenderScope.BOTH);
	}

}
