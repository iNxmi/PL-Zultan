package com.nami.plugin.modules.coords.cmd.run.tp;

import java.util.Map;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nami.api.cmd.APICommandExecutor;
import com.nami.api.cmd.response.Response;
import com.nami.api.sys.APIModule;
import com.nami.api.util.DataContainer;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Tp_Self implements APICommandExecutor {

	private DataContainer<String, Map<String, Integer>> data;

	public RUN_Tp_Self(DataContainer<String, Map<String, Integer>> data) {
		this.data = data;
	}

	@Override
	public Response onCommand(APIModule module, CommandSender sender, Command command, String label, String[] args) {
		Map<String, Integer> rawData = data.getData().get(args[1]);

		Player p = (Player) sender;
		p.teleport(new Location(p.getWorld(), rawData.get("x") + .5, rawData.get("y") + .5, rawData.get("z") + .5));

		Plugin.logger.send(MessageType.NONE, sender, "Teleported to " + args[1]);

		return Response.SUCCESS;
	}

}
