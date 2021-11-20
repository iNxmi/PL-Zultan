package com.nami.api.cmd.check;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nami.api.cmd.response.Response;
import com.nami.api.sys.APIModule;

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
