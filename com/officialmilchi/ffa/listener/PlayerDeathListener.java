package com.officialmilchi.ffa.listener;

import com.officialmilchi.ffa.SkyWarsFFA;
import com.officialmilchi.ffa.commands.SetSpawnCommand;
import com.officialmilchi.ffa.utils.Kits;
import com.officialmilchi.ffa.utils.ScoreUtils;
import com.officialmilchi.ffa.utils.Stats;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        event.getDrops().clear();
        Player player = event.getEntity().getPlayer();
        Player killer = event.getEntity().getKiller();
        event.setDeathMessage(null);
        Bukkit.getScheduler().runTaskLater(SkyWarsFFA.getInstance(), new Runnable() {
            @Override
            public void run() {
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
                }
            }
        }, 1L);
        if(killer != null) {
            if(SkyWarsFFA.getInstance().getMySQL().isConnected()) {
                Stats.addKill(killer.getUniqueId());
                Stats.addDeath(player.getUniqueId());
                player.sendMessage(SkyWarsFFA.PREFIX + "§7Du wurdest von §c"+killer.getName()+" §7getötet!");
                killer.playSound(killer.getLocation(), Sound.LEVEL_UP, 1F, 1F);
                killer.sendMessage(SkyWarsFFA.PREFIX + "§7Du hast §a"+player.getName()+" §7getötet!");
            }
        }

    }
}
