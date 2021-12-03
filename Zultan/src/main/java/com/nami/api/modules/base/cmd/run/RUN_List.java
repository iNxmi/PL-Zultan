package com.nami.api.modules.base.cmd.run;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.cmd.APICommand;
import com.nami.api.cmd.APICommandExecutor;
import com.nami.api.cmd.response.Response;

public class RUN_List implements APICommandExecutor {

	// TODO make shit work

	@Override
	public Response onCommand(APICommand apiCommand, CommandSender sender, Command command, String label,
			String[] args) {
//		APIPlugin plugin = apiCommand.getModule().getPlugin();
//		for (APIModule m : plugin.getModules().values()) {
//			boolean enabled = m.isEnabled();
//			Plugin.logger.send(MessageType.NONE, sender, (enabled ? "§a" : "§c") + m.getID() + ": " + enabled);
//		}

		return Response.COMMING_SOON;
	}

}
