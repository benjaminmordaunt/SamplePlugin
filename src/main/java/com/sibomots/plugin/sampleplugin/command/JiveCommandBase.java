package com.sibomots.plugin.sampleplugin.command;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;

public class JiveCommandBase {

    public Text processText(String msg, boolean color) {
        if(color) {
            return TextSerializers.FORMATTING_CODE.deserialize(msg);
        } else {
            return Text.of(msg);
        }
    }

    public Text getText(String msg, boolean color) {
            return processText(msg, color);
    }
}
