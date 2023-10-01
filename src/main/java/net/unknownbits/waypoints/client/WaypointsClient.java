package net.unknownbits.waypoints.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;

import static net.unknownbits.waypoints.client.commands.CCManager.register;

@Environment(EnvType.CLIENT)
public class WaypointsClient implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        if (ClientCommandManager.getActiveDispatcher() != null)
            register(ClientCommandManager.getActiveDispatcher());
    }
}
