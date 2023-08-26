package net.unknownbits.waypoints;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.unknownbits.waypoints.commands.WCManager;
import net.unknownbits.waypoints.events.WEManager;

import static net.minecraft.server.command.CommandManager.*;
public class Waypoints implements ModInitializer {
    public final static String VERSTION = "v1.0";
    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(WCManager::register);
        ServerMessageEvents.CHAT_MESSAGE.register(WEManager::register);
    }
}
