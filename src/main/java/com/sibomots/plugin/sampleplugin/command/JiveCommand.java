package com.sibomots.plugin.sampleplugin.command;

import com.sibomots.plugin.sampleplugin.SamplePlugin;
import com.sibomots.plugin.sampleplugin.Permissions;
import com.sibomots.plugin.sampleplugin.init.Commands;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.message.MessageChannelEvent;
import org.spongepowered.api.event.message.MessageEvent;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.text.channel.MutableMessageChannel;

import java.util.Optional;

public class JiveCommand extends JiveCommandBase implements CommandExecutor {


    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        String message = args.<String> getOne("message").get();
        MutableMessageChannel msgChannel = MessageChannel.TO_ALL.asMutable();
        Text text = getText(message, src.hasPermission(Permissions.JIVE_COLOR));
        return null;
    }
}
