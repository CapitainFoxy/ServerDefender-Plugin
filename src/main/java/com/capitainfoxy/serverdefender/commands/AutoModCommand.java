package com.capitainfoxy.serverdefender.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import com.capitainfoxy.serverdefender.Main;

public class AutoModCommand implements CommandExecutor {

    private Main plugin;

    public AutoModCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        boolean autoModEnabled = plugin.getConfig().getBoolean("automod.enabled");
        plugin.getConfig().set("automod.enabled", !autoModEnabled);
        plugin.saveConfig();
        sender.sendMessage(ChatColor.GREEN + "Auto moderation has been " + (autoModEnabled ? "disabled" : "enabled") + ".");
        return true;
    }
}
