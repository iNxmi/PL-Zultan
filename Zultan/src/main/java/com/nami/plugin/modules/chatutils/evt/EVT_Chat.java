package com.nami.plugin.modules.chatutils.evt;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.nami.api.plugin.module.APIModule;
import com.nami.api.plugin.module.event.APIEvent;

public class EVT_Chat extends APIEvent {

	public EVT_Chat(APIModule module) {
		super(module);
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
	}

}
