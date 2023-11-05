package net.unknownbits.waypoints;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.authlib.GameProfile;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.Version;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.unknownbits.waypoints.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WaypointsExtension {
    public static final String MOD_ID = "waypoints";
    public static final Logger logger = LogManager.getLogger(MOD_ID);
    public static final String MOD_NAME = Text.translatable("waypoints.name").toString();
    public static final String GITHUB_REF = "UnknownBits/ModMenu";
    public static final Version VERSION = FabricLoader.getInstance().getModContainer(MOD_ID).isPresent() ? FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getVersion() : null;
    public static Gson GSON = Utils.make(() -> {
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        gsonBuilder.registerTypeAdapter(GameProfile.class, new GameProfile.Serializer());
        gsonBuilder.registerTypeAdapter(Identifier.class, new Identifier.Serializer());
        gsonBuilder.registerTypeAdapter(Text.class, new Text.Serializer());
        return gsonBuilder.create();
    });
}
