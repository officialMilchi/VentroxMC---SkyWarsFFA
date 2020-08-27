package com.officialmilchi.ffa.listener;

import com.officialmilchi.ffa.SkyWarsFFA;
import com.officialmilchi.ffa.utils.ScoreUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author officialMilchi (philipp.spreitzer@icloud.com)
 * @created: 11/08/2020 - 16:18
 * @project: SkyWarsFFA
 */
public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        for(Player all : Bukkit.getOnlinePlayers()) {
            ScoreUtils.setScoreboard(all);
        }
        Bukkit.broadcastMessage(SkyWarsFFA.PREFIX + "§7Der Spieler §e"+player.getName() + "§7 hat den Server §cverlassen§7!");
        event.setQuitMessage(null);
    }
}
