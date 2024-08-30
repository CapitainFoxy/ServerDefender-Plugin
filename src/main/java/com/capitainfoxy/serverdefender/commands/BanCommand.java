package com.capitainfoxy.serverdefender.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) return false;
        Player target = Bukkit.getPlayer(args[0]);
        if (target != null) {
            target.kickPlayer("You have been banned by an admin.");
            Bukkit.getBanList(org.bukkit.BanList.Type.NAME).addBan(target.getName(), "You are banned!", null, null);
            sender.sendMessage(ChatColor.GREEN + "Player " + target.getName() + " has been banned.");
        } else {
            sender.sendMessage(ChatColor.RED + "Player not found.");
        }
        return true;
    }
}
