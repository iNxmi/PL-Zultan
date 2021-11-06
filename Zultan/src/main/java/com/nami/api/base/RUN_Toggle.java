package com.nami.api.base;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import com.nami.api.cmd.CommandRunnable;
import com.nami.api.cmd.ResponseCode;
import com.nami.api.sys.APIPlugin;
import com.nami.api.util.DataContainer;

public class RUN_Toggle implements CommandRunnable {

	@Override
	public ResponseCode onCommand(APIPlugin plugin, @NotNull CommandSender sender, @NotNull Command command,
			@NotNull String label, @NotNull String[] args) {

		DataContainer<String, Boolean> data = plugin.getActivation();
		
		if(data.getData().containsKey(args[1]))
			return ResponseCode.INTERNAL_ERROR;
		
		boolean old = data.getData().get(args[1]);
		data.getData().remove(args[1]);
		data.getData().put(args[1], !old);
		
		try {
			plugin.getActivation().save();
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseCode.INTERNAL_ERROR;
		}

		return ResponseCode.SUCCESS;
	}

}
