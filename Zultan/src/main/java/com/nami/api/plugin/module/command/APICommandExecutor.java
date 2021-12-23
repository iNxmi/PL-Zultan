package com.nami.api.plugin.module.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.plugin.module.command.response.Response;

public interface APICommandExecutor {

	public abstract Response onCommand(APICommand apiCommand, CommandSender sender, Command command, String label,
			String[] args);

}
