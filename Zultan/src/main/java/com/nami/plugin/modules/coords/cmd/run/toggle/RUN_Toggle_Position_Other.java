package com.nami.plugin.modules.coords.cmd.run.toggle;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import com.nami.api.cmd.APICommandExecutor;
import com.nami.api.cmd.response.Response;
import com.nami.api.sys.APIPlugin;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Toggle_Position_Other implements APICommandExecutor {

	private List<UUID> players;

	public RUN_Toggle_Position_Other(List<UUID> players) {
		this.players = players;
	}

	@Override
	public Response onCommand(APIPlugin plugin, @NotNull CommandSender sender, @NotNull Command command,
			@NotNull String label, @NotNull String[] args) {

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
