package xyz.opnetwork.actuallycoolplugin.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import xyz.opnetwork.actuallycoolplugin.Main;

public class Broadcast implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			if (args.length == 0) {
				sender.sendMessage("ERROR: Please write a message to use this command!");
			}
			else {
				String msg ="";
				for (int i = 0; i < args.length; i++) {
					String arg = args[ i ] +" ";
					msg = msg +arg ;
					
				}
				for (Player online : Bukkit.getOnlinePlayers()) {
					online.sendTitle(Main.getPlugin(Main.class).translate(msg), Main.getPlugin(Main.class).translate("&4THIS IS AN ANNOUNCEMENT"));
				}
				sender.sendMessage("Sent Broadcast.");
			}
		}
		else {
			Player player = (Player) sender; 
			if (player.hasPermission("broadcast.send")) {
				if (args.length == 0) {
					sender.sendMessage("§4ERROR: §fPlease write a message to use this command!");
				}
				else {
					String msg ="";
					for (int i = 0; i < args.length; i++) {
						String arg = args[ i ] +" ";
						msg = msg +arg ;
						
					}
					for (Player online : Bukkit.getOnlinePlayers()) {
						online.sendTitle(Main.getPlugin(Main.class).translate(msg), Main.getPlugin(Main.class).translate("&4THIS IS AN ANNOUNCEMENT"));
					}
					sender.sendMessage("Sent Broadcast.");
				}
			}
			else {
				player.sendMessage("§4You dont have permission to use this command!");
			}
		}
		return true;
		
	}
	
	
	
	
	

}
