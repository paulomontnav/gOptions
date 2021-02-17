package dev.paulitolna.plugin.goptions.commands;

import dev.paulitolna.plugin.goptions.utils.CC;
import dev.paulitolna.plugin.goptions.utils.FileCreator;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import org.bukkit.entity.Player;

import javax.inject.Inject;
import javax.inject.Named;

@Command(names = {"goptions", "gop"})
public class gOptionsCommand implements CommandClass {

    @Inject @Named("messages") private FileCreator messages;

    @Inject @Named("config") private FileCreator config;

    @Inject @Named("menus") private FileCreator menus;

    @Command(names = "")
    public boolean executeWithoutArgs(@Sender Player player) {
        if (player.hasPermission("goptions.admin") || player.hasPermission("goptions.*")) {
            player.sendMessage(CC.translate("&8[&cgOptions&8] &7> &fCurrently plugin version &a1.0.0"));
        } else {
            player.sendMessage(CC.translate(messages.getString("messages.no_permission")));
        }
        return true;
    }

    @Command(names = "reload")
    public boolean executeReloadProcess(@Sender Player player) {
        if (player.hasPermission("goptions.admin") || player.hasPermission("goptions.*")) {
            messages.reload();
            config.reload();
            menus.reload();
            player.sendMessage(CC.translate("&8[&cgOptions&8] &7> &fThe plugin was correctly reloaded!"));
        } else {
            player.sendMessage(CC.translate(messages.getString("messages.no_permission")));
        }
        return true;
    }
}
