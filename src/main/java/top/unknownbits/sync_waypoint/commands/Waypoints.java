package top.unknownbits.sync_waypoint.commands;


import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import top.unknownbits.sync_waypoint.entity.Waypoint;
import top.unknownbits.sync_waypoint.util.DataStorage;
import top.unknownbits.sync_waypoint.util.RenderTextFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Waypoints {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        var Croot = CommandManager.literal("waypoints")
                .executes(context -> {
                    context.getSource().sendMessage(Text.literal("§e§l【Sync_Waypoint】§r")
                            .append(RenderTextFactory.LINEFEED)
                            .append(RenderTextFactory.FunctionButtons));
                    return 0;
                });

        var Clist = CommandManager.literal("list")
                .executes(context -> {
                    var source = context.getSource();
                    var list = DataStorage.getInstance().getWaypointList();
                    for (Waypoint waypoint : list) {
                        source.sendMessage(Text.literal(waypoint.toString()));
                    }
                    return 0;
                })
                .then(CommandManager.argument("page", IntegerArgumentType.integer(1))
                        .executes(context -> {
                            var source = context.getSource();
                            var list = find_list(IntegerArgumentType.getInteger(context,"page"));
                            for (Waypoint waypoint : list) {
                                source.sendMessage(Text.literal(waypoint.toString()));
                            }

                            return 0;
                        }));

        var Cadd = CommandManager.literal("add")
                .then(CommandManager.argument("data", StringArgumentType.string())
                        .executes(context -> {
                            var source = context.getSource();
                            var creator = Objects.requireNonNull(source.getPlayer()).getGameProfile();
                            var data = StringArgumentType.getString(context, "data");
                            Waypoint wp = Waypoint.of(data, creator);
                            DataStorage.getInstance().getWaypointList().add(wp);
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

    private static List<Waypoint> find_list(int pageNo) {
        var list = DataStorage.getInstance().getWaypointList();
        var pageSize = 5;
        List<Waypoint> subList = list.stream().skip((pageNo - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        return subList;
    }
}
