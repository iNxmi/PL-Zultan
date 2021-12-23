package com.nami.plugin.modules.coords.cmd.run.toggle;

import java.util.List;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nami.api.plugin.module.command.APICommand;
import com.nami.api.plugin.module.command.APICommandExecutor;
import com.nami.api.plugin.module.command.response.Response;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Toggle_Position_Self implements APICommandExecutor {

	private List<UUID> players;

	public RUN_Toggle_Position_Self(List<UUID> players) {
		this.players = players;
	}

	@Override
	public Response onCommand(APICommand apiCommand, CommandSender sender, Command command, String label,
			String[] args) {
		Player p = (Player) sender;
		if (players.contains(p.getUniqueId())) {
			players.remove(p.getUniqueId());
		} else {
			players.add(p.getUniqueId());
		}

		Plugin.logger.send(MessageType.NONE, sender, "toggled!");

		return Response.SUCCESS;
	}

}
