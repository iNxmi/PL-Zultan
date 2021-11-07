package com.nami.plugin.modules.coords.cmd.run.add;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import com.nami.api.cmd.APICommandExecutor;
import com.nami.api.cmd.response.Response;
import com.nami.api.cmd.response.ErrorResponse;
import com.nami.api.sys.APIPlugin;
import com.nami.api.util.DataContainer;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Add_XYZD implements APICommandExecutor {

	private DataContainer<String, Map<String, Integer>> data;

	public RUN_Add_XYZD(DataContainer<String, Map<String, Integer>> data) {
		this.data = data;
	}

	@Override
	public Response onCommand(APIPlugin plugin, @NotNull CommandSender sender, @NotNull Command command,
			@NotNull String label, @NotNull String[] args) {

		if (data.getData().containsKey(args[1]))
			return new ErrorResponse("Coordinate '" + args[1] + "' already exists!");
		
		Map<String, Integer> rawData = new HashMap<>();
		rawData.put("x", Integer.parseInt(args[2]));
		rawData.put("y", Integer.parseInt(args[3]));
		rawData.put("z", Integer.parseInt(args[4]));
		rawData.put("d", Integer.parseInt(args[5]));

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
