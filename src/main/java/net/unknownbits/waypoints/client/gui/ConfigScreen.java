package net.unknownbits.waypoints.client.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.CyclingButtonWidget;
import net.minecraft.client.gui.widget.GridWidget;
import net.minecraft.client.gui.widget.SimplePositioningWidget;
import net.minecraft.text.Text;
import net.unknownbits.waypoints.client.Config;

@Environment(EnvType.CLIENT)
public class ConfigScreen extends Screen {
    public static final Text TITLE = Text.translatable("waypoints.config");
    private Screen parent;

    public ConfigScreen() {
        super(TITLE);
    }

    public ConfigScreen(Screen screen) {
        super(TITLE);
        this.parent = screen;
    }

    public void close() {
        this.client.setScreen(parent);
    }

    protected void init() {
        super.init();
        GridWidget gridWidget = new GridWidget();
        gridWidget.getMainPositioner().marginX(5).marginBottom(4).alignHorizontalCenter();
        GridWidget.Adder adder = gridWidget.createAdder(2);
        adder.add(CyclingButtonWidget.onOffBuilder(Config.TextClick).build(0, 0, 150, 20, Text.translatable("settings.waypoints.link-plus"), (button, value) -> Config.TextClick = !Config.TextClick), 2);
        adder.add(ButtonWidget.builder(Text.translatable("gui.back"), (button) -> {
            if (this.client != null) this.client.setScreen(this.parent);
        }).build(), 2);
        gridWidget.refreshPositions();
        SimplePositioningWidget.setPos(gridWidget, 0, this.height / 3 - 12, this.width, this.height, 0.5F, 0.0F);
        gridWidget.forEachChild(this::addDrawableChild);
    }

    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, title, this.width / 2, this.height / 3 - 32, 16764108);
    }
}
