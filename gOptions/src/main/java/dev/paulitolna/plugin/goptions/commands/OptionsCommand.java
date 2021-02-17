package dev.paulitolna.plugin.goptions.commands;

import com.cryptomorin.xseries.XSound;
import dev.paulitolna.plugin.goptions.menus.MenuCreator;
import dev.paulitolna.plugin.goptions.utils.CC;
import dev.paulitolna.plugin.goptions.utils.FileCreator;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import org.bukkit.entity.Player;

import javax.inject.Inject;
import javax.inject.Named;

@Command(names = {"options", "opciones"})
public class OptionsCommand implements CommandClass {

    @Inject @Named("messages") private FileCreator messages;

    @Inject @Named("main-menu") private MenuCreator mainMenu;

    @Command(names = "")
    public boolean executeWithoutArg(@Sender Player player) {
        if (player.hasPermission("goptions.use") || player.hasPermission("goptions.*")) {
            player.sendMessage(CC.translate(messages.getString("messages.insuficient_arguments")));
        } else {
            player.sendMessage(CC.translate(messages.getString("messages.no_permission")));
        }
        return true;
    }

    @Command(names = {"open", "abrir"})
    public boolean executeOpenArg(@Sender Player player) {
        if (player.hasPermission("goptions.use") || player.hasPermission("goptions.*")) {
            mainMenu.create(player);
            XSound.play(player, messages.getString("messages.menus_messages.open_menu_sound"));
        } else {
            player.sendMessage(CC.translate(messages.getString("messages.no_permission")));
        }
        return true;
    }
}
