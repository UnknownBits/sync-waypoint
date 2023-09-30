package net.unknownbits.waypoints.events;

import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.unknownbits.waypoints.Waypoint;

import static net.unknownbits.waypoints.Waypoints.waypointList;

public class ShareMessageEvents {

        // 标头:名称:标识:x:y:z:未知:未知:世界标识
        // xaero-waypoint:Waypoint:X:164:63:158:14:false:0:Internal-overworld-waypoints
        public static void register(SignedMessage message, ServerPlayerEntity sender, MessageType.Parameters params) {
            if (message.getContent().getString().startsWith("xaero-waypoint:")){
                String[] data =  message.getContent().getString().split(":");
                sender.sendMessage(sender.getDisplayName());
                sender.sendMessage(Text.literal(data[9]));
                int x = Integer.parseInt(data[4]);
                int y = Integer.parseInt(data[5]);
                int z = Integer.parseInt(data[6]);
                waypointList.add(new Waypoint(x,y,z,sender.getGameProfile()));
            }
            sender.sendMessage(message.getContent());
        }
}
