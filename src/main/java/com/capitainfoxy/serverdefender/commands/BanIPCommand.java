package com.capitainfoxy.serverdefender.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanIPCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) return false;
        Player target = Bukkit.getPlayer(args[0]);
        if (target != null) {
            String ip = target.getAddress().getAddress().getHostAddress();
            Bukkit.getBanList(org.bukkit.BanList.Type.IP).addBan(ip, "Your IP has been banned!", null, null);
            target.kickPlayer("You have been IP banned");
            sender.sendMessage(ChatColor.GREEN + "Player " + target.getName() + " and their IP (" + ip + ") have been banned.");
        } else {
            sender.sendMessage(ChatColor.RED + "Player not found.");
        }
        return true;
    }
}
