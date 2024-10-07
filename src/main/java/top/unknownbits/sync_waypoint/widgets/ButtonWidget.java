package top.unknownbits.sync_waypoint.widgets;

import com.google.common.collect.Lists;
import net.minecraft.text.*;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ButtonWidget extends MutableText {
    public ButtonWidget(TextContent content, @Nullable Style style) {
        super(content, Lists.newArrayList(), style);
    }

    public static ButtonWidget literal(String string, @Nullable Style style) {
        return new ButtonWidget(Text.literal(string).getContent(), style);
    }

    public static ButtonWidget literal(String string, @Nullable TextColor color, @Nullable ClickEvent clickEvent, @Nullable HoverEvent hoverEvent) {
        return literal(string, new Style(color, null, null, null, null, null, clickEvent, hoverEvent, null, null));
    }

    public static ButtonWidget translatable(String key, @Nullable Style style, Object... args) {
        return new ButtonWidget(new TranslatableTextContent(key, null, args), style);
    }

    public static ButtonWidget translatable(String key, @Nullable Style style) {
        return translatable(key, style, TranslatableTextContent.EMPTY_ARGUMENTS);
    }

    public static ButtonWidget translatable(String key, @Nullable TextColor color, @Nullable ClickEvent clickEvent, @Nullable HoverEvent hoverEvent, Object... args) {
        return translatable(key, new Style(color, null, null, null, null, null, clickEvent, hoverEvent, null, null), args);
    }

    public static ButtonWidget translatable(String key, @Nullable TextColor color, @Nullable ClickEvent clickEvent, @Nullable HoverEvent hoverEvent) {
        return translatable(key, new Style(color, null, null, null, null, null, clickEvent, hoverEvent, null, null), TranslatableTextContent.EMPTY_ARGUMENTS);
    }

    public static class ButtonsWidget {
        public static MutableText of(MutableText... mutableTexts) {
            var content = mutableTexts[0];
            for (int i = 1; i < mutableTexts.length; i++) {
                content.append(Text.literal(" "));
                content.append(mutableTexts[i]);
            }
            return content;
        }
    }

}