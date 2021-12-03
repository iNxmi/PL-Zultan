package com.nami.api.modules.base.cmd.run;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.cmd.APICommand;
import com.nami.api.cmd.APICommandExecutor;
import com.nami.api.cmd.response.Response;

public class RUN_Toggle implements APICommandExecutor {

	// TODO make shit work

	@Override
	public Response onCommand(APICommand apiCommand, CommandSender sender, Command command, String label,
			String[] args) {
//		APIPlugin plugin = apiCommand.getModule().getPlugin();
//		String moduleId = args[1].toLowerCase();
//
//		if (!plugin.getModules().containsKey(moduleId))
//			return new ErrorResponse("Module '" + moduleId + "' does not exist!");
//
//		APIModule selectedModule = plugin.getModules().get(moduleId);
//		boolean old = selectedModule.isEnabled();
//		selectedModule.setEnabled(!old);
//
//		Plugin.logger.send(MessageType.NONE, sender, "Module '" + moduleId + "' has been set to " + !old + "!");

		return Response.COMMING_SOON;
	}

}
