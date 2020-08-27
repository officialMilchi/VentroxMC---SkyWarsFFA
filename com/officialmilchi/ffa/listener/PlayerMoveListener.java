package com.officialmilchi.ffa.listener;

import com.officialmilchi.ffa.commands.BuildCommand;
import com.officialmilchi.ffa.commands.SetSpawnCommand;
import com.officialmilchi.ffa.utils.Kits;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * @author officialMilchi (philipp.spreitzer@icloud.com)
 * @created: 11/08/2020 - 22:39
 * @project: SkyWarsFFA
 */
public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if(!BuildCommand.build.contains(player)) {
            if (player.getLocation().getY() <= 20) {
                World world = Bukkit.getWorld(SetSpawnCommand.configuration.getString("Spawn.world"));
                double x = SetSpawnCommand.configuration.getDouble("Spawn.x");
                double y = SetSpawnCommand.configuration.getDouble("Spawn.y");
                double z = SetSpawnCommand.configuration.getDouble("Spawn.z");
                float yaw = (float) SetSpawnCommand.configuration.getDouble("Spawn.yaw");
                float pitch = (float) SetSpawnCommand.configuration.getDouble("Spawn.pitch");
                Location spawn = new Location(world, x, y, z, yaw, pitch);
                player.teleport(spawn);

                for (Player all : Bukkit.getOnlinePlayers()) {
                    if (Kits.kit == "1") {
                        Kits.setKit1(all);
                    }
                    if (Kits.kit == "2") {
                        Kits.setKIt2(all);
                    }
                    if (Kits.kit == "3") {
                        Kits.setKit3(all);
                    }
                }
            }
        }
        if(!BuildCommand.build.contains(player)) {
            if (player.getLocation().getY() >= 72) {
                Location location = new Location(player.getLocation().getWorld(), player.getLocation().getX(), 68, player.getLocation().getZ());
                player.teleport(location);
            }
        }
    }
}
