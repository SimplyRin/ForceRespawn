package net.simplyrin.forcerespawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by SimplyRin on 2022/05/22.
 */
public class ForceRespawn extends JavaPlugin {
	
	@Override
	public void onEnable() {
		this.getCommand("forcerespawn").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!sender.hasPermission("forcerespawn.admin")) {
			sender.sendMessage("§cYou do not have access to this command");
			return true;
		}
		
		if (args.length > 0) {
			Player player = this.getServer().getPlayer(args[0]);
			
			if (player != null) {
				player.spigot().respawn();
			}
		}
		
		sender.sendMessage("§cUsage: /" + cmd.getLabel() + " <player>");
		
		return true;
	}

}
