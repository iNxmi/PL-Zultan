package com.nami.api.modules.base;

import com.nami.api.modules.base.cmd.CMD_modules;
import com.nami.api.sys.APIModule;
import com.nami.api.sys.APIPlugin;

public class MDL_base extends APIModule {

	public MDL_base(APIPlugin plugin) {
		super(plugin, "base", true);
		
		addCommand(new CMD_modules(this));
	}

}
