package top.unknownbits.sync_waypoint.entity;

import com.mojang.authlib.GameProfile;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3i;
import top.unknownbits.sync_waypoint.util.DataStorage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Waypoint {

    /**
     * 全局唯一识别码
     */
    private final UUID uuid;

    /**
     * 创建者
     */
    private final GameProfile creator;

    /**
     * 编辑者
     */
    private final List<GameProfile> authors = new ArrayList<>();

    /**
     * 维度信息
     */
    private final Identifier dimension;

    /**
     * 介绍
     */
    private final Text description;

    /**
     * 坐标点
     */
    private Vec3i position;

    /**
     * 名称
     */
    private Text name;

    public Waypoint(GameProfile creator, Vec3i pos, Identifier dim) {
        this.uuid = UUID.randomUUID();

        this.creator = creator;
        this.position = pos;
        this.dimension = dim;

        this.name = Text.empty();
        this.description = Text.empty();
    }

    public Waypoint(GameProfile creator, Vec3i pos, String dim) {
        this(creator, pos, Identifier.of(dim));
    }

    public Waypoint(GameProfile creator, Vec3i pos, String dim, Text id) {
        this(creator, pos, dim);
        this.name = id;
    }

    private static Waypoint generateFromXaeroMap(String data, GameProfile creator) {
        String[] cache = data.split(":");
        int x = Integer.parseInt(cache[3]);
        int y = Integer.parseInt(cache[4]);
        int z = Integer.parseInt(cache[5]);
        String dim = cache[9].split("-")[1];
        return new Waypoint(creator, new Vec3i(x, y, z), dim, Text.of(cache[1]));
    }

    private static Waypoint generateFromJourneyMap(String data, GameProfile creator) {
        String[] cache = data.split(":");
        int x = Integer.parseInt(cache[1].split(",")[0]);
        int y = Integer.parseInt(cache[2].split(",")[0]);
        int z = Integer.parseInt(cache[3].split(",")[0]);
        String dim = cache[5];
        return new Waypoint(creator, new Vec3i(x, y, z), dim);
    }

    public static Waypoint of(String data, GameProfile creator){
        Waypoint wp = null;
        if (data.startsWith("xaero-waypoint:")) wp = Waypoint.generateFromXaeroMap(data, creator);
        else if (data.startsWith("[x:")) wp = Waypoint.generateFromJourneyMap(data, creator);
        return wp;
    }

    public void modify(GameProfile author, Vec3i position) {
        for (GameProfile gameProfile : authors)
            if (gameProfile == author)
                return;
        this.authors.add(author);
        this.position = position;
    }

    public GameProfile getCreator() {
        return creator;
    }

    @Override
    public boolean equals(Object obj) { return obj instanceof Waypoint v && v.position == this.position; }

    @Override
    public String toString() {
        return "uuid:" + this.uuid +
                ",name:" + this.name.getString() +
                ",creator:" + this.creator.getName() +
                ",description:" + this.description +
                ",position:" + this.position.toShortString() +
                ",dimension:" + this.dimension.toShortTranslationKey();
    }
    public List<GameProfile> getAuthors() {
        return authors;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Text getName() {
        return name;
    }

    public Text getDescription() {
        return description;
    }

    public Identifier getDimension() {
        return dimension;
    }
}