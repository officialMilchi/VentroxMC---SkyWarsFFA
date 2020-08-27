package com.officialmilchi.ffa.listener;

import com.officialmilchi.ffa.SkyWarsFFA;
import com.officialmilchi.ffa.commands.SetSpawnCommand;
import com.officialmilchi.ffa.utils.AutoKitChange;
import com.officialmilchi.ffa.utils.Kits;
import com.officialmilchi.ffa.utils.ScoreUtils;
import com.officialmilchi.ffa.utils.Stats;
import net.minecraft.server.v1_8_R3.BlockCactus;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(null);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.getInventory().clear();
        player.setGameMode(GameMode.SURVIVAL);

        for(Player all : Bukkit.getOnlinePlayers()) {
            if(Kits.kit == "1") {
                Kits.setKit1(all);
            }
            if(Kits.kit == "2") {
                Kits.setKIt2(all);
            }
            if(Kits.kit == "3") {
                Kits.setKit3(all);
            }
            ScoreUtils.setScoreboard(all);
        }
        Bukkit.broadcastMessage(SkyWarsFFA.PREFIX + "§7Der Spieler §e"+player.getName() + "§7 hat den Server §abetreten§7!");

        World world = Bukkit.getWorld(SetSpawnCommand.configuration.getString("Spawn.world"));
        double x = SetSpawnCommand.configuration.getDouble("Spawn.x");
        double y = SetSpawnCommand.configuration.getDouble("Spawn.y");
        double z = SetSpawnCommand.configuration.getDouble("Spawn.z");
        float yaw = (float) SetSpawnCommand.configuration.getDouble("Spawn.yaw");
        float pitch = (float) SetSpawnCommand.configuration.getDouble("Spawn.pitch");
        Location spawn = new Location(world, x,y,z,yaw,pitch);
        player.teleport(spawn);
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        if(SkyWarsFFA.getInstance().getMySQL().isConnected()) {
            try{
                Stats.createPlayer(player);
            } catch(Exception exception) {
                event.disallow(PlayerLoginEvent.Result.KICK_FULL, SkyWarsFFA.PREFIX + "§7Verbinde dich bitte §cerneut §7zum Server!");
                SkyWarsFFA.getInstance().getMySQL().connect();
            }
        }
    }
}
