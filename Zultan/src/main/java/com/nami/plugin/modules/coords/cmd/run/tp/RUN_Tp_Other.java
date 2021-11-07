package com.nami.plugin.modules.coords.cmd.run.tp;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import com.nami.api.cmd.APICommandExecutor;
import com.nami.api.cmd.response.Response;
import com.nami.api.sys.APIPlugin;
import com.nami.api.util.DataContainer;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Tp_Other implements APICommandExecutor {

	private DataContainer<String, Map<String, Integer>> data;

	public RUN_Tp_Other(DataContainer<String, Map<String, Integer>> data) {
		this.data = data;
	}

	@Override
	public Response onCommand(APIPlugin plugin, @NotNull CommandSender sender, @NotNull Command command,
			@NotNull String label, @NotNull String[] args) {

		Map<String, Integer> rawData = data.getData().get(args[1]);

		Player t = Bukkit.getPlayer(args[2]);
		t.teleport(new Location(t.getWorld(), rawData.get("x") + .5, rawData.get("y") + .5, rawData.get("z") + .5));

		Plugin.logger.send(MessageType.NONE, sender, "Teleported '" + t.getName() + "' to " + args[1]);

		return Response.SUCCESS;
	}

}
