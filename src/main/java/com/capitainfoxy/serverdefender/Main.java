package com.capitainfoxy.serverdefender;




import org.bukkit.plugin.java.JavaPlugin;
import com.capitainfoxy.serverdefender.commands.*;
import com.capitainfoxy.serverdefender.listeners.PlayerListener;



public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
        getCommand("kick").setExecutor(new KickCommand());
        getCommand("ban").setExecutor(new BanCommand());
        getCommand("banip").setExecutor(new BanIPCommand());
        getCommand("mute").setExecutor(new MuteCommand());
        getCommand("unmute").setExecutor(new UnmuteCommand());
        getCommand("lockdown").setExecutor(new LockdownCommand());
        getCommand("chatlockdown").setExecutor(new ChatLockdownCommand());
        getCommand("warn").setExecutor(new WarnCommand());
        getCommand("automod").setExecutor(new AutoModCommand(this));
    }
    @Override
    public void onDisable() {
        mcmdmd
    }
}
