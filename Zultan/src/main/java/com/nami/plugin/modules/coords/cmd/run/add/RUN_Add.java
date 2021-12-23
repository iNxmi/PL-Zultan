package com.nami.plugin.modules.coords.cmd.run.add;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nami.api.plugin.module.command.APICommand;
import com.nami.api.plugin.module.command.APICommandExecutor;
import com.nami.api.plugin.module.command.response.ErrorResponse;
import com.nami.api.plugin.module.command.response.Response;
import com.nami.api.util.DataContainer;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Add implements APICommandExecutor {

	private DataContainer<String, Map<String, Integer>> data;

	public RUN_Add(DataContainer<String, Map<String, Integer>> data) {
		this.data = data;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Response onCommand(APICommand apiCommande, CommandSender sender, Command command, String label,
			String[] args) {

		if (data.getData().containsKey(args[1]))
			return new ErrorResponse("Coordinate '" + args[1] + "' already exists!");

		Player p = (Player) sender;
		Location loc = p.getLocation();

		Map<String, Integer> rawData = new HashMap<>();
		rawData.put("x", loc.getBlockX());
		rawData.put("y", loc.getBlockY());
		rawData.put("z", loc.getBlockZ());
		rawData.put("d", loc.getWorld().getEnvironment().getId());

		data.getData().put(args[1], rawData);

		try {
			data.save();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.INTERNAL_ERROR;
		}

		Plugin.logger.send(MessageType.NONE, sender, args[1] + " has been added!");

		return Response.SUCCESS;
	}

}
