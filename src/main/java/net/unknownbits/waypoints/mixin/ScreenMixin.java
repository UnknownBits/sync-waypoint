package net.unknownbits.waypoints.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.unknownbits.waypoints.client.Config;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Screen.class)
public abstract class ScreenMixin {
    @Shadow
    @Nullable
    protected MinecraftClient client;

    @SuppressWarnings("ConstantConditions")
    @Redirect(
            method = "handleTextClick",
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args = "stringValue=/"
                    )
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/slf4j/Logger;error(Ljava/lang/String;Ljava/lang/Object;)V",
                    remap = false,
                    ordinal = 1
            ),
            require = 1
    )
    private void justSendTheChat(Logger logger, String loggingMessage, Object clickEventContent) {
        // message.charAt(0) != '/'
        String message = (String) clickEventContent;
        if (!Config.TextClick) return;
        if (message.startsWith("xaero_waypoint_add:") || message.startsWith("#"))
            this.client.player.networkHandler.sendChatMessage(message);
    }
}
