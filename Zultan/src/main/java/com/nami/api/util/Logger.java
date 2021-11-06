package com.nami.api.util;

import org.bukkit.command.CommandSender;

public class Logger {

	private String prefix;

	public Logger(String prefix) {
		this.prefix = prefix;
	}

	private String getCookedMessage(MessageType type, Object message) {
		return ("[" + prefix + "] " + type.getMessage(message.toString()));
	}

	public void send(MessageType type, CommandSender sender, Object message) {
		sender.sendMessage(getCookedMessage(type, message));
	}

}
