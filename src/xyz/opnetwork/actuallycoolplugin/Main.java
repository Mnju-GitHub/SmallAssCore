package xyz.opnetwork.actuallycoolplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.opnetwork.actuallycoolplugin.cmds.Broadcast;
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
		this.getCommand("bc").setExecutor(new Broadcast());
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
	public void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		event.setQuitMessage("");
		for (Player online : Bukkit.getOnlinePlayers()) {
			online.sendMessage("§f" +player.getName()+" §7has quit");
		}
		
	}

	@EventHandler
	public void onDamage(PlayerItemDamageEvent event) {
		event.setCancelled(true);
	}
	@EventHandler
	public void onShear(PlayerShearEntityEvent event) {
		event.setCancelled(true);
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEnterbed(PlayerBedEnterEvent event) {
		Player player = event.getPlayer();
		player.sendTitle("§l§7Sweet Dreams!" , " ");
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLeavebed(PlayerBedLeaveEvent event) {
		Player player = event.getPlayer();
		player.sendTitle("§7 Sleep Well?", " " );
	}


	

}
