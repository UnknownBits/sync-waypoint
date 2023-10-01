package net.unknownbits.waypoints.client.commands;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;
import net.unknownbits.waypoints.client.Config;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class ConfigCommand {
    public static void register(LiteralArgumentBuilder<FabricClientCommandSource> root) {
        var link_plus =
                literal("link_plus")
                        .executes(c -> {
                            c.getSource().getPlayer().sendMessage(Text.translatable("waypoints.link_plus"));
                            return 0;
                        })
                        .then(ClientCommandManager.argument("value", BoolArgumentType.bool())
                                .executes(c -> {
                                    Config.TextClick = BoolArgumentType.getBool(c, "value");
                                    return 0;
                                })
                        );
        
        root.then(
                literal("config")
                        .then(link_plus)
        );
    }
}