package com.thevoidblock.say.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;

import static com.thevoidblock.say.Say.CLIENT;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class SayCommand {
    public static void register() {

        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(
                    literal(".")
                            .then(argument("message", StringArgumentType.greedyString())
                                    .executes(context -> {
                                        String message = StringArgumentType.getString(context, "message");
                                        if(CLIENT.getNetworkHandler() != null)
                                            CLIENT.getNetworkHandler().sendChatMessage(message);
                                        return 1;
                                    })
                            )
            );
        });

    }
}
