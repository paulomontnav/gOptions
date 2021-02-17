package dev.paulitolna.plugin.goptions.modules;

import dev.paulitolna.plugin.goptions.services.MainService;
import dev.paulitolna.plugin.goptions.services.Service;
import me.yushust.inject.AbstractModule;

public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Service.class).named("main-service").to(MainService.class);
    }
}
