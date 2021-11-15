package com.nami.plugin.modules.coords.cmd.run.get;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nami.api.cmd.APICommandExecutor;
import com.nami.api.cmd.response.Response;
import com.nami.api.sys.APIModule;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Get_Self implements APICommandExecutor {

	@Override
	public Response onCommand(APIModule module, CommandSender sender, Command command, String label, String[] args) {

		Player p = (Player) sender;
		Location loc = p.getLocation();
		Plugin.logger.send(MessageType.NONE, sender, "Your location is §4X: " + loc.getBlockX() + " §aY: "
				+ loc.getBlockY() + " §9Z: " + loc.getBlockZ() + " §rDim: " + loc.getWorld().getEnvironment().name());

		return Response.SUCCESS;
	}

}
