package net.unknownbits.waypoints.util;

import net.minecraft.text.Text;

public class RenderTextFactory {
    public static Text root = Text.Serializer.fromJson("""
            [
                    {"text":"§e§l【Waypoints】§r"},
                    {"text":"\\n"},
                    {"text":"§7#wp","clickEvent":{"action":"run_command","value":"/waypoints"}},
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
    public String SPACE = "{\"text\":\" \"},";
    public String LINEFEED = "{\"text\":\"/n\"},";
}
