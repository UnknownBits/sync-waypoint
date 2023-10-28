package net.unknownbits.waypoints.commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ibm.icu.impl.UResource;
import com.mojang.authlib.GameProfile;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.unknownbits.waypoints.Reference;
import net.unknownbits.waypoints.Waypoints;
import net.unknownbits.waypoints.entity.Waypoint;
import net.unknownbits.waypoints.util.DataStorage;
import net.unknownbits.waypoints.util.RenderTextFactory;
import net.unknownbits.waypoints.util.Utils;

import java.util.ArrayList;
import java.util.Objects;

public class WaypointsCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        var Croot = CommandManager.literal("waypoints")
                .executes(context -> {
                    context.getSource().sendMessage(RenderTextFactory.root);
                    return 0;
                });

        var Croot2 = CommandManager.literal("wp")
                .executes(context -> {
                    context.getSource().sendMessage(Text.translatable("waypoints.info", Reference.VERSION));
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
                            else
                                if (data.startsWith("[x:")) wp = Waypoint.generateFromJourneyMap(data, creator);

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

        dispatcher.register(Croot2.then(Clist).then(Cadd).then(Creload).then(Cremove).then(Cmodify));
        dispatcher.register(Croot.then(Clist).then(Cadd).then(Creload).then(Cremove).then(Cmodify));
    }
}
