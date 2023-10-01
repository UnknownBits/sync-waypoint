package net.unknownbits.waypoints.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.unknownbits.waypoints.client.commands.CCManager;

import static net.unknownbits.waypoints.client.commands.CCManager.register;

@Environment(EnvType.CLIENT)
public class WaypointsClient implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register(CCManager::register);
    }
}
