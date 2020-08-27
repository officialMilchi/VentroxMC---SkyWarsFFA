package com.officialmilchi.ffa.listener;

import com.officialmilchi.ffa.SkyWarsFFA;
import com.officialmilchi.ffa.commands.BuildCommand;
import com.officialmilchi.ffa.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event ){
        if(event.getBlock().getType().equals(Material.COBBLESTONE)) {
            event.getPlayer().getInventory().setItem(4, new ItemBuilder(Material.COBBLESTONE).setDisplayName("§3Blöcke").setAmount(64).build());
        }
        if(!BuildCommand.build.contains(event.getPlayer())) {
            if (event.getBlock().getType().isBlock()) {
                Bukkit.getScheduler().runTaskLater(SkyWarsFFA.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        Block block = event.getBlock();
                        Location location = block.getLocation();
                        location.getBlock().setType(Material.AIR);
                        if(!event.getBlock().getType().isBlock()) {
                            Block blocklava = event.getBlock();
                            Location blockloc = blocklava.getLocation();
                            blockloc.getBlock().setType(Material.AIR);
                        }
                    }
                }, 100);
            }
        }
    }
}
