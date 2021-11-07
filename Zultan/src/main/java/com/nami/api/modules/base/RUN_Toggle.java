package com.nami.api.modules.base;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import com.nami.api.cmd.CommandRunnable;
import com.nami.api.cmd.response.Response;
import com.nami.api.cmd.response.ResponseError;
import com.nami.api.sys.APIPlugin;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Toggle implements CommandRunnable {

	@Override
	public Response onCommand(APIPlugin plugin, @NotNull CommandSender sender, @NotNull Command command,
			@NotNull String label, @NotNull String[] args) {

		if (!plugin.getActiveModules().getData().containsKey(args[1]))
			return new ResponseError("Module '" + args[1] + "' does not exist!");

		boolean old = plugin.getActiveModules().getData().get(args[1]);
		plugin.getActiveModules().getData().remove(args[1]);
		plugin.getActiveModules().getData().put(args[1], !old);

		Plugin.logger.send(MessageType.NONE, sender, "Module '" + args[1] + "' has been set to " + !old + "!");

		return Response.SUCCESS;
	}

}
