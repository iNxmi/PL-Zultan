package com.nami.api.modules.base.cmd.run;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.cmd.APICommand;
import com.nami.api.cmd.APICommandExecutor;
import com.nami.api.cmd.response.Response;

public class RUN_Reload implements APICommandExecutor {

	@Override
	public Response onCommand(APICommand apiCommand, CommandSender sender, Command command, String label,
			String[] args) {

		try {
			apiCommand.getModule().getPlugin().enableModules();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.INTERNAL_ERROR;
		}
		
		return Response.SUCCESS;
	}

}
