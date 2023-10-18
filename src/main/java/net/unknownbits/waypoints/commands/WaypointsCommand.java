package net.unknownbits.waypoints.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.unknownbits.waypoints.Waypoints;
import net.unknownbits.waypoints.entity.Waypoint;
import net.unknownbits.waypoints.entity.WaypointFactory;

import java.util.Objects;

import static net.unknownbits.waypoints.Waypoints.waypointList;

public class WaypointsCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        var Croot = CommandManager.literal("waypoints")
                .executes(context -> {
                    context.getSource().sendMessage(Text.translatable("waypoints.info", Waypoints.VERSION));
                    return 0;
                });

        var Clist = CommandManager.literal("list")
                .executes(context -> {
                    var source = context.getSource();

                    for (Waypoint waypoint : Waypoints.waypointList) {
                        source.sendMessage(Text.translatable(waypoint.toString()));
                    }
                    return 0;
                });

        var Cadd = CommandManager.literal("add")
                .then(CommandManager.argument("data", StringArgumentType.string())
                        .executes(context -> {
                            var source = context.getSource();
                            var creator = Objects.requireNonNull(source.getPlayer()).getGameProfile();
                            var data = StringArgumentType.getString(context,"data");


                            Waypoint wp = null;
                            if (data.startsWith("xaero-waypoint:")) {
                                wp = WaypointFactory.GeneratefromXaeroMap(data, creator);
                            } else if (data.startsWith("[x:")) {
                                wp = WaypointFactory.GeneratefromJourneyMap(data,creator);
                            }

                            if (wp != null) WaypointFactory.add(wp);
                            return 0;
                        }));

        var Cremove = CommandManager.literal("remove")
                .executes(context -> {
                    return 0;
                });

        var Cmodify = CommandManager.literal("modify")
                .executes(context -> {
                    return 0;
                });


        var Creload = CommandManager.literal("reload")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(context -> {
                    context.getSource().sendMessage(Text.Serializer.fromJson("{\"text\":\"Click this!\",\"clickEvent\": {\"action\":\"run_command\",\"value\":\"/say Hello!\"}}"));
                    return 0;
                });

        dispatcher.register(Croot.then(Clist).then(Cadd).then(Creload).then(Cremove).then(Cmodify));
    }
}
