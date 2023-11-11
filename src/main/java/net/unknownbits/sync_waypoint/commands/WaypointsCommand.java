package net.unknownbits.sync_waypoint.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.unknownbits.sync_waypoint.entity.Waypoint;
import net.unknownbits.sync_waypoint.util.DataStorage;
import net.unknownbits.sync_waypoint.util.RenderTextFactory;

import java.util.Objects;

public class WaypointsCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        var Croot = CommandManager.literal("waypoints")
                .executes(context -> {
                    context.getSource().sendMessage(Text.literal("§e§l【Sync_Waypoint】§r")
                            .append(RenderTextFactory.LINEFEED)
                            .append(RenderTextFactory.FunctionButtons)
                    );
                    return 0;
                });

        var Clist = CommandManager.literal("list")
                .executes(context -> {
                    var source = context.getSource();

                    return 0;
                })
                .then(CommandManager.argument("page", IntegerArgumentType.integer(1))
                        .executes(context -> {
                            var source = context.getSource();

                            for (Waypoint waypoint : DataStorage.getInstance().getWaypointList()) {
                                source.sendMessage(Text.translatable(waypoint.toString()));
                            }
                            return 0;
                        }));

        var Cadd = CommandManager.literal("add")
                .then(CommandManager.argument("data", StringArgumentType.string())
                        .executes(context -> {
                            var source = context.getSource();
                            var creator = Objects.requireNonNull(source.getPlayer()).getGameProfile();
                            var data = StringArgumentType.getString(context, "data");

                            Waypoint wp = null;

                            if (data.startsWith("xaero-waypoint:")) wp = Waypoint.generateFromXaeroMap(data, creator);
                            else if (data.startsWith("[x:")) wp = Waypoint.generateFromJourneyMap(data, creator);

                            if (wp != null) DataStorage.getInstance().getWaypointList().add(wp);
                            return 0;
                        }));

        var Cremove = CommandManager.literal("remove")
                .executes(context -> 0);

        var Cmodify = CommandManager.literal("modify")
                .executes(context -> 0);


        var Creload = CommandManager.literal("reload")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(context -> {
                    return 0;
                });

        dispatcher.register(Croot.then(Clist).then(Cadd).then(Creload).then(Cremove).then(Cmodify));
    }
}
