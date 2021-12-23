package com.nami.api.base;

import com.nami.api.base.cmd.CMD_Modules;
import com.nami.api.plugin.APIPlugin;
import com.nami.api.plugin.module.APIModule;

public class MDL_Base extends APIModule {

	public MDL_Base(APIPlugin plugin) {
		super(plugin, "base", true);

		addCommand(new CMD_Modules(this));
	}

}
