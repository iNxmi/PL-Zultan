package com.nami.api.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.cmd.response.Response;
import com.nami.api.sys.APIModule;

public interface APICommandExecutor {

	public Response onCommand(APIModule module, CommandSender sender, Command command, String label, String[] args);

}
