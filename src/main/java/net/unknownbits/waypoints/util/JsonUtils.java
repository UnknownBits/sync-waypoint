package net.unknownbits.waypoints.util;

import com.google.gson.*;
import net.minecraft.util.math.Vec3i;
import org.jetbrains.annotations.Nullable;

public class JsonUtils {

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static boolean hasArray(JsonObject obj, String name)
    {
        JsonElement el = obj.get(name);
        return el != null && el.isJsonArray();
    }
    public static boolean hasVec3i(JsonObject obj, String name)
    {
        return vec3iFromJson(obj, name) != null;
    }

    public static JsonArray vec3iToJson(Vec3i vec)
    {
        JsonArray arr = new JsonArray();
        arr.add(vec.getX());
        arr.add(vec.getY());
        arr.add(vec.getZ());
        return arr;
    }

    @Nullable
    public static Vec3i vec3iFromJson(JsonObject obj, String name)
    {
        if (hasArray(obj, name))
        {
            JsonArray arr = obj.getAsJsonArray(name);
            if (arr.size() == 3)
                try { return new Vec3i(arr.get(0).getAsInt(), arr.get(1).getAsInt(), arr.get(2).getAsInt()); }
                catch (Exception ignore) {}
        }
        return null;
    }
}
