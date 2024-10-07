package top.unknownbits.sync_waypoint.events;

import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.network.ServerPlayerEntity;
import top.unknownbits.sync_waypoint.entity.Waypoint;
import top.unknownbits.sync_waypoint.util.DataStorage;

public class ShareMessageEvents {
    public static void register(SignedMessage message, ServerPlayerEntity sender) {
        var content = message.getContent().getString();

        Waypoint wp = null;
        if (content.startsWith("xaero-waypoint:")) {
            wp = Waypoint.generateFromXaeroMap(content, sender.getGameProfile());
        } else if (content.startsWith("[x:")) {
            wp = Waypoint.generateFromJourneyMap(content, sender.getGameProfile());
        }

        if (wp != null) DataStorage.getInstance().getWaypointList().add(wp);
    }
}
