package net.unknownbits.waypoints.util;

import net.minecraft.text.*;
import net.unknownbits.waypoints.widgets.ButtonWidget;

public class RenderTextFactory {
    public final static Text LINEFEED = Text.of(new String(new byte[]{10}));
    public final static MutableText AddButton = ButtonWidget.literal("[+]",
            TextColor.parse("green"),
            new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/waypoints add"),
            new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.translatable("waypoints.add", LINEFEED)));
    public final static MutableText RemoveButton = ButtonWidget.literal("[-]",
            TextColor.parse("red"),
            new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/waypoints remove"),
            new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.translatable("waypoints.remove", LINEFEED)));
    public final static MutableText SearchButton = ButtonWidget.literal("[?]",
            TextColor.parse("aqua"),
            new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/waypoints search"),
            new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.translatable("waypoints.search", LINEFEED)));
    public final static MutableText ListButton = ButtonWidget.literal("[…]",
            TextColor.parse("white"),
            new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/waypoints list"),
            new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.translatable("waypoints.list", LINEFEED)));
    public final static MutableText HelpButton = ButtonWidget.literal("[H]",
            TextColor.parse("yellow"),
            new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/waypoints help"),
            new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.translatable("waypoints.help", LINEFEED)));
    public final static MutableText FunctionButtons = ButtonWidget.ButtonsWidget.of(AddButton, RemoveButton, SearchButton, ListButton, HelpButton);

}
