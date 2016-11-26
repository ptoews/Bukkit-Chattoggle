package me.doopy.chattoggle;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatToggle extends JavaPlugin {
	static boolean chatstate = true;
	Player p;
	
	private ChatTogglePlayerListener playerListener;
	
	private void echo(Object s) {
		System.out.println(s);
	}
	
	@Override
	public void onDisable() {
		echo("[CT] ChatToggle " + getDescription().getVersion() + " disabled.");
	}

	@Override
	public void onEnable() {
		echo("[CT] ChatToggle " + getDescription().getVersion() + " enabled!");
		playerListener = new ChatTogglePlayerListener(this);
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(playerListener, this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		
		if(cmd.getName().equalsIgnoreCase("togglechat") || cmd.getName().equalsIgnoreCase("tc")) {
			if(sender instanceof Player) {
				p = (Player) sender;
				if(!p.hasPermission("chattoggle.toggle")) {
					return false;
				} 
			}
			if(chatstate) { 
				chatstate = false; 
				p.sendMessage(ChatColor.RED + "[CT] " + ChatColor.GRAY + "Chat disabled.");
			}
			else { 
				chatstate = true; 
				p.sendMessage(ChatColor.RED + "[CT] " + ChatColor.GRAY + "Chat enabled.");
			}
			return true;
		}
		
		return false;
		
	}
}
