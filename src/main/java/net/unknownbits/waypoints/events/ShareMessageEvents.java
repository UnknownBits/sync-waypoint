package net.unknownbits.waypoints.events;

import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.unknownbits.waypoints.entity.WaypointFactory;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3i;
import net.unknownbits.waypoints.entity.Waypoint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.unknownbits.waypoints.Waypoints.waypointList;

public class ShareMessageEvents {
    public static void register(SignedMessage message, ServerPlayerEntity sender, MessageType.Parameters params) {
        var content = message.getContent().getString();

        Waypoint wp = null;
        if (content.startsWith("xaero-waypoint:")) {
            wp = WaypointFactory.GeneratefromXaeroMap(content,sender.getGameProfile());
        } else if (content.startsWith("[x:")) {
            wp = WaypointFactory.GeneratefromJourneyMap(content,sender.getGameProfile());
        }

        if (wp != null) WaypointFactory.add(wp);
    }
}
