package com.nami.plugin.modules.coords.evt;

import java.util.List;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import com.nami.api.plugin.module.APIModule;
import com.nami.api.plugin.module.event.APIEvent;
import com.nami.plugin.Plugin;

public class EVT_Move extends APIEvent {

	private List<UUID> players;

	public EVT_Move(APIModule module, List<UUID> players) {
		super(module);
		this.players = players;
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		Location loc = p.getLocation();
		if (players.contains(p.getUniqueId()))
			Plugin.logger.sendHotbar(p, loc.getBlockX() + " " + loc.getBlockY() + " " + loc.getBlockZ());

	}

}
