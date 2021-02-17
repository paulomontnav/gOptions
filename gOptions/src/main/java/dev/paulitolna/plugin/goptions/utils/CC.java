package dev.paulitolna.plugin.goptions.utils;

import org.bukkit.ChatColor;

import java.util.List;

public class CC {

    public static String translate(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> translateList(List<String> list) {
        list.replaceAll(lines -> ChatColor.translateAlternateColorCodes('&', lines));
        return list;
    }
}
