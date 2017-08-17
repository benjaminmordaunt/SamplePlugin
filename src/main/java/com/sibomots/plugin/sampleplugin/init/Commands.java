package com.sibomots.plugin.sampleplugin.init;

import com.sibomots.plugin.sampleplugin.command.JiveCommand;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

public class Commands {

    private CommandElement element = GenericArguments.flags().flag("help").setAcceptsArbitraryLongFlags(true).buildWith(GenericArguments.none());

    public static String JIVE = "jive";

    public CommandSpec cmdJiveHandler = CommandSpec.builder()
            .permission("simplechat.cmd.message")
            .arguments(element, GenericArguments.player(Text.of("player")), GenericArguments.remainingJoinedStrings(Text.of("message")))
            .executor(new JiveCommand())
            .build();
}
