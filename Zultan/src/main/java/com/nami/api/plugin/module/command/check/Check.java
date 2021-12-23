package com.nami.api.plugin.module.command.check;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.plugin.module.APIModule;

public interface Check {

	public CheckResponse check(APIModule module, CommandSender sender, Command cmd, String label, String arg);
	
}
