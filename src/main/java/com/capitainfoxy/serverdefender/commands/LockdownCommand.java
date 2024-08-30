package com.capitainfoxy.serverdefender.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LockdownCommand implements CommandExecutor {

    private boolean lockdown = false;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        lockdown = !lockdown;
        if (lockdown) {
            Bukkit.broadcastMessage(ChatColor.RED + "The server is now in lockdown mode. No new players can join.");
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.kickPlayer("The server is in lockdown mode.");
            }
        } else {
            Bukkit.broadcastMessage(ChatColor.GREEN + "Lockdown mode is now disabled.");
        }
        return true;
    }

    public boolean isLockdown() {
        return lockdown;
    }
}
