package com.nami.plugin.modules.coords.cmd.run;

import java.io.IOException;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.nami.api.plugin.module.command.APICommand;
import com.nami.api.plugin.module.command.APICommandExecutor;
import com.nami.api.plugin.module.command.response.Response;
import com.nami.api.util.DataContainer;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_Clear implements APICommandExecutor {

	private DataContainer<String, Map<String, Integer>> data;

	public RUN_Clear(DataContainer<String, Map<String, Integer>> data) {
		this.data = data;
	}

	@Override
	public Response onCommand(APICommand apiCommand, CommandSender sender, Command command, String label,
			String[] args) {
		data.getData().clear();

		try {
			data.save();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.INTERNAL_ERROR;
		}

		Plugin.logger.send(MessageType.NONE, sender, "Coords have been cleared succesfully!");

		return Response.SUCCESS;
	}

}
