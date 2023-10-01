package net.unknownbits.waypoints.client.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.unknownbits.waypoints.client.Config;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class ConfigCommand {
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(
                literal("waypoints").then(
                        literal("config").then(
                                literal("link_plus").then(
                                        ClientCommandManager.argument("opt", BoolArgumentType.bool()).executes(context -> execute(BoolArgumentType.getBool(context, "opt")))
                                )
                        ).then(
                                literal("linkplus").then(
                                        ClientCommandManager.argument("opt", BoolArgumentType.bool()).executes(context -> execute(BoolArgumentType.getBool(context, "opt")))
                                )
                        )
                )
        );
    }

    private static int execute(boolean x) {
        Config.TextClick = x;
        return 0;
    }
}