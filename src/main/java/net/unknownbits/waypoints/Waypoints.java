package net.unknownbits.waypoints;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.Version;
import net.unknownbits.waypoints.commands.WCManager;
import net.unknownbits.waypoints.events.WEManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.server.command.CommandManager.*;
public class Waypoints implements ModInitializer {
    public static final String MOD_ID = "waypoints";
    public static final String GITHUB_REF = "UnknownBits/ModMenu";
    public static final Logger LOGGER = LoggerFactory.getLogger("Mod Menu");
    public static List<Waypoint> waypointList = new ArrayList<>();
    public static final Version VERSION = FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getVersion();
    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(WCManager::register);
        ServerMessageEvents.CHAT_MESSAGE.register(WEManager::register);
    }
}
