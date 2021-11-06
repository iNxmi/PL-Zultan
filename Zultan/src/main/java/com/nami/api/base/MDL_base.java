package com.nami.api.base;

import com.nami.api.sys.APIModule;
import com.nami.api.sys.APIPlugin;

public class MDL_base extends APIModule {

	public MDL_base(APIPlugin plugin) {
		super(plugin, "base");
	}

	@Override
	public void onInit() {
		addCommand(new CMD_modules(getPlugin()));
	}

}
