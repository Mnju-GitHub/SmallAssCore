package xyz.opnetwork.actuallycoolplugin.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import xyz.opnetwork.actuallycoolplugin.Main;

public class DiscordCommand implements CommandExecutor {
	FileConfiguration conf = Main.getPlugin(Main.class).getConfig();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			String message = conf.getString("discord-link");
			sender.sendMessage(Main.getPlugin(Main.class).translate(message));
		}
		else {
			String message = conf.getString("discord-link");
			sender.sendMessage(Main.getPlugin(Main.class).translate(message));
		}
		return true;
	}

}
