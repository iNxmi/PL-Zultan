package com.nami.api.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.nami.api.cmd.response.Response;
import com.nami.api.sys.APIModule;

public class CommandCase {

	private APICommandExecutor executor;
	private String[] args;
	private String permission;
	private SenderScope scope;

	public CommandCase(APICommandExecutor executor, String[] args, String permission, SenderScope scope) {
		this.executor = executor;
		this.args = args;
		this.permission = permission;
		this.scope = scope;
	}

	public Response execute(APIModule module, CommandSender sender, Command cmd, String label, String[] args) {
		if (this.args.length != args.length)
			return Response.NONE;

		for (int i = 0; i < args.length; i++)
			if (!(this.args[i].equalsIgnoreCase(args[i]) || APICommand.placeholders.contains(this.args[i])))
				return Response.NONE;

		if (sender instanceof Player && scope == SenderScope.CONSOLE && scope != SenderScope.BOTH)
			return Response.NOT_CONSOLE;

		if (sender instanceof ConsoleCommandSender && scope == SenderScope.PLAYER && scope != SenderScope.BOTH)
			return Response.NOT_PLAYER;

		if (!sender.hasPermission(permission) || !sender.hasPermission("*"))
			return Response.NO_PERM;

		for (int i = 0; i < args.length; i++)
			switch (this.args[i]) {
			case APICommand.PLACEHOLDER_NUMBER:
				if (!isNumber(args[i]))
					return Response.NOT_NUMBER;
				break;
			case APICommand.PLACEHOLDER_PLAYER:
				Player p = Bukkit.getPlayerExact(args[i]);
				if (p == null)
					return Response.TARGET_NOT_EXIST;
				if (!p.isOnline())
					return Response.TARGET_NOT_ONLINE;
				if (p == sender)
					return Response.TARGET_NOT_PLAYER;
				break;
			}

		return executor.onCommand(module, sender, cmd, label, args);
	}

	private boolean isNumber(String num) {
		try {
			Double.parseDouble(num);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
