package net.unknownbits.waypoints.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.authlib.GameProfile;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.unknownbits.waypoints.entity.Waypoint;

import java.util.ArrayList;
import java.util.List;

// 标头:名称:标识:x:y:z:未知:未知:世界标识
// xaero-waypoint:Waypoint:X:164:63:158:14:false:0:Internal-overworld-waypoints
// [x:19, y:63, z:3, dim:minecraft:overworld]
public class DataStorage {
    static final DataStorage INSTANCE = new DataStorage();
    public static Gson GSON = Utils.make(() -> {
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        gsonBuilder.registerTypeAdapter(GameProfile.class, new GameProfile.Serializer());
        gsonBuilder.registerTypeAdapter(Identifier.class, new Identifier.Serializer());
        gsonBuilder.registerTypeAdapter(Text.class, new Text.Serializer());
        return gsonBuilder.create();
    });
    private final List<Waypoint> waypointList;
    private int per_page;

    private DataStorage() {
        this.waypointList = new ArrayList<>();
        this.per_page = 5;
    }

    public static DataStorage getInstance() {
        return INSTANCE;
    }


    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public List<Waypoint> getWaypointList() {
        return waypointList;
    }
}
