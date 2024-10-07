package top.unknownbits.sync_waypoint.util;

import net.minecraft.text.*;
import top.unknownbits.sync_waypoint.widgets.ButtonWidget;
///TODO 使用更安全的方法
public class RenderTextFactory {
    public final static Text LINEFEED = Text.of(new String(new byte[]{10}));
    public final static MutableText AddButton = ButtonWidget.literal("[+]",
            TextColor.parse("green").result().get(),
            new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/waypoints add"),
            new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.translatable("sync-waypoints.add", LINEFEED)));
    public final static MutableText RemoveButton = ButtonWidget.literal("[-]",
            TextColor.parse("red").result().get(),
            new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/waypoints remove"),
            new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.translatable("sync-waypoints.remove", LINEFEED)));
    public final static MutableText SearchButton = ButtonWidget.literal("[?]",
            TextColor.parse("aqua").result().get(),
            new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/waypoints search"),
            new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.translatable("sync-waypoints.search", LINEFEED)));
    public final static MutableText ListButton = ButtonWidget.literal("[…]",
            TextColor.parse("white").result().get(),
            new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/waypoints list"),
            new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.translatable("sync-waypoints.list", LINEFEED)));
    public final static MutableText HelpButton = ButtonWidget.literal("[H]",
            TextColor.parse("yellow").result().get(),
            new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/waypoints help"),
            new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.translatable("sync-waypoints.help", LINEFEED)));
    public final static MutableText FunctionButtons = ButtonWidget.ButtonsWidget.of(AddButton, RemoveButton, SearchButton, ListButton, HelpButton);

}