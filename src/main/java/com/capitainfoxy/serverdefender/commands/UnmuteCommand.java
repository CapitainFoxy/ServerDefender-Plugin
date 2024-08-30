package com.capitainfoxy.serverdefender.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnmuteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) return false;
        Player target = sender.getServer().getPlayer(args[0]);
        if (target != null) {
            UUID targetUUID = target.getUniqueId();
            if (MuteCommand.isMuted(targetUUID)) {
                sender.sendMessage(ChatColor.GREEN + "Player " + target.getName() + " has been unmuted.");
                MuteCommand.mutedPlayers.remove(targetUUID);
            } else {
                sender.sendMessage(ChatColor.RED + "Player " + target.getName() + " is not muted.");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Player not found.");
        }
        return true;
    }
}
