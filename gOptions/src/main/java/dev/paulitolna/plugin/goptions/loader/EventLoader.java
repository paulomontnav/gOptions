package dev.paulitolna.plugin.goptions.loader;

import dev.paulitolna.plugin.goptions.Main;
import dev.paulitolna.plugin.goptions.events.MainMenuListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import javax.inject.Inject;

public class EventLoader implements Loader {

    @Inject private Main plugin;

    @Inject private MainMenuListener mainMenuListener;

    @Override
    public void load() {
        PluginManager pluginManager = plugin.getServer().getPluginManager();
        pluginManager.registerEvents((Listener) mainMenuListener, (Plugin) this);
    }
}
