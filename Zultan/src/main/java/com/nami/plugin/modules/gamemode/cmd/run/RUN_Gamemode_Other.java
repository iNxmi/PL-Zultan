package com.nami.plugin.modules.gamemode.cmd.run;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nami.api.plugin.module.command.APICommand;
import com.nami.api.plugin.module.command.APICommandExecutor;
import com.nami.api.plugin.module.command.response.ErrorResponse;
import com.nami.api.plugin.module.command.response.Response;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Gamemode_Other implements APICommandExecutor {

	@Override
	public Response onCommand(APICommand apiCommand, CommandSender sender, Command command, String label,
			String[] args) {
		Player t = Bukkit.getPlayer(args[1]);

		int index = Integer.parseInt(args[0]);
		if (!(index >= 0 && index <= 3))
			return new ErrorResponse("Gamemode number has to be in range 0-3!");

		//TODO shit is deprecated!
		@SuppressWarnings("deprecation")
		GameMode gm = GameMode.getByValue(index);
		t.setGameMode(gm);

		Plugin.logger.send(MessageType.NONE, sender, t.getName() + " is now in " + gm.name());

		return Response.SUCCESS;
	}

}
