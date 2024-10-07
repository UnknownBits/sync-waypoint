package top.unknownbits.sync_waypoint.events;

import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.network.ServerPlayerEntity;
import top.unknownbits.sync_waypoint.entity.Waypoint;
import top.unknownbits.sync_waypoint.util.DataStorage;

public class ShareMessageEvents {
    public static void register(SignedMessage message, ServerPlayerEntity sender) {
        var content = message.getContent().getString();
        Waypoint wp = Waypoint.of(content,sender.getGameProfile());
        DataStorage.getInstance().getWaypointList().add(wp);
    }
}