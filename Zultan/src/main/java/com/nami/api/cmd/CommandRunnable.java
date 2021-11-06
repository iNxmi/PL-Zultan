package com.nami.api.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import com.nami.api.sys.APIPlugin;

public interface CommandRunnable {

	public ResponseCode onCommand(APIPlugin plugin, @NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
			@NotNull String[] args);

}
