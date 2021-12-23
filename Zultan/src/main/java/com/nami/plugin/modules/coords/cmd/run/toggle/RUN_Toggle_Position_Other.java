package com.nami.plugin.modules.coords.cmd.run.toggle;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nami.api.plugin.module.command.APICommand;
import com.nami.api.plugin.module.command.APICommandExecutor;
import com.nami.api.plugin.module.command.response.Response;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Toggle_Position_Other implements APICommandExecutor {

	private List<UUID> players;

	public RUN_Toggle_Position_Other(List<UUID> players) {
		this.players = players;
	}

	@Override
	public Response onCommand(APICommand apiCommand, CommandSender sender, Command command, String label,
			String[] args) {

		Player t = Bukkit.getPlayer(args[1]);
		if (players.contains(t.getUniqueId())) {
			players.remove(t.getUniqueId());
		} else {
			players.add(t.getUniqueId());
		}

		Plugin.logger.send(MessageType.NONE, sender, "toggled for player '" + t.getName() + "'");

		return Response.SUCCESS;
	}

}
