package com.capitainfoxy.serverdefender.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) return false;
        Player target = sender.getServer().getPlayer(args[0]);
        if (target != null) {
            StringBuilder warningMessage = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                warningMessage.append(args[i]).append(" ");
            }
            target.sendMessage(ChatColor.YELLOW + "Warning: " + warningMessage.toString().trim());
            sender.sendMessage(ChatColor.GREEN + "Player " + target.getName() + " has been warned.");
        } else {
            sender.sendMessage(ChatColor.RED + "Player not found.");
        }
        return true;
    }
}
