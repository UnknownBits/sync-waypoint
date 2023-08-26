package net.unknownbits.waypoints.mixin;

import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerWarningScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {

    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @ModifyArg(method = "init()V",at= @At(value = "INVOKE",target = "Lnet/minecraft/client/gui/widget/TexturedButtonWidget;<init>(IIIIIIILnet/minecraft/util/Identifier;IILnet/minecraft/client/gui/widget/ButtonWidget$PressAction;Lnet/minecraft/text/Text;)V"),index = 1)
    private int anInt(int y){
        return y + 12;
    }

    @ModifyArg(method = "init()V",at= @At(value = "INVOKE",target = "Lnet/minecraft/client/gui/widget/ButtonWidget$Builder;dimensions(IIII)Lnet/minecraft/client/gui/widget/ButtonWidget$Builder;"),index = 1)
    private int anInts(int y){
        return y + 12;
    }

    @Inject(method = "initWidgetsNormal", at = @At("TAIL"),locals = LocalCapture.CAPTURE_FAILHARD)
    private void setButton(int y, int spacingY, CallbackInfo ci) {
        this.addDrawableChild(ButtonWidget.builder(Text.translatable("menu.waypoints"), (button) -> {
        }).dimensions(this.width / 2 - 100, y + spacingY * 3, 200, 20).build());
    }
}
