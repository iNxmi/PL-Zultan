package com.nami.api.plugin.module.command.run;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.plugin.module.command.APICommand;
import com.nami.api.plugin.module.command.APICommandExecutor;
import com.nami.api.plugin.module.command.CommandCase;
import com.nami.api.plugin.module.command.response.Response;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Help implements APICommandExecutor {

	@Override
	public Response onCommand(APICommand apiCommand, CommandSender sender, Command command, String label,
			String[] args) {

		for (CommandCase c : apiCommand.getCommandCases())
			Plugin.logger.send(MessageType.NONE, sender, String.join(" ", c.getArgs()));

		return Response.SUCCESS;
	}

}
