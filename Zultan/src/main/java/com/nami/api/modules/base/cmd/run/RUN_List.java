package com.nami.api.modules.base.cmd.run;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.cmd.APICommandExecutor;
import com.nami.api.cmd.response.Response;
import com.nami.api.sys.APIModule;
import com.nami.api.sys.APIPlugin;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_List implements APICommandExecutor {

	@Override
	public Response onCommand(APIModule module, CommandSender sender, Command command, String label, String[] args) {
		APIPlugin plugin = module.getPlugin();
		for (APIModule m : plugin.getModules().values()) {
			boolean enabled = m.isEnabled();
			Plugin.logger.send(MessageType.NONE, sender, (enabled ? "§a" : "§c") + m.getID() + ": " + enabled);
		}

		return Response.SUCCESS;
	}

}
