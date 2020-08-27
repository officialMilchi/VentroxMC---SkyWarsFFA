package com.officialmilchi.ffa.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

    private ItemStack item;
    private ItemMeta itemMeta;



    public ItemBuilder(Material material) {
        item = new ItemStack(material);
        itemMeta = item.getItemMeta();
    }

    public ItemBuilder(Material material , short subID) {
        item = new ItemStack(material, 1, subID);
        itemMeta = item.getItemMeta();
    }

    public ItemBuilder setDisplayName(String name) {
        itemMeta.setDisplayName(name);
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        item.setAmount(amount);
        return this;
    }

    public ItemBuilder setUnbreakable(){
        itemMeta.spigot().setUnbreakable(true);
        return this;
    }

    public ItemBuilder setEnchantment(Enchantment enchantment, int level, boolean sehen) {
        itemMeta.addEnchant(enchantment, level, sehen);
        return this;

    }

    public ItemBuilder addEnchantment(Enchantment enchantment, int level) {
        itemMeta.addEnchant(enchantment, level, true);
        return this;

    }

    public ItemBuilder setNoName() {
        itemMeta.setDisplayName(" ");
        return this;
    }

    public ItemBuilder addLore(final String... strings) {
        itemMeta.setLore(Arrays.asList(strings));
        return this;
    }

    public ItemBuilder addLore(final List<String> stringList) {
        itemMeta.setLore(stringList);
        return this;
    }

    public ItemBuilder setUnbreakable(final boolean unbreakable) {
        itemMeta.spigot().setUnbreakable(unbreakable);
        return this;
    }

    public ItemBuilder addItemFlag(final ItemFlag itemFlag) {
        itemMeta.addItemFlags(itemFlag);
        return this;
    }

    public ItemBuilder setLore(String... lore){
        itemMeta.setLore(Arrays.asList(lore));
        return  this;
    }

    public ItemStack build() {
        item.setItemMeta(itemMeta);
        return item;
    }
}
