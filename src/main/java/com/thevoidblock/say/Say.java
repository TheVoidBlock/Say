package com.thevoidblock.say;

import com.thevoidblock.say.command.SayCommand;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Say implements ClientModInitializer {

    public static final String MOD_ID = "say";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static MinecraftClient CLIENT = MinecraftClient.getInstance();

    @Override
    public void onInitializeClient() {

        SayCommand.register();

        LOGGER.info("{} initialized!", MOD_ID);

    }
}
