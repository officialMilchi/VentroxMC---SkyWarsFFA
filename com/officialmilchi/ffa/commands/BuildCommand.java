package com.officialmilchi.ffa.commands;

import com.officialmilchi.ffa.SkyWarsFFA;
import com.officialmilchi.ffa.utils.AutoKitChange;
import com.officialmilchi.ffa.utils.Kits;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class BuildCommand implements CommandExecutor {

    public static ArrayList<Player> build = new ArrayList<Player>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if(player.hasPermission("skywarsffa.build")) {
                if(args.length == 0) {
                    if(build.contains(player)) {
                        player.sendMessage(SkyWarsFFA.PREFIX + "§7Du bist nun §cnichtmehr §7im §eBuildModus§7!");
                        player.setGameMode(GameMode.SURVIVAL);
                        player.setAllowFlight(false);
                        build.remove(player);
                        player.playSound(player.getLocation(), Sound.BLAZE_DEATH, 1F, 1F);
                        if(Kits.kit == "1") {
                            Kits.setKit1(player);
                        }
                        if(Kits.kit == "2") {
                            Kits.setKIt2(player);
                        }
                        if(Kits.kit == "3") {
                            Kits.setKit3(player);
                        }
                    } else {
                        player.sendMessage(SkyWarsFFA.PREFIX + "§7Du bist nun im §eBuildModus§7!");
                        player.setGameMode(GameMode.CREATIVE);
                        player.setAllowFlight(true);
                        player.getInventory().clear();
                        build.add(player);
                        player.playSound(player.getLocation(), Sound.LEVEL_UP, 1F,1F);
                    }
                }
            } else {
                player.sendMessage(SkyWarsFFA.PREFIX+ "§7Dazu hast du §ckeine §7Rechte!"); }
        } else {
            Bukkit.getConsoleSender().sendMessage(SkyWarsFFA.PREFIX+"§7Du bist §ckein §7Spieler!");
        }
        return true;
    }
}
