package com.capitainfoxy.serverdefender.listeners;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import com.capitainfoxy.serverdefender.commands.MuteCommand;
import com.capitainfoxy.serverdefender.commands.LockdownCommand;
import com.capitainfoxy.serverdefender.commands.ChatLockdownCommand;
import com.capitainfoxy.serverdefender.Main;





public class PlayerListener implements Listener {
    private Main plugin;
    public PlayerListener(Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (MuteCommand.isMuted(event.getPlayer().getUniqueId())) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You are muted and cannot chat.");
        }
        if (plugin.getConfig().getBoolean("chatlockdown")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "Chat is currently locked down.");
        }
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (plugin.getConfig().getBoolean("lockdown")) {
            event.getPlayer().kickPlayer("The server is currently in lockdown mode.");
        }
    }
}
