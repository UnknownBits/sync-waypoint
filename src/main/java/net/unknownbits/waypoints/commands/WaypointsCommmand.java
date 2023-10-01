package net.unknownbits.waypoints.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.unknownbits.waypoints.Waypoints;
import net.unknownbits.waypoints.client.Config;
import net.unknownbits.waypoints.entity.Waypoint;

public class WaypointsCommmand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("waypoints")
                .executes(context -> {
                    context.getSource().sendMessage(Text.translatable("waypoints.info", Waypoints.VERSION));
                    return 0;
                }).then(CommandManager.literal("reload")
                        .requires(source -> source.hasPermissionLevel(2))
                        .executes(context -> {
                            context.getSource().sendMessage(Text.Serializer.fromJson("{\"text\":\"Click this!\",\"clickEvent\": {\"action\":\"run_command\",\"value\":\"/say Hello!\"}}"));
                            return 0;
                        })).then(CommandManager.literal("list")
                        .executes(context -> {
                            for (Waypoint waypoint : Waypoints.waypointList) {
                                context.getSource().sendMessage(Text.translatable(waypoint.toShortString()));
                                context.getSource().sendMessage(Text.translatable(waypoint.getGameProfile().getName()));
                            }
                            return 0;
                        })).then(CommandManager.literal("add").executes(context -> {
                    return 0;
                })).then(CommandManager.literal("remove").executes(context -> {
                    return 0;
                })).then(CommandManager.literal("config").executes(context -> {
                    Config.TextClick = true;
                    return 0;
                }))
        );
    }
}
