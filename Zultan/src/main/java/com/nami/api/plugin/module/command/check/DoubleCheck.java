package com.nami.api.plugin.module.command.check;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.plugin.module.APIModule;
import com.nami.api.plugin.module.command.response.Response;

public class DoubleCheck implements Check {

	@Override
	public CheckResponse check(APIModule module, CommandSender sender, Command cmd, String label, String arg) {
		try {
			Double.parseDouble(arg);
		} catch (NumberFormatException e) {
			return new CheckResponse(true, Response.NOT_DOUBLE);
		}
		return new CheckResponse(false, null);
	}

}
