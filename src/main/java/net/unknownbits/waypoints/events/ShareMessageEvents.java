package net.unknownbits.waypoints.events;

import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.unknownbits.waypoints.entity.Waypoint;
import net.unknownbits.waypoints.entity.WaypointFactory;

public class ShareMessageEvents {
    public static void register(SignedMessage message, ServerPlayerEntity sender) {
        var content = message.getContent().getString();

        Waypoint wp = null;
        if (content.startsWith("xaero-waypoint:")) {
            wp = WaypointFactory.GeneratefromXaeroMap(content, sender.getGameProfile());
        } else if (content.startsWith("[x:")) {
            wp = WaypointFactory.GeneratefromJourneyMap(content, sender.getGameProfile());
        }

        if (wp != null) WaypointFactory.add(wp);
    }
}
