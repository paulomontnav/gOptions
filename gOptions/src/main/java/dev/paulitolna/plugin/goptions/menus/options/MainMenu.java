package dev.paulitolna.plugin.goptions.menus.options;

import dev.paulitolna.plugin.goptions.menus.MenuCreator;
import dev.paulitolna.plugin.goptions.utils.CC;
import dev.paulitolna.plugin.goptions.utils.FileCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

public class MainMenu implements MenuCreator {

    @Inject @Named("menus") private FileCreator menus;

    public static boolean isVisible;

    @Override
    public void create(Player player) {
        Inventory main_menu = Bukkit.createInventory(player, menus.getInt("menus.main_menu.size"), CC.translate(menus.getString("menus.main_menu.title")));
        ItemStack close_item = new ItemStack(Material.getMaterial(menus.getString("menus.main_menu.items.close.material")));
        ItemMeta close_meta = close_item.getItemMeta();
        close_meta.setDisplayName(CC.translate(menus.getString("menus.main_menu.items.close.name")));
        List<String> close_lore = menus.getStringList("menus.main_menu.items.close.lore");
        close_meta.setLore(CC.translateList(close_lore));
        close_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        close_item.setItemMeta(close_meta);
        if (isVisible) {
            ItemStack visible_item_true = new ItemStack(Material.SLIME_BALL);
            ItemMeta visible_item_meta_true = visible_item_true.getItemMeta();
            visible_item_meta_true.setDisplayName(CC.translate(menus.getString("menus.main_menu.items.visibility.visibility_true.name")));
            List<String> visibility_item_true_lore = menus.getStringList("menus.main_menu.items.visibility.visibility_true.lore");
            visible_item_meta_true.setLore(CC.translateList(visibility_item_true_lore));
            visible_item_meta_true.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            visible_item_true.setItemMeta(visible_item_meta_true);
            main_menu.setItem(menus.getInt("menus.main_menu.items.visibility.position"), visible_item_true);
        } else {
            ItemStack visible_item_false = new ItemStack(Material.CLAY_BALL);
            ItemMeta visible_item_false_meta = visible_item_false.getItemMeta();
            visible_item_false_meta.setDisplayName(CC.translate(menus.getString("menus.main_menu.items.visibility.visibility_false.name")));
            List<String> visibility_item_false_lore = menus.getStringList("menus.main_menu.items.visibility.visibility_false.lore");
            visible_item_false_meta.setLore(CC.translateList(visibility_item_false_lore));
            visible_item_false_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            visible_item_false.setItemMeta(visible_item_false_meta);
            main_menu.setItem(menus.getInt("menus.main_menu.items.visibility.position"), visible_item_false);
        }
        main_menu.setItem(menus.getInt("menus.main_menu.items.close.slot"), close_item);
        player.openInventory(main_menu);
    }
}
