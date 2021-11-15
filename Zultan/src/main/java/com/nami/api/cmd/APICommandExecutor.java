package com.nami.api.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import com.nami.api.cmd.response.Response;
import com.nami.api.sys.APIModule;

public interface APICommandExecutor {

	public Response onCommand(APIModule module, @NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
			@NotNull String[] args);

}
