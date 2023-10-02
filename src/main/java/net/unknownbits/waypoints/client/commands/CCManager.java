package net.unknownbits.waypoints.client.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.command.CommandRegistryAccess;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;


public class CCManager {
    public static LiteralArgumentBuilder<FabricClientCommandSource> root = literal("waypoints");

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
        ConfigCommand.register(dispatcher, root);
        dispatcher.register(root);
    }
}
