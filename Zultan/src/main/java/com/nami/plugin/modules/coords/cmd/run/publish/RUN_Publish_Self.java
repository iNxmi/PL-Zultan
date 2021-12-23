package com.nami.plugin.modules.coords.cmd.run.publish;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nami.api.plugin.module.command.APICommand;
import com.nami.api.plugin.module.command.APICommandExecutor;
import com.nami.api.plugin.module.command.response.Response;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Publish_Self implements APICommandExecutor {

	@Override
	public Response onCommand(APICommand apiCommand, CommandSender sender, Command command, String label,
			String[] args) {

		Player p = (Player) sender;
		Location loc = p.getLocation();
		Plugin.logger.broadcast(MessageType.NONE, p.getName() + "'s location is §4X: " + loc.getBlockX() + " §aY: "
				+ loc.getBlockY() + " §9Z: " + loc.getBlockZ() + " §rDim: " + loc.getWorld().getEnvironment().name());

		return Response.SUCCESS;
	}

}
