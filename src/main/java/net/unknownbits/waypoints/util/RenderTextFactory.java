package net.unknownbits.waypoints.util;

import net.minecraft.text.*;

public class RenderTextFactory {
    public static Text root = Text.Serializer.fromJson("""
            [
                    {"text":"§e§l【Waypoints】§r"},
                    {"text":"\\n"},
                    {"text":"§7/wp","clickEvent":{"action":"run_command","value":"/wp"}},
                    {"text":"快捷使用§7(单击下方按钮)"},
                    {"text":"\\n"},
                    {"text":"[+]","color":"green",
                        "clickEvent":{"action":"run_command","value":"/wp add"},
                        "hoverEvent":{"action":"show_text","value":{"text":"向共享中添加坐标点\\n§7/wp add"}}},
                    {"text":" "},
                    {"text":"[-]","color":"red",
                         "clickEvent":{"action":"run_command","value":"/wp remove"},
                         "hoverEvent":{"action":"show_text","value":{"text":"从共享中移除坐标点\\n§7/wp remove"}}},
                    {"text":" "},
                    {"text":"[?]","color":"aqua",
                         "clickEvent":{"action":"run_command","value":"/wp search"},
                         "hoverEvent":{"action":"show_text","value":{"text":"在共享中搜索坐标点\\n§7/wp search §f| §7§nXXX§r§7在哪"}}},
                    {"text":" "},
                    {"text":"[…]","color":"white",
                         "clickEvent":{"action":"run_command","value":"/wp list"},
                         "hoverEvent":{"action":"show_text","value":{"text":"列出所有共享中的坐标点\\n§7/wp list"}}},
                    {"text":" "},
                    {"text":"[H]","color":"yellow",
                         "clickEvent":{"action":"run_command","value":"/wp help"},
                         "hoverEvent":{"action":"show_text","value":{"text":"查看坐标点的更多帮助\\n§7/wp help"}}}        
                    ]
                """);
    public static MutableText ListButton = Utils.make(() -> {
        var style = Style.EMPTY
                .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.translatable("wp.list")))
                .withClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/wp list"));
        return Text.literal("[…]").setStyle(style);
    });
    public static MutableText AddButton = Utils.make(() -> {
        var style = Style.EMPTY
                .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.translatable("wp.add")))
                .withClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/wp add"));
        return Text.literal("[+]").setStyle(style);
    });
    public String SPACE = "{\"text\":\" \"},";
    public String LINEFEED = "{\"text\":\"/n\"},";
}
