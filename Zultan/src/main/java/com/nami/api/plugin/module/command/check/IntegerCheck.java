package com.nami.api.plugin.module.command.check;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.plugin.module.APIModule;
import com.nami.api.plugin.module.command.response.Response;

public class IntegerCheck implements Check {

	@Override
	public CheckResponse check(APIModule module, CommandSender sender, Command cmd, String label, String arg) {
		try {
			Integer.parseInt(arg);
		} catch (NumberFormatException e) {
			return new CheckResponse(true, Response.NOT_INTEGER);
		}
		return new CheckResponse(false, null);
	}

}
