package com.nami.plugin.modules.coords.cmd.run;

import java.io.IOException;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.cmd.APICommand;
import com.nami.api.cmd.APICommandExecutor;
import com.nami.api.cmd.response.ErrorResponse;
import com.nami.api.cmd.response.Response;
import com.nami.api.util.DataContainer;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Remove implements APICommandExecutor {

	private DataContainer<String, Map<String, Integer>> data;

	public RUN_Remove(DataContainer<String, Map<String, Integer>> data) {
		this.data = data;
	}

	@Override
	public Response onCommand(APICommand apiCommand, CommandSender sender, Command command, String label,
			String[] args) {
		if (!data.getData().containsKey(args[1]))
			return new ErrorResponse(args[1] + " does not exist!");

		data.getData().remove(args[1]);

		try {
			data.save();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.INTERNAL_ERROR;
		}

		Plugin.logger.send(MessageType.NONE, sender, args[1] + " has been succesfully removed!");

		return Response.SUCCESS;
	}

}
