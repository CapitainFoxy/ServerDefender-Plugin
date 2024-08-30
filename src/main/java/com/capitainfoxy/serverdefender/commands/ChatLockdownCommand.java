package com.capitainfoxy.serverdefender.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChatLockdownCommand implements CommandExecutor {

    private boolean chatLockdown = false;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        chatLockdown = !chatLockdown;
        if (chatLockdown) {
            Bukkit.broadcastMessage(ChatColor.RED + "Chat lockdown is now enabled.");
        } else {
            Bukkit.broadcastMessage(ChatColor.GREEN + "Chat lockdown is now disabled");
        }
        return true;
    }

    public boolean isChatLockdown() {
        return chatLockdown;
    }
}
