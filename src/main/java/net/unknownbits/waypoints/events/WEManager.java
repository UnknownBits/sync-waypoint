package net.unknownbits.waypoints.events;

import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.network.message.MessageType.Parameters;

public class WEManager {
    public static void register(SignedMessage message, ServerPlayerEntity sender, Parameters params) {
        ShareMessageEvents.register(message,sender,params);
    }
}
