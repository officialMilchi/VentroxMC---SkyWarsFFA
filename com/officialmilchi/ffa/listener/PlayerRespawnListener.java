package com.officialmilchi.ffa.listener;

import com.officialmilchi.ffa.SkyWarsFFA;
import com.officialmilchi.ffa.commands.SetSpawnCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * @author officialMilchi (philipp.spreitzer@icloud.com)
 * @created: 11/08/2020 - 22:19
 * @project: SkyWarsFFA
 */
public class PlayerRespawnListener implements Listener{

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        Bukkit.getScheduler().runTaskLater(SkyWarsFFA.getInstance(), new Runnable() {
            @Override
            public void run() {
                World world = Bukkit.getWorld(SetSpawnCommand.configuration.getString("Spawn.world"));
                double x = SetSpawnCommand.configuration.getDouble("Spawn.x");
                double y = SetSpawnCommand.configuration.getDouble("Spawn.y");
                double z = SetSpawnCommand.configuration.getDouble("Spawn.z");
                float yaw = (float) SetSpawnCommand.configuration.getDouble("Spawn.yaw");
                float pitch = (float) SetSpawnCommand.configuration.getDouble("Spawn.pitch");
                Location spawn = new Location(world, x,y,z,yaw,pitch);
                player.teleport(spawn);
            }
        }, 1L);
    }
}
