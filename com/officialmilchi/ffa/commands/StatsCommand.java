package com.officialmilchi.ffa.commands;

import com.officialmilchi.ffa.SkyWarsFFA;
import com.officialmilchi.ffa.utils.Stats;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author officialMilchi (philipp.spreitzer@icloud.com)
 * @created: 13/08/2020 - 22:42
 * @project: SkyWarsFFA
 */
public class StatsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        //Player target = Bukkit.getPlayer(args[0]);
        if(player.hasPermission("skywarsffa.stats")) {
            if(SkyWarsFFA.getInstance().getMySQL().isConnected()) {
                if (args.length == 0) {
                    if (Stats.playerExists(player.getUniqueId())) {
                        double kd = (double) Stats.getKills(player.getUniqueId()) / (double) Stats.getDeaths(player.getUniqueId());
                        player.sendMessage("§8§m--------§r §3§lSkyWarsFFA §8§m--------§r");
                        player.sendMessage(SkyWarsFFA.PREFIX + "§7Platz§8: §3" + Stats.getRank(player.getUniqueId()));
                        player.sendMessage(SkyWarsFFA.PREFIX + "§7Kills§8: §3" + Stats.getKills(player.getUniqueId()));
                        player.sendMessage(SkyWarsFFA.PREFIX + "§7Deaths§8: §3" + Stats.getDeaths(player.getUniqueId()));
                        player.sendMessage(SkyWarsFFA.PREFIX + "§7KD§8: §3" + kd);
                        player.sendMessage("§8§m--------§r §3§lSkyWarsFFA §8§m--------§r");
                    }
                }
                //if(args.length == 1) {
                    //if(Stats.playerExistsByName(args[0])) {
                        //double kd = (double) Stats.getKills(target.getUniqueId()) / (double) Stats.getDeaths(target.getUniqueId());
                        //player.sendMessage("§8§m--------§r §3§lSkyWarsFFA §8§m--------§r");
                        //player.sendMessage(SkyWarsFFA.PREFIX + "§7Platz§8: §3" + Stats.getRank(target.getUniqueId()));
                        //player.sendMessage(SkyWarsFFA.PREFIX + "§7Kills§8: §3" + Stats.getKills(target.getUniqueId()));
                        //player.sendMessage(SkyWarsFFA.PREFIX + "§7Deaths§8: §3" + Stats.getDeaths(target.getUniqueId()));
                        //player.sendMessage(SkyWarsFFA.PREFIX + "§7KD§8: §3" + kd);
  //                      player.sendMessage("§8§m--------§r §3§lSkyWarsFFA §8§m--------§r");
                    }
                }
//            }
        //}
        return false;
    }
}
