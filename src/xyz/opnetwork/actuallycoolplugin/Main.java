package xyz.opnetwork.actuallycoolplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.opnetwork.actuallycoolplugin.cmds.DiscordCommand;

public class Main extends JavaPlugin implements Listener{
	
	public String translate(String toTranslate) {
		  return ChatColor.translateAlternateColorCodes('&', toTranslate);
		}
	
	@Override
	public void onEnable() {
		System.out.println("Mnju's Plugin is booting...");
		getServer().getPluginManager().registerEvents(this, this);
		this.getCommand("discord").setExecutor(new DiscordCommand());
		this.saveDefaultConfig();
	}
	public void onDisable() {
		System.out.println("Mnju's Plugin is dying...");
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		event.setJoinMessage("");
		player.sendMessage(this.translate("&8Welcome, &f"+player.getName()));
	}
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) { 
		String msg = event.getMessage();
		Player player = event.getPlayer();
		event.setCancelled(true);
		String send = this.translate( player.getName()+" &8&l>> &f"+msg);
		for (Player online : Bukkit.getOnlinePlayers()) {
			online.sendMessage(send);
		}
	}
	

}
