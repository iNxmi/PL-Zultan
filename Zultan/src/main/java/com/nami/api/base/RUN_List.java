package com.nami.api.base;

import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import com.nami.api.cmd.CommandRunnable;
import com.nami.api.cmd.ResponseCode;
import com.nami.api.sys.APIModule;
import com.nami.api.sys.APIPlugin;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_List implements CommandRunnable {

	@Override
	public ResponseCode onCommand(APIPlugin plugin, @NotNull CommandSender sender, @NotNull Command command,
			@NotNull String label, @NotNull String[] args) {

		for (Map.Entry<String, APIModule> en : plugin.getModules().entrySet())
			Plugin.logger.send(MessageType.NONE, sender,
					(en.getValue().isLoaded() ? "§a" : "§c") + en.getKey() + ": " + en.getValue().isLoaded());

		return ResponseCode.SUCCESS;
	}

}
