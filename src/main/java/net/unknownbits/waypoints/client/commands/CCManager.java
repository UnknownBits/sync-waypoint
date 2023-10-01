package net.unknownbits.waypoints.client.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

public class CCManager {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        ConfigCommand.register(dispatcher);
    }
}
