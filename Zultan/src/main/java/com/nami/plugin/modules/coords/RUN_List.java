package com.nami.plugin.modules.coords;

import java.util.Map;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import com.nami.api.cmd.APICommandExecutor;
import com.nami.api.cmd.response.Response;
import com.nami.api.sys.APIPlugin;
import com.nami.api.util.DataContainer;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public class RUN_List implements APICommandExecutor {

	private DataContainer<String, Map<String, Integer>> data;

	public RUN_List(DataContainer<String, Map<String, Integer>> data) {
		this.data = data;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Response onCommand(APIPlugin plugin, @NotNull CommandSender sender, @NotNull Command command,
			@NotNull String label, @NotNull String[] args) {

		for (Map.Entry<String, Map<String, Integer>> e : data.getData().entrySet())
			Plugin.logger.send(MessageType.NONE, sender,
					e.getKey() + " X: " + e.getValue().get("x") + " Y: " + e.getValue().get("y") + " Z: "
							+ e.getValue().get("z") + " Dim: "
							+ World.Environment.getEnvironment(e.getValue().get("d")));

		return Response.SUCCESS;
	}

}
