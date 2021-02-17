package dev.paulitolna.plugin.goptions.services;

import dev.paulitolna.plugin.goptions.loader.Loader;

import javax.inject.Inject;
import javax.inject.Named;

public class MainService implements Service {

    @Inject @Named("command-loader") private Loader commandLoader;

    @Inject @Named("event-loader") private Loader eventLoader;

    @Override
    public void start() {
        commandLoader.load();
        eventLoader.load();
    }
}
