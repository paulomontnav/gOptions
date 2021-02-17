package dev.paulitolna.plugin.goptions.modules;

import dev.paulitolna.plugin.goptions.menus.MenuCreator;
import dev.paulitolna.plugin.goptions.menus.options.MainMenu;
import me.yushust.inject.AbstractModule;

public class MenuModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MenuCreator.class).named("main-menu").to(MainMenu.class).singleton();
    }
}
