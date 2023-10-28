package net.unknownbits.waypoints;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.Version;
import net.minecraft.text.Text;

public class Reference {
    public static final String MOD_ID = "waypoints";
    public static final String MOD_NAME = Text.translatable("waypoints.name").toString();
    public static final String GITHUB_REF = "UnknownBits/ModMenu";
    public static final Version VERSION = FabricLoader.getInstance().getModContainer(MOD_ID).isPresent() ? FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getVersion() : null;
}
