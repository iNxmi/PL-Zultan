package com.nami.plugin.modules.coords.cmd.run.tp;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nami.api.plugin.module.command.APICommand;
import com.nami.api.plugin.module.command.APICommandExecutor;
import com.nami.api.plugin.module.command.response.ErrorResponse;
import com.nami.api.plugin.module.command.response.Response;
import com.nami.api.util.DataContainer;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Tp_Other implements APICommandExecutor {

	private DataContainer<String, Map<String, Integer>> data;

	public RUN_Tp_Other(DataContainer<String, Map<String, Integer>> data) {
		this.data = data;
	}

	@Override
	public Response onCommand(APICommand apiCommand, CommandSender sender, Command command, String label,
			String[] args) {
		if (!data.getData().containsKey(args[1]))
			return new ErrorResponse("Entry '" + args[1] + "' does not exist!");

		Map<String, Integer> rawData = data.getData().get(args[1]);

		Player t = Bukkit.getPlayer(args[2]);
		t.teleport(new Location(t.getWorld(), rawData.get("x") + .5, rawData.get("y") + .5, rawData.get("z") + .5));

		Plugin.logger.send(MessageType.NONE, sender, "Teleported '" + t.getName() + "' to " + args[1]);

		return Response.SUCCESS;
	}

}
