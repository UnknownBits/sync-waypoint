package net.unknownbits.waypoints.entity;

import com.mojang.authlib.GameProfile;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3i;
import net.unknownbits.waypoints.Waypoints;

import java.time.Instant;
import java.util.regex.Pattern;

public class WaypointFactory {
    // 标头:名称:标识:x:y:z:未知:未知:世界标识
    // xaero-waypoint:Waypoint:X:164:63:158:14:false:0:Internal-overworld-waypoints
    // [x:19, y:63, z:3, dim:minecraft:overworld]
    public static Waypoint GeneratefromXaeroMap(String data, GameProfile creator) {
        String[] cache = data.split(":");

        int x = Integer.parseInt(cache[3]);
        int y = Integer.parseInt(cache[4]);
        int z = Integer.parseInt(cache[5]);
        var pos = new Vec3i(x, y, z);

        var wp = new Waypoint(creator, pos);
        wp.setId(Text.of(cache[1]));

        return wp;
    }

    public static Waypoint GeneratefromJourneyMap(String data, GameProfile creator) {
        String[] cache = data.split(":");

        int x = Integer.parseInt(cache[1].split(",")[0]);
        int y = Integer.parseInt(cache[2].split(",")[0]);
        int z = Integer.parseInt(cache[3].split(",")[0]);
        var pos = new Vec3i(x, y, z);
        var wp = new Waypoint(creator, pos);

        return wp;
    }

    public static void add(Waypoint wp){
        for (Waypoint waypoint: Waypoints.waypointList) {
            if (waypoint == wp) return;
        }
        Waypoints.waypointList.add(wp);
    }
}
