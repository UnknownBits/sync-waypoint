package net.unknownbits.waypoints;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.unknownbits.waypoints.commands.WaypointsCommand;
import net.unknownbits.waypoints.events.ShareMessageEvents;

public class Waypoints implements ModInitializer {


    public static void EventsRegister(SignedMessage message, ServerPlayerEntity sender, MessageType.Parameters params) {
        ShareMessageEvents.register(message, sender);
    }

    public static void CommandsRegister(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess registryAccess, CommandManager.RegistrationEnvironment environment) {
        WaypointsCommand.register(dispatcher);
    }

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(Waypoints::CommandsRegister);
        ServerMessageEvents.CHAT_MESSAGE.register(Waypoints::EventsRegister);
    }
}
