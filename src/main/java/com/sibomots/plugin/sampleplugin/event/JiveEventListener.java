package com.sibomots.plugin.sampleplugin.event;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.message.MessageChannelEvent;
import org.spongepowered.api.event.message.MessageEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.text.channel.MutableMessageChannel;

import java.util.Optional;

public class JiveEventListener {

    @Listener
    public void onClientConnectionEventJoin(ClientConnectionEvent.Join event) {
        // TBD
    }

    @Listener(order = Order.LAST)
    public void MessageChannelEventChat(MessageChannelEvent.Chat event, @First Player player) {
        Optional<MessageChannel> optionalChannel = event.getChannel();

        if (!optionalChannel.isPresent()) {
            return;
        }
        MutableMessageChannel messageChannel = optionalChannel.get().asMutable();
        MessageEvent.MessageFormatter formatter = event.getFormatter();

        // TBD
    }

}
