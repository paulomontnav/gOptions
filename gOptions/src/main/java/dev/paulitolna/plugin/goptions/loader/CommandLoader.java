package dev.paulitolna.plugin.goptions.loader;

import dev.paulitolna.plugin.goptions.Main;
import dev.paulitolna.plugin.goptions.commands.OptionsCommand;
import dev.paulitolna.plugin.goptions.commands.gOptionsCommand;
import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilderImpl;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.annotated.part.SimplePartInjector;
import me.fixeddev.commandflow.annotated.part.defaults.DefaultsModule;
import me.fixeddev.commandflow.bukkit.BukkitCommandManager;
import me.fixeddev.commandflow.bukkit.factory.BukkitModule;
import me.fixeddev.commandflow.command.Command;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CommandLoader implements Loader {

    @Inject private Main plugin;

    @Inject private gOptionsCommand gOptionsCommand;

    @Inject private OptionsCommand optionsCommand;

    @Override
    public void load() {
        PartInjector partInjector = new SimplePartInjector();
        partInjector.install(new DefaultsModule());
        partInjector.install(new BukkitModule());

        AnnotatedCommandTreeBuilder builder = new AnnotatedCommandTreeBuilderImpl(partInjector);
        CommandManager commandManager = new BukkitCommandManager(plugin.getName());

        List<Command> commandList = new ArrayList<>();

        commandList.addAll(builder.fromClass(this.gOptionsCommand));
        commandList.addAll(builder.fromClass(this.optionsCommand));
        commandManager.registerCommands(commandList);
    }
}
