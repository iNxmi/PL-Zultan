package com.nami.api.modules.base.cmd.run;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.cmd.APICommand;
import com.nami.api.cmd.APICommandExecutor;
import com.nami.api.cmd.response.Response;
import com.nami.api.sys.APIModule;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_List implements APICommandExecutor {

	@Override
	public Response onCommand(APICommand apiCommand, CommandSender sender, Command command, String label,
			String[] args) {

		for (APIModule m : apiCommand.getModule().getPlugin().getModules().values())
			Plugin.logger.send(MessageType.NONE, sender, (m.isEnabled() ? "§a" : "§c") + m.getID());

		return Response.SUCCESS;
	}

}
