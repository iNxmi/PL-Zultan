package com.nami.api.modules.base;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import com.nami.api.cmd.CommandRunnable;
import com.nami.api.cmd.response.Response;
import com.nami.api.sys.APIPlugin;

public class RUN_Reload implements CommandRunnable {

	@Override
	public Response onCommand(APIPlugin plugin, @NotNull CommandSender sender, @NotNull Command command,
			@NotNull String label, @NotNull String[] args) {

		//TODO make it work!

		return Response.SUCCESS;
	}

}
