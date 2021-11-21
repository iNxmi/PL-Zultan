package com.nami.api.cmd.check;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.cmd.response.Response;
import com.nami.api.sys.APIModule;

public class FloatCheck implements Check {

	@Override
	public CheckResponse check(APIModule module, CommandSender sender, Command cmd, String label, String arg) {
		try {
			Float.parseFloat(arg);
		} catch (NumberFormatException e) {
			return new CheckResponse(true, Response.NOT_FLOAT);
		}
		return new CheckResponse(false, null);
	}

}
