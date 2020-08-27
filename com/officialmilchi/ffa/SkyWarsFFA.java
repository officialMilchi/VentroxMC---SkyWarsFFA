package com.officialmilchi.ffa;

import com.officialmilchi.ffa.commands.BuildCommand;
import com.officialmilchi.ffa.commands.SetKitCommand;
import com.officialmilchi.ffa.commands.SetSpawnCommand;
import com.officialmilchi.ffa.commands.StatsCommand;
import com.officialmilchi.ffa.listener.*;
import com.officialmilchi.ffa.utils.AutoKitChange;
import com.officialmilchi.ffa.utils.Kits;
import com.officialmilchi.ffa.utils.MySQL;
import com.officialmilchi.tsaddon.TSAddon;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Timer;
import java.util.TimerTask;

public class SkyWarsFFA extends JavaPlugin {

    public static final String PREFIX = "§3§lSkyWarsFFA §8| §7";
    private static SkyWarsFFA instance;
    private MySQL mySQL;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§aDas Plugin wurde erfolgreich aktiviert!");
        registerListener();
        registerCommands();
        Kits.kit = "1";
        run();
        AutoKitChange.run();
        mySQL = new MySQL();
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "§cDas Plugin wurde deaktiviert!");
        if(mySQL.isConnected()) {
            mySQL.disconnect();
        }
    }

    private static void registerCommands() {
        getInstance().getCommand("build").setExecutor(new BuildCommand());
        getInstance().getCommand("setkit").setExecutor(new SetKitCommand());
        getInstance().getCommand("setspawn").setExecutor(new SetSpawnCommand());
        getInstance().getCommand("stats").setExecutor(new StatsCommand());
    }

    private static void registerListener() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerJoinListener(), SkyWarsFFA.getInstance());
        pluginManager.registerEvents(new BlockPlaceListener(), SkyWarsFFA.getInstance());
        pluginManager.registerEvents(new PlayerDeathListener(), SkyWarsFFA.getInstance());
        pluginManager.registerEvents(new GameProtection(), SkyWarsFFA.getInstance());
        pluginManager.registerEvents(new PlayerRespawnListener(), SkyWarsFFA.getInstance());
        pluginManager.registerEvents(new PlayerMoveListener(), SkyWarsFFA.getInstance());
    }

    public static SkyWarsFFA getInstance() {
        return instance;
    }

    public MySQL getMySQL() {
        return mySQL;
    }

    public void run() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    all.getWorld().setTime(1000);
                }
            }
        }, 600000, 600000);
    }
}
