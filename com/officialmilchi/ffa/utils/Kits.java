package com.officialmilchi.ffa.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Kits {

    public static String kit;

    public static void setKit1(Player player) {
        player.getInventory().setArmorContents(null);
        player.getInventory().clear();
        player.getInventory().setItem(0, new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName("§3Schwert").setEnchantment(Enchantment.DAMAGE_ALL, 1, false).setUnbreakable().build());
        player.getInventory().setItem(1, new ItemBuilder(Material.FISHING_ROD).setDisplayName("§3Angel").setUnbreakable().build());
        player.getInventory().setItem(2, new ItemBuilder(Material.WEB).setDisplayName("§3Spinnenweben").setAmount(16).build());
        player.getInventory().setItem(4, new ItemBuilder(Material.COBBLESTONE).setDisplayName("§3Blöcke").setAmount(64).build());
        player.getInventory().setItem(8, new ItemBuilder(Material.LAVA_BUCKET).setDisplayName("§cLava").build());
        player.getInventory().setItem(3, new ItemBuilder(Material.WATER_BUCKET).setDisplayName("§9Wasser").build());
        player.getInventory().setBoots(new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayName("§3Schuhe").setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false).build());
        player.getInventory().setLeggings(new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayName("§3Hose").setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false).build());
        player.getInventory().setChestplate(new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayName("§3Brustplatte").setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false).build());
        player.getInventory().setHelmet(new ItemBuilder(Material.DIAMOND_HELMET).setDisplayName("§3Helm").setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false).build());
    }

    public static void setKIt2(Player player) {
        player.getInventory().setArmorContents(null);
        player.getInventory().clear();
        player.getInventory().setItem(0, new ItemBuilder(Material.STICK).setDisplayName("§3Stock").setEnchantment(Enchantment.KNOCKBACK, 3, false).build());
        player.getInventory().setItem(1, new ItemBuilder(Material.FISHING_ROD).setDisplayName("§3Angel").setUnbreakable().build());
        player.getInventory().setItem(2, new ItemBuilder(Material.WATER_BUCKET).setDisplayName("§3Wasser").build());
        player.getInventory().setItem(4, new ItemBuilder(Material.WEB).setDisplayName("§3Spinnenweben").setAmount(3).build());
        player.getInventory().setHelmet(new ItemBuilder(Material.CHAINMAIL_HELMET).setDisplayName("§7Helm").setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2,false).build());
        player.getInventory().setChestplate(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayName("§fBrustplatte").setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1,false).build());
        player.getInventory().setLeggings(new ItemBuilder(Material.CHAINMAIL_LEGGINGS).setDisplayName("§7Hose").setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,2,false).build());
        player.getInventory().setBoots(new ItemBuilder(Material.IRON_BOOTS).setDisplayName("§fSchuhe").setEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,1,false).build());
    }
    public static void setKit3(Player player) {
        player.getInventory().setArmorContents(null);
        player.getInventory().clear();

    }
}
