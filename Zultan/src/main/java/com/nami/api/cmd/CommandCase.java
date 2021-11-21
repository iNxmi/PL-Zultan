package com.nami.api.cmd;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.nami.api.cmd.check.ByteCheck;
import com.nami.api.cmd.check.Check;
import com.nami.api.cmd.check.CheckResponse;
import com.nami.api.cmd.check.DoubleCheck;
import com.nami.api.cmd.check.FloatCheck;
import com.nami.api.cmd.check.IntegerCheck;
import com.nami.api.cmd.check.LongCheck;
import com.nami.api.cmd.check.PlayerCheck;
import com.nami.api.cmd.check.ShortCheck;
import com.nami.api.cmd.check.StringCheck;
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
				CheckResponse response = arg.check(module, sender, cmd, label, args[i]);
				if (response.shouldReturn())
					return response.getResponse();
			}

		return executor.onCommand(module, sender, cmd, label, args);
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

		public CheckResponse check(APIModule module, CommandSender sender, Command cmd, String label, String arg) {
			return check.check(module, sender, cmd, label, arg);
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

}
