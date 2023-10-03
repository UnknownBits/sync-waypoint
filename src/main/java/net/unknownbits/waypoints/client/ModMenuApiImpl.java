package net.unknownbits.waypoints.client;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.unknownbits.waypoints.client.gui.ConfigScreen;

import java.util.Map;
import java.util.function.Consumer;

public class ModMenuApiImpl implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() { return ConfigScreen::new; }

    @Override
    public void attachModpackBadges(Consumer<String> consumer) {
        ModMenuApi.super.attachModpackBadges(consumer);
    }
}
