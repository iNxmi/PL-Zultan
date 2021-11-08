package com.nami.api.util;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.chat.TextComponent;

public class Logger {

	private String prefix;

	public Logger(String prefix) {
		this.prefix = prefix;
	}

	private String getCookedMessage(Object message) {
		return ("[" + prefix + "] " + message);
	}

	private String getCookedMessage(MessageType type, Object message) {
		return ("[" + prefix + "] " + type.getMessage(message.toString()));
	}

	public void send(MessageType type, CommandSender sender, Object message) {
		sender.sendMessage(getCookedMessage(type, message));
	}

	public void broadcast(MessageType type, Object message) {
		for (Player p : Bukkit.getOnlinePlayers())
			send(type, p, message);
	}

	// TODO shit is deprecated
	@SuppressWarnings("deprecation")
	public void sendHotbar(Player player, Object message) {
		player.sendActionBar(TextComponent.fromLegacyText(message.toString()));
	}

	public void broadcastHotbar(Object message) {
		for (Player p : Bukkit.getOnlinePlayers())
			sendHotbar(p, getCookedMessage(message));
	}

}
