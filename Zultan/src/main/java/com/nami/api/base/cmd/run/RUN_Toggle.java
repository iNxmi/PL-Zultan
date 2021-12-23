package com.nami.api.base.cmd.run;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.plugin.APIPlugin;
import com.nami.api.plugin.APIPlugin.State;
import com.nami.api.plugin.module.command.APICommand;
import com.nami.api.plugin.module.command.APICommandExecutor;
import com.nami.api.plugin.module.command.response.ErrorResponse;
import com.nami.api.plugin.module.command.response.Response;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Toggle implements APICommandExecutor {

	@Override
	public Response onCommand(APICommand apiCommand, CommandSender sender, Command command, String label,
			String[] args) {

		APIPlugin plugin = apiCommand.getModule().getPlugin();
		String moduleId = args[1].toLowerCase();

		if (!plugin.getModules().containsKey(moduleId))
			return new ErrorResponse("Module '" + moduleId + "' does not exist!");

		plugin.getModules().get(moduleId).setEnabled(!plugin.getModules().get(moduleId).isEnabled());

		try {
			plugin.saveEnabled(State.CURRENT);
			plugin.enableModules();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.INTERNAL_ERROR;
		}

		Plugin.logger.send(MessageType.NONE, sender,
				"Module '" + moduleId + "' has been set to " + plugin.getModules().get(moduleId).isEnabled() + "!");

		return Response.SUCCESS;
	}

}
