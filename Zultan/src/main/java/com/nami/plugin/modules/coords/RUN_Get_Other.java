package com.nami.plugin.modules.coords;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import com.nami.api.cmd.CommandRunnable;
import com.nami.api.cmd.ResponseCode;
import com.nami.api.sys.APIPlugin;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Get_Other implements CommandRunnable {

	@Override
	public ResponseCode onCommand(APIPlugin plugin, @NotNull CommandSender sender, @NotNull Command command,
			@NotNull String label, @NotNull String[] args) {

		Player t = Bukkit.getPlayer(args[1]);
		if (t == null)
			return ResponseCode.TARGET_NOT_EXIST;
		if (!t.isOnline())
			return ResponseCode.TARGET_NOT_ONLINE;
		if (t == sender)
			return ResponseCode.TARGET_NOT_PLAYER;

		Plugin.logger.send(MessageType.NONE, sender,
				"Position from " + t.getName() + " is §4X: " + t.getLocation().getBlockX() + " §aY: "
						+ t.getLocation().getBlockY() + " §9Z: " + t.getLocation().getBlockZ() + " §rDim: "
						+ t.getWorld().getEnvironment());

		return ResponseCode.SUCCESS;
	}

}
