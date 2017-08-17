package com.sibomots.plugin.sampleplugin;

import com.google.inject.Inject;
import com.sibomots.plugin.sampleplugin.command.JiveCommand;
import com.sibomots.plugin.sampleplugin.event.JiveEventListener;
import com.sibomots.plugin.sampleplugin.init.Commands;
import com.sibomots.plugin.sampleplugin.init.Resource;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;


@Plugin(id = Resource.ID, name = Resource.NAME,
        description = Resource.DESCRIPTION, version = Resource.VERSION)
public class SamplePlugin {

    private static SamplePlugin instance;
    private static PluginContainer plugin;

    @Inject
    private Logger logger;

    public static SamplePlugin instance()
    {
        return instance;
    }

    @Listener
    public void onPreInitializationEvent(GamePreInitializationEvent event) {
        plugin = Sponge.getPluginManager().getPlugin(Resource.ID).get();
        instance = this;

    }

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
    }

    @Listener
    public void onInitializationEvent(GameInitializationEvent event) {
        Sponge.getEventManager().registerListeners(this, new JiveEventListener());
        CommandSpec myCommandSpec = CommandSpec.builder()
                .description(Text.of("Hello World Command"))
                .permission("myplugin.command.helloworld")
                .executor(new JiveCommand())
                .build();
        Sponge.getCommandManager().register(plugin, myCommandSpec, "helloworld", "hello", "test");
    }
}

