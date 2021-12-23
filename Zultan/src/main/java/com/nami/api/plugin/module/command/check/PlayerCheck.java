package com.nami.api.plugin.module.command.check;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nami.api.plugin.module.APIModule;
import com.nami.api.plugin.module.command.response.Response;

public class PlayerCheck implements Check {

	@Override
	public CheckResponse check(APIModule module, CommandSender sender, Command cmd, String label, String arg) {
		Player p = Bukkit.getPlayerExact(arg);
		if (p == null)
			return new CheckResponse(true, Response.TARGET_NOT_EXIST);
		if (!p.isOnline())
			return new CheckResponse(true, Response.TARGET_NOT_ONLINE);
		if (p == sender)
			return new CheckResponse(true, Response.TARGET_NOT_PLAYER);

		return new CheckResponse(false, null);
	}

}
