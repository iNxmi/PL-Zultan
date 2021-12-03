package com.nami.plugin.modules.gamemode.cmd.run;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nami.api.cmd.APICommand;
import com.nami.api.cmd.APICommandExecutor;
import com.nami.api.cmd.response.ErrorResponse;
import com.nami.api.cmd.response.Response;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Gamemode_Self implements APICommandExecutor {

	@Override
	public Response onCommand(APICommand apiCommand, CommandSender sender, Command command, String label,
			String[] args) {
		Player p = (Player) sender;

		int index = Integer.parseInt(args[0]);
		if (!(index >= 0 && index <= 3))
			return new ErrorResponse("Gamemode number has to be in range 0-3!");

		GameMode gm = GameMode.getByValue(index);
		p.setGameMode(gm);

		Plugin.logger.send(MessageType.NONE, p, "You now in " + gm.name());

		return Response.SUCCESS;
	}

}
