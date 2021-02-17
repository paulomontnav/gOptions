package dev.paulitolna.plugin.goptions.utils;

import me.yushust.inject.Module;

import java.util.HashMap;
import java.util.Map;

public class Binder {

    private final Map<String, FileCreator> files = new HashMap<>();

    public Binder bind(String name, FileCreator configuration) {
        files.put(name, configuration);

        return this;
    }

    public Module build() {
        return binder -> files.forEach((name, file) -> binder.bind(FileCreator.class).named(name).toInstance(file));
    }
}
