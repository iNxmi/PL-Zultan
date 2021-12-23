package com.nami.api.plugin.module.command;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.nami.api.plugin.module.command.check.ByteCheck;
import com.nami.api.plugin.module.command.check.Check;
import com.nami.api.plugin.module.command.check.CheckResponse;
import com.nami.api.plugin.module.command.check.DoubleCheck;
import com.nami.api.plugin.module.command.check.FloatCheck;
import com.nami.api.plugin.module.command.check.IntegerCheck;
import com.nami.api.plugin.module.command.check.LongCheck;
import com.nami.api.plugin.module.command.check.PlayerCheck;
import com.nami.api.plugin.module.command.check.ShortCheck;
import com.nami.api.plugin.module.command.check.StringCheck;
import com.nami.api.plugin.module.command.response.Response;

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

	public Response execute(APICommand apiCommand, CommandSender sender, Command cmd, String label, String[] args) {
		if (this.args.length != args.length)
			return Response.NONE;

		for (int i = 0; i < args.length; i++)
			if (!(this.args[i].equalsIgnoreCase(args[i]) || Argument.getLookup().containsKey(this.args[i])))
				return Response.NONE;

		if (sender instanceof Player && scope == SenderScope.CONSOLE && scope != SenderScope.BOTH)
			return Response.NOT_CONSOLE;

		if (sender instanceof ConsoleCommandSender && scope == SenderScope.PLAYER && scope != SenderScope.BOTH)
			return Response.NOT_PLAYER;

		if (!(sender.hasPermission(permission) || sender.hasPermission("*")))
			return Response.NO_PERM;

		for (int i = 0; i < args.length; i++)
			if (Argument.getLookup().containsKey(this.args[i])) {
				Argument arg = Argument.getArgument(this.args[i]);
				CheckResponse response = arg.check(apiCommand, sender, cmd, label, args[i]);
				if (response.shouldReturn())
					return response.getResponse();
			}

		return executor.onCommand(apiCommand, sender, cmd, label, args);
	}

	public enum Argument {
		BYTE("%byte", new ByteCheck()), SHORT("%short", new ShortCheck()), INETEGR("%integer", new IntegerCheck()),
		LONG("%long", new LongCheck()), FLOAT("%float", new FloatCheck()), DOUBLE("%double", new DoubleCheck()),
		STRING("%string", new StringCheck()), PLAYER("%player", new PlayerCheck());

		private String prefix;
		private Check check;
		private static final Map<String, Argument> lookup = new HashMap<String, Argument>();

		Argument(String prefix, Check check) {
			this.prefix = prefix;
			this.check = check;
		}

		public String getPrefix() {
			return prefix;
		}

		public CheckResponse check(APICommand apiCommand, CommandSender sender, Command cmd, String label, String arg) {
			return check.check(apiCommand.getModule(), sender, cmd, label, arg);
		}

		public static Argument getArgument(String prefix) {
			return lookup.get(prefix);
		}

		public static Map<String, Argument> getLookup() {
			return lookup;
		}

		static {
			for (Argument a : values())
				lookup.put(a.getPrefix(), a);
		}
	}

	public enum SenderScope {
		PLAYER(), CONSOLE(), BOTH();
	}

	public String getPermission() {
		return permission;
	}

	public String[] getArgs() {
		return args;
	}

}
