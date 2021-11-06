package com.nami.api.base;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import com.nami.api.cmd.CommandRunnable;
import com.nami.api.cmd.ResponseCode;
import com.nami.api.sys.APIPlugin;

public class RUN_Reload implements CommandRunnable {

	@Override
	public ResponseCode onCommand(APIPlugin plugin, @NotNull CommandSender sender, @NotNull Command command,
			@NotNull String label, @NotNull String[] args) {
		
		
		
		return ResponseCode.SUCCESS;
	}

}
