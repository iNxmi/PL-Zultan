package com.nami.api.modules.base.cmd.run;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.cmd.APICommand;
import com.nami.api.cmd.APICommandExecutor;
import com.nami.api.cmd.response.ErrorResponse;
import com.nami.api.cmd.response.Response;
import com.nami.api.sys.APIModule;
import com.nami.api.sys.APIPlugin;
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
			plugin.resetToEnable();
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
