package net.unknownbits.waypoints.client.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class ConfigScreen extends Screen {
    private Screen parent;

    public ConfigScreen() {
        super(Text.translatable("config.chatimage.category"));
    }

    public ConfigScreen(Screen screen) {
        super(Text.translatable("config.chatimage.category"));
        this.parent = screen;
    }
}
