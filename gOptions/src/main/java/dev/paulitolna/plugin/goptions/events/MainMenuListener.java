package dev.paulitolna.plugin.goptions.events;

import com.cryptomorin.xseries.XSound;
import dev.paulitolna.plugin.goptions.menus.options.MainMenu;
import dev.paulitolna.plugin.goptions.utils.CC;
import dev.paulitolna.plugin.goptions.utils.FileCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import javax.inject.Inject;
import javax.inject.Named;

public class MainMenuListener implements Listener {

    @Inject @Named("menus") private FileCreator menus;

    @Inject @Named("messages") private FileCreator message;

    @EventHandler
    public void onClickInventory(InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase(CC.translate(menus.getString("menus.main_menu.title")))) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(CC.translate(menus.getString("menus.main_menu.items.close.name")))) {
                player.closeInventory();
            }
            if (event.getCurrentItem().getType().equals(Material.SLIME_BALL)) {
                MainMenu.isVisible = false;
                Bukkit.getServer().getOnlinePlayers().forEach(player::hidePlayer);
                player.sendMessage(CC.translate(message.getString("messages.menus_messages.visibility.disabled")));
                XSound.play(player, "LEVEL_UP");
                player.closeInventory();
            }
            if (event.getCurrentItem().getType().equals(Material.CLAY_BALL)) {
                MainMenu.isVisible = true;
                Bukkit.getServer().getOnlinePlayers().forEach(player::showPlayer);
                player.sendMessage(CC.translate(message.getString("messages.menus_messages.visibility.enabled")));
                XSound.play(player, "LEVEL_UP");
                player.closeInventory();
            }
        }
    }
}
