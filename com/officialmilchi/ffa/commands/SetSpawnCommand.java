package com.officialmilchi.ffa.commands;

import com.officialmilchi.ffa.SkyWarsFFA;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import javax.swing.*;
import java.io.File;

/**
 * @author officialMilchi (philipp.spreitzer@icloud.com)
 * @created: 11/08/2020 - 21:53
 * @project: SkyWarsFFA
 */
public class SetSpawnCommand implements CommandExecutor {

    public static File file = new File("plugins/skywarsffa/locs.yml");
    public static YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if(player.hasPermission("skywarsffa.setspawn")) {
                if (args.length == 0) {
                        double x = player.getLocation().getX();
                        double y = player.getLocation().getY();
                        double z = player.getLocation().getZ();
                        String world = player.getWorld().getName();
                        float yaw = player.getLocation().getYaw();
                        float pitch = player.getLocation().getPitch();
                        configuration.set("Spawn.x", x);
                        configuration.set("Spawn.y", y);
                        configuration.set("Spawn.z", z);
                        configuration.set("Spawn.yaw", yaw);
                        configuration.set("Spawn.pitch", pitch);
                        configuration.set("Spawn.world", world);
                        try {
                            configuration.save(file);
                            player.sendMessage(SkyWarsFFA.PREFIX + "§7Du hast den §eSpawn §aerfolgreich §7gesetzt!");
                        } catch (Exception exception) {
                            player.sendMessage(SkyWarsFFA.PREFIX + "§cFehler§7!");
                    }
                }
            } else {
                player.sendMessage(SkyWarsFFA.PREFIX + "§7Dazu hast du §ckeine §7Rechte!");
            }
        } else {
            Bukkit.getConsoleSender().sendMessage(SkyWarsFFA.PREFIX + "§7Du bist §ckein §7Spieler!");
        }
        return false;
    }
}
