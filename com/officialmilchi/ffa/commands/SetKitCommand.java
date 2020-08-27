package com.officialmilchi.ffa.commands;

import com.officialmilchi.ffa.SkyWarsFFA;
import com.officialmilchi.ffa.utils.Kits;
import com.officialmilchi.ffa.utils.ScoreUtils;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author officialMilchi (philipp.spreitzer@icloud.com)
 * @created: 11/08/2020 - 11:20
 * @project: SkyWarsFFA
 */
public class SetKitCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String string, String[] args) {
        Player player = (Player) commandSender;
        if(player.hasPermission("skywarsffa.setkit")) {
            if(args.length == 0) {
                player.sendMessage(SkyWarsFFA.PREFIX + "§7Verwende: §c/setkit <1,2,3>");
            } else if(args[0].equals("1")) {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    if(!BuildCommand.build.contains(all)) {
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
                }
            } else if(args[0].equals("2")) {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    if(!BuildCommand.build.contains(all)) {
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
                }
            } else if(args[0].equals("3")) {
                for(Player all : Bukkit.getOnlinePlayers()) {
                    if(!BuildCommand.build.contains(all)) {
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
        } else {
            player.sendMessage(SkyWarsFFA.PREFIX + "§7Du hast §ckeine §7Rechte!");
        }
        return false;
    }
}
