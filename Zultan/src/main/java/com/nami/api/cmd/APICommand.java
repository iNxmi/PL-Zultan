package com.nami.api.cmd;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import com.nami.api.cmd.response.Response;
import com.nami.api.sys.APIModule;
import com.nami.api.sys.APIPlugin;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public abstract class APICommand implements CommandExecutor {

	public static final List<String> placeholders = new ArrayList<>();
	public static final String PLACEHOLDER_STRING = "%string";
	public static final String PLACEHOLDER_NUMBER = "%number";
	public static final String PLACEHOLDER_PLAYER = "%player";

	private APIModule module;
	private String name;
	private List<CommandCase> cases;

	public APICommand(APIModule module, String name) {
		this.module = module;
		this.name = name;
		this.cases = new ArrayList<CommandCase>();

		placeholders.add(PLACEHOLDER_STRING);
		placeholders.add(PLACEHOLDER_NUMBER);
		placeholders.add(PLACEHOLDER_PLAYER);
	}

	public void addCase(APICommandExecutor runnable, String args, String permission, SenderScope scope) {
		String[] list = (args.isEmpty() ? new String[0] : args.trim().split(" "));
		cases.add(new CommandCase(runnable, list, permission, scope));
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
			@NotNull String[] args) {
		APIPlugin plugin = module.getPlugin();

		if (plugin.getActiveModules().getData().get(module.getName()) || module.isForceEnabled()) {
			Response code = Response.NONE;

			if (command.getName().equalsIgnoreCase(name))
				for (CommandCase cc : cases) {
					code = cc.execute(plugin, sender, command, label, args);
					if (code != Response.NONE)
						break;
				}

			if (code == Response.NONE)
				code = Response.SYNTAX_ERROR;

			if (code != Response.SUCCESS)
				Plugin.logger.send(code.getMessageType(), sender, code.getMessage());
		} else {
			Plugin.logger.send(MessageType.ERROR, sender, "Module '" + module.getName() + "' is not enabled!");
		}

		return true;
	}

	public APIModule getModule() {
		return module;
	}

	public String getName() {
		return name;
	}

}
