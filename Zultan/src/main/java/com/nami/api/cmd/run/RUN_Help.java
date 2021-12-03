package com.nami.api.cmd.run;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.cmd.APICommand;
import com.nami.api.cmd.APICommandExecutor;
import com.nami.api.cmd.CommandCase;
import com.nami.api.cmd.response.Response;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Help implements APICommandExecutor {

	@Override
	public Response onCommand(APICommand apiCommand, CommandSender sender, Command command, String label,
			String[] args) {

		for(CommandCase c : apiCommand.getCommandCases())
			Plugin.logger.send(MessageType.NONE, sender, c.getPermission());
		
		return Response.COMMING_SOON;
	}

}
