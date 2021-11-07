package com.nami.plugin.modules.coords;

import java.io.IOException;
import java.util.Map;

import com.nami.api.cmd.APICommand;
import com.nami.api.cmd.SenderScope;
import com.nami.api.sys.APIModule;
import com.nami.api.util.DataContainer;
import com.nami.plugin.modules.coords.cmd.coords.tp.RUN_Tp_Other;
import com.nami.plugin.modules.coords.cmd.coords.tp.RUN_Tp_Self;

public class CMD_coords extends APICommand {

	private DataContainer<String, Map<String, Integer>> data;

	public CMD_coords(APIModule module) {
		super(module, "coords");

		data = new DataContainer<>(module.getPlugin().getDataFolder().getAbsolutePath().concat("/data.json"));
		try {
			data.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		addCase(new RUN_Get_Self(), "get", "zultan.coords.get.self", SenderScope.PLAYER);
		addCase(new RUN_Get_Other(), "get %player", "zultan.coords.get.other", SenderScope.BOTH);

		addCase(new RUN_Publish_Self(), "publish", "zultan.coords.publish.self", SenderScope.PLAYER);
		addCase(new RUN_Publish_Other(), "publish %player", "zultan.coords.publish.other", SenderScope.BOTH);

//		addCase(new RUN_Toggle_Self(), "toggle", "zultan.coords.toggle.self", SenderScope.PLAYER);
//		addCase(new RUN_Toggle_Other(), "toggle %player", "zultan.coords.toggle.other", SenderScope.BOTH);

		addCase(new RUN_Tp_Self(data), "tp %string", "zultan.coords.tp.self", SenderScope.PLAYER);
		addCase(new RUN_Tp_Other(data), "tp %string %player", "zultan.coords.tp.other", SenderScope.BOTH);

		addCase(new RUN_Add(data), "add %string", "zultan.coords.add", SenderScope.PLAYER);
		addCase(new RUN_Add_XYZD(data), "add %string %number %number %number %number", "zultan.coords.add",
				SenderScope.BOTH);
		
		addCase(new RUN_Remove(data), "remove %string", "zultan.coords.remove", SenderScope.BOTH);
		
		addCase(new RUN_Clear(data), "clear", "zultan.coords.clear", SenderScope.BOTH);
		
		addCase(new RUN_List(data), "list", "zultan.coords.list", SenderScope.BOTH);
	}

}
