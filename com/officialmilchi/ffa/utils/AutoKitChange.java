package com.officialmilchi.ffa.utils;

import com.officialmilchi.ffa.SkyWarsFFA;
import com.officialmilchi.ffa.commands.SetSpawnCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author officialMilchi (philipp.spreitzer@icloud.com)
 * @created: 09/08/2020 - 17:40
 * @project: SkyWarsFFA
 */
public class AutoKitChange {

    public static ArrayList<Integer> kit = new ArrayList<>();
    public static Integer newkit;

    public static void run() {
        kit.add(1);
        kit.add(2);
        kit.add(3);
        Random random = new Random();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyWarsFFA.getInstance(), new Runnable() {
            @Override
            public void run() {

                for(Player all : Bukkit.getOnlinePlayers()) {
                    newkit = kit.get(random.nextInt(kit.size()));
                    if (newkit.equals(1)) {
                        Kits.setKit1(all);
                        Bukkit.broadcastMessage(SkyWarsFFA.PREFIX + "§7Das Kit wurde auf §e§lKIT 1 §7gesetzt!");
                        Kits.kit = "1";
                        ScoreUtils.setScoreboard(all);

                        World world = Bukkit.getWorld(SetSpawnCommand.configuration.getString("Spawn.world"));
                        double x = SetSpawnCommand.configuration.getDouble("Spawn.x");
                        double y = SetSpawnCommand.configuration.getDouble("Spawn.y");
                        double z = SetSpawnCommand.configuration.getDouble("Spawn.z");
                        float yaw = (float) SetSpawnCommand.configuration.getDouble("Spawn.yaw");
                        float pitch = (float) SetSpawnCommand.configuration.getDouble("Spawn.pitch");
                        Location spawn = new Location(world, x, y, z, yaw, pitch);
                        all.teleport(spawn);
                        all.playSound(spawn, Sound.LEVEL_UP, 1F, 1F);
                    }
                    if(newkit.equals(2)) {
                        Kits.setKIt2(all);
                        Bukkit.broadcastMessage(SkyWarsFFA.PREFIX + "§7Das Kit wurde auf §e§lKIT 2 §7gesetzt!");
                        Kits.kit = "2";
                        ScoreUtils.setScoreboard(all);

                        World world = Bukkit.getWorld(SetSpawnCommand.configuration.getString("Spawn.world"));
                        double x = SetSpawnCommand.configuration.getDouble("Spawn.x");
                        double y = SetSpawnCommand.configuration.getDouble("Spawn.y");
                        double z = SetSpawnCommand.configuration.getDouble("Spawn.z");
                        float yaw = (float) SetSpawnCommand.configuration.getDouble("Spawn.yaw");
                        float pitch = (float) SetSpawnCommand.configuration.getDouble("Spawn.pitch");
                        Location spawn = new Location(world, x, y, z, yaw, pitch);
                        all.teleport(spawn);
                        all.playSound(spawn, Sound.LEVEL_UP, 1F, 1F);
                    }
                    if(newkit.equals(3)) {
                        Kits.setKit3(all);
                        Bukkit.broadcastMessage(SkyWarsFFA.PREFIX + "§7Das Kit wurde auf §e§lKIT 3 §7gesetzt!");
                        Kits.kit = "3";
                        ScoreUtils.setScoreboard(all);

                        World world = Bukkit.getWorld(SetSpawnCommand.configuration.getString("Spawn.world"));
                        double x = SetSpawnCommand.configuration.getDouble("Spawn.x");
                        double y = SetSpawnCommand.configuration.getDouble("Spawn.y");
                        double z = SetSpawnCommand.configuration.getDouble("Spawn.z");
                        float yaw = (float) SetSpawnCommand.configuration.getDouble("Spawn.yaw");
                        float pitch = (float) SetSpawnCommand.configuration.getDouble("Spawn.pitch");
                        Location spawn = new Location(world, x, y, z, yaw, pitch);
                        all.teleport(spawn);
                        all.playSound(spawn, Sound.LEVEL_UP, 1F, 1F);
                    }
                }
            }
        }, 600000, 600000);
    }
}
