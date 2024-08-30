package com.capitainfoxy.serverdefender.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class MuteCommand implements CommandExecutor {

    public static final Set<UUID> mutedPlayers = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) return false;
        Player target = sender.getServer().getPlayer(args[0]);
        if (target != null) {
            UUID targetUUID = target.getUniqueId();
            if (mutedPlayers.contains(targetUUID)) {
                sender.sendMessage(ChatColor.GREEN + "Player " + target.getName() + " has been unmuted.");
                mutedPlayers.remove(targetUUID);
            } else {
                sender.sendMessage(ChatColor.GREEN + "Player " + target.getName() + " has been muted.");
                mutedPlayers.add(targetUUID);
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Player not found.");
        }
        return true;
    }

    public static boolean isMuted(UUID uuid) {
        return mutedPlayers.contains(uuid);
    }
}
