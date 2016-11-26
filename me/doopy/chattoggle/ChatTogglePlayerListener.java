package me.doopy.chattoggle;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class ChatTogglePlayerListener implements Listener {

	ChatToggle plugin;
	public ChatTogglePlayerListener(ChatToggle chattoggle) {
		plugin = chattoggle;
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		if(!player.hasPermission("chattoggle.ignore")) {
			if (!ChatToggle.chatstate) {
				event.setCancelled(true);
				player.sendMessage(ChatColor.RED + "[CT] " + ChatColor.GRAY + "The chat is currently disabled.");
			
			}
		}
	}
	
}
