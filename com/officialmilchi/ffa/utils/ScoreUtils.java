package com.officialmilchi.ffa.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

/**
 * @author officialMilchi (philipp.spreitzer@icloud.com)
 * @created: 09/08/2020 - 17:18
 * @project: SkyWarsFFA
 */
public class ScoreUtils {

    public static void setScoreboard(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("ffascore", "scoreboard");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§3§lSkyWarsFFA");
        objective.getScore("§3Profil§8:").setScore(8);
        objective.getScore("  §8» §e"+player.getName()).setScore(7);
        objective.getScore("   ").setScore(6);
        objective.getScore("§3Spieler online§8:").setScore(5);
        objective.getScore("  §8» §e"+Bukkit.getOnlinePlayers().size()).setScore(4);
        objective.getScore("").setScore(3);
        objective.getScore("§3Kit§8:").setScore(2);
        if(Kits.kit.equals("1")) {
            objective.getScore("  §8» §eKit 1").setScore(1);
        }
        if(Kits.kit.equals("2")) {
            objective.getScore("  §8» §eKit 2").setScore(1);
        }
        if(Kits.kit.equals("3")) {
            objective.getScore("  §8» §eKit 3").setScore(1);
        }
        player.setScoreboard(scoreboard);
    }
}
