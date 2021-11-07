package com.nami.api.base;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import com.nami.api.cmd.CommandRunnable;
import com.nami.api.cmd.response.Response;
import com.nami.api.sys.APIPlugin;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Toggle implements CommandRunnable {

	@Override
	public Response onCommand(APIPlugin plugin, @NotNull CommandSender sender, @NotNull Command command,
			@NotNull String label, @NotNull String[] args) {

		// TODO make this shit work lalala lol im tired

//		if (!plugin.getToLoad().getData().containsKey(args[1]))
//			return new ResponseError("Module '" + args[1] + "' does not exist!");
//
//		boolean old = plugin.getToLoad().getData().get(args[1]);
//		plugin.getToLoad().getData().remove(args[1]);
//		plugin.getToLoad().getData().put(args[1], !old);

		Plugin.logger.send(MessageType.WARNING, sender, "Modules NOT reloaded caus the dev is tired!");

		return Response.SUCCESS;
	}

}
