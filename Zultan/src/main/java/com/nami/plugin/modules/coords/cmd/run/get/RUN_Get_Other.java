package com.nami.plugin.modules.coords.cmd.run.get;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import com.nami.api.cmd.APICommandExecutor;
import com.nami.api.cmd.response.Response;
import com.nami.api.sys.APIPlugin;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Get_Other implements APICommandExecutor {

	@Override
	public Response onCommand(APIPlugin plugin, @NotNull CommandSender sender, @NotNull Command command,
			@NotNull String label, @NotNull String[] args) {

		Player t = Bukkit.getPlayer(args[1]);
		Location loc = t.getLocation();
		Plugin.logger.send(MessageType.NONE, sender, t.getName() + "'s location is §4X: " + loc.getBlockX() + " §aY: "
				+ loc.getBlockY() + " §9Z: " + loc.getBlockZ() + " §rDim: " + loc.getWorld().getEnvironment().name());

		return Response.SUCCESS;
	}

}
