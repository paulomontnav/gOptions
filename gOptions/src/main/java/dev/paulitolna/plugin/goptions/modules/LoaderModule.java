package dev.paulitolna.plugin.goptions.modules;

import dev.paulitolna.plugin.goptions.loader.CommandLoader;
import dev.paulitolna.plugin.goptions.loader.EventLoader;
import dev.paulitolna.plugin.goptions.loader.Loader;
import me.yushust.inject.AbstractModule;

public class LoaderModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Loader.class).named("command-loader").to(CommandLoader.class);
        bind(Loader.class).named("event-loader").to(EventLoader.class);
    }
}
