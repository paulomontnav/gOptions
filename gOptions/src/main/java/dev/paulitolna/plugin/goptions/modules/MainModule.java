package dev.paulitolna.plugin.goptions.modules;

import dev.paulitolna.plugin.goptions.Main;
import dev.paulitolna.plugin.goptions.utils.Binder;
import dev.paulitolna.plugin.goptions.utils.FileCreator;
import me.yushust.inject.AbstractModule;
import org.bukkit.plugin.Plugin;

public class MainModule extends AbstractModule {

    private final Main plugin;

    public MainModule(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        bind(Main.class).toInstance(plugin);
        bind(Plugin.class).to(Main.class);

        Binder binder = new Binder()
                .bind("config", new FileCreator(plugin, "config"))
                .bind("messages", new FileCreator(plugin, "messages"))
                .bind("menus", new FileCreator(plugin, "menus"));

        install(binder.build());
        install(new ServiceModule());
        install(new LoaderModule());
        install(new MenuModule());
    }
}
