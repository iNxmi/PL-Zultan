package com.nami.api.modules.base.cmd.run;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.cmd.APICommandExecutor;
import com.nami.api.cmd.response.ErrorResponse;
import com.nami.api.cmd.response.Response;
import com.nami.api.sys.APIModule;
import com.nami.api.sys.APIPlugin;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Toggle implements APICommandExecutor {

	@Override
	public Response onCommand(APIModule module, CommandSender sender, Command command, String label, String[] args) {
		APIPlugin plugin = module.getPlugin();
		String moduleId = args[1].toLowerCase();

		if (!plugin.getModules().containsKey(moduleId))
			return new ErrorResponse("Module '" + moduleId + "' does not exist!");

		APIModule selectedModule = plugin.getModules().get(moduleId);
		boolean old = selectedModule.isEnabled();
		selectedModule.setEnabled(!old);

		Plugin.logger.send(MessageType.NONE, sender, "Module '" + moduleId + "' has been set to " + !old + "!");

		return Response.SUCCESS;
	}

}
