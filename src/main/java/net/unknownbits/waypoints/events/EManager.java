package net.unknownbits.waypoints.events;

import net.minecraft.network.message.MessageType.Parameters;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.network.ServerPlayerEntity;

public class EManager {
    public static void register(SignedMessage message, ServerPlayerEntity sender, Parameters params) {
        ShareMessageEvents.register(message, sender, params);
    }
}
