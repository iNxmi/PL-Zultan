package com.nami.api.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.cmd.response.Response;

public interface APICommandExecutor {

	public abstract Response onCommand(APICommand apiCommand, CommandSender sender, Command command, String label,
			String[] args);

}
