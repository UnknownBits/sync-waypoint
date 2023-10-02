package net.unknownbits.waypoints;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.Version;
import net.unknownbits.waypoints.commands.CManager;
import net.unknownbits.waypoints.entity.Waypoint;
import net.unknownbits.waypoints.events.EManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Waypoints implements ModInitializer {
    public static final String MOD_ID = "waypoints";
    public static final String GITHUB_REF = "UnknownBits/ModMenu";
    public static final Logger LOGGER = LoggerFactory.getLogger("Mod Menu");
    public static final Version VERSION = FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getVersion();
    public static List<Waypoint> waypointList = new ArrayList<>();

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(CManager::register);
        ServerMessageEvents.CHAT_MESSAGE.register(EManager::register);
    }
}
