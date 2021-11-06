package com.nami.api.cmd;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import com.nami.api.sys.APIPlugin;
import com.nami.api.util.MessageType;
import com.nami.plugin.Plugin;

public abstract class APICommand implements CommandExecutor {

	public static final String PLACEHOLDER = "%";

	private APIPlugin plugin;
	private String name;
	private List<CommandCase> cases;

	public APICommand(APIPlugin plugin, String name) {
		this.plugin = plugin;
		this.name = name;
		this.cases = new ArrayList<CommandCase>();

		init();
	}

	public abstract void init();

	public void addCase(CommandRunnable runnable, String args, String permission, SenderScope scope) {
		String[] list = (args.isEmpty() ? new String[0] : args.trim().split(" "));
		cases.add(new CommandCase(runnable, list, permission, scope));
	}

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
			@NotNull String[] args) {

		ResponseCode code = ResponseCode.NONE;

		if (command.getName().equalsIgnoreCase(name))
			for (CommandCase cc : cases) {
				code = cc.execute(plugin, sender, command, label, args);
				if (code == ResponseCode.SUCCESS)
					break;
			}

		if (code == ResponseCode.NONE)
			code = ResponseCode.SYNTAX_ERROR;

		return parseResponseCode(code, sender);
	}

	private boolean parseResponseCode(ResponseCode code, CommandSender sender) {
		switch (code) {
		case SUCCESS:
			return true;

		case SYNTAX_ERROR:
			Plugin.logger.send(MessageType.ERROR, sender, "no command with this syntax u moron");
			return false;

		case NO_PERM:
			Plugin.logger.send(MessageType.ERROR, sender, "no permissions bitch");
			return false;

		case NOT_PLAYER:
			Plugin.logger.send(MessageType.ERROR, sender, "u not a player little bastard");
			return false;

		case NOT_CONSOLE:
			Plugin.logger.send(MessageType.ERROR, sender, "this command has to be run by console u cunt");
			return false;

		case TARGET_NOT_EXIST:
			Plugin.logger.send(MessageType.ERROR, sender, "ur target not existing");
			return false;

		case TARGET_NOT_ONLINE:
			Plugin.logger.send(MessageType.ERROR, sender, "ur target cant be located fat boy");
			return false;

		case TARGET_NOT_PLAYER:
			Plugin.logger.send(MessageType.ERROR, sender, "u cant be target");
			return false;

		case INTERNAL_ERROR:
			Plugin.logger.send(MessageType.ERROR, sender, "hmm weird an internal error :|");
			return false;

		case NONE:
			return false;

		default:
			Plugin.logger.send(MessageType.WARNING, sender,
					"lol if u see this message you just found a bug :) i dont fucking know how but u did");
			return false;
		}
	}

	public APIPlugin getPlugin() {
		return plugin;
	}

	public String getName() {
		return name;
	}

}
