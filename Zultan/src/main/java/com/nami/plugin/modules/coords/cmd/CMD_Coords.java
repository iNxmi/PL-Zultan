package com.nami.plugin.modules.coords.cmd;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.nami.api.plugin.module.APIModule;
import com.nami.api.plugin.module.command.APICommand;
import com.nami.api.plugin.module.command.CommandCase.SenderScope;
import com.nami.api.util.DataContainer;
import com.nami.plugin.modules.coords.cmd.run.RUN_Clear;
import com.nami.plugin.modules.coords.cmd.run.RUN_List;
import com.nami.plugin.modules.coords.cmd.run.RUN_Remove;
import com.nami.plugin.modules.coords.cmd.run.add.RUN_Add;
import com.nami.plugin.modules.coords.cmd.run.add.RUN_Add_XYZD;
import com.nami.plugin.modules.coords.cmd.run.get.RUN_Get_Other;
import com.nami.plugin.modules.coords.cmd.run.get.RUN_Get_Self;
import com.nami.plugin.modules.coords.cmd.run.publish.RUN_Publish_Other;
import com.nami.plugin.modules.coords.cmd.run.publish.RUN_Publish_Self;
import com.nami.plugin.modules.coords.cmd.run.toggle.RUN_Toggle_Position_Other;
import com.nami.plugin.modules.coords.cmd.run.toggle.RUN_Toggle_Position_Self;
import com.nami.plugin.modules.coords.cmd.run.tp.RUN_Tp_Other;
import com.nami.plugin.modules.coords.cmd.run.tp.RUN_Tp_Self;
import com.nami.plugin.modules.coords.cmd.run.update.RUN_Update;
import com.nami.plugin.modules.coords.cmd.run.update.RUN_Update_XYZD;

public class CMD_Coords extends APICommand {

	private DataContainer<String, Map<String, Integer>> data;

	public CMD_Coords(APIModule module, List<UUID> players) {
		super(module, "coords");

		data = new DataContainer<>(module.getFolder().getAbsolutePath().concat("/data.json"));
		try {
			data.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		addCase(new RUN_Get_Self(), "get", "zultan.coords.get.self", SenderScope.PLAYER);
		addCase(new RUN_Get_Other(), "get %player", "zultan.coords.get.other", SenderScope.BOTH);

		addCase(new RUN_Publish_Self(), "publish", "zultan.coords.publish.self", SenderScope.PLAYER);
		addCase(new RUN_Publish_Other(), "publish %player", "zultan.coords.publish.other", SenderScope.BOTH);

		addCase(new RUN_Toggle_Position_Self(players), "toggle position", "zultan.coords.toggle.self",
				SenderScope.PLAYER);
		addCase(new RUN_Toggle_Position_Other(players), "toggle position %player", "zultan.coords.toggle.other",
				SenderScope.BOTH);

		addCase(new RUN_Tp_Self(data), "tp %string", "zultan.coords.tp.self", SenderScope.PLAYER);
		addCase(new RUN_Tp_Other(data), "tp %string %player", "zultan.coords.tp.other", SenderScope.BOTH);

		addCase(new RUN_Add(data), "add %string", "zultan.coords.add", SenderScope.PLAYER);
		addCase(new RUN_Add_XYZD(data), "add %string %long %long %long %long", "zultan.coords.add", SenderScope.BOTH);

		addCase(new RUN_Update(data), "update %string", "zultan.coords.update", SenderScope.PLAYER);
		addCase(new RUN_Update_XYZD(data), "update %string %long %long %long %long", "zultan.coords.update",
				SenderScope.BOTH);

		addCase(new RUN_Remove(data), "remove %string", "zultan.coords.remove", SenderScope.BOTH);

		addCase(new RUN_Clear(data), "clear", "zultan.coords.clear", SenderScope.BOTH);

		addCase(new RUN_List(data), "list", "zultan.coords.list", SenderScope.BOTH);
	}

}
