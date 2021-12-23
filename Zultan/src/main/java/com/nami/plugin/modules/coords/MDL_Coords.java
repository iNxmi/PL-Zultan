package com.nami.plugin.modules.coords;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.nami.api.plugin.APIPlugin;
import com.nami.api.plugin.module.APIModule;
import com.nami.plugin.modules.coords.cmd.CMD_Coords;
import com.nami.plugin.modules.coords.evt.EVT_Move;

public class MDL_Coords extends APIModule {

	private List<UUID> players;

	public MDL_Coords(APIPlugin plugin) {
		super(plugin, "coords", false);

		players = new ArrayList<>();

		addCommand(new CMD_Coords(this, players));
		addEvent(new EVT_Move(this, players));
	}

}
