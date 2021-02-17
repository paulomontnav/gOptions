package dev.paulitolna.plugin.goptions;

import dev.paulitolna.plugin.goptions.modules.MainModule;
import dev.paulitolna.plugin.goptions.services.Service;
import me.yushust.inject.Injector;
import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Inject;
import javax.inject.Named;

public final class Main extends JavaPlugin {

    @Inject @Named("main-service") private Service mainService;

    @Override
    public void onEnable() {
        Injector injector = Injector.create(new MainModule(this));
        injector.injectMembers(this);
        this.getLogger().info("Loading plugin...");
        this.getLogger().info("Correctly loaded!");
        mainService.start();
    }

    @Override
    public void onDisable() {
        this.getLogger().info("Correctly disabled!");
    }
}
