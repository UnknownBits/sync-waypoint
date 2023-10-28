package net.unknownbits.waypoints.entity;

import com.mojang.authlib.GameProfile;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3i;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Waypoint {
    private final UUID uuid;
    private final GameProfile creator;
    private final List<GameProfile> authors = new ArrayList<>();
    private final Identifier dimension;
    private final Text description;
    private Vec3i position;
    private Text id;

    public Waypoint(GameProfile creator, Vec3i pos, Identifier dim) {
        this.uuid = UUID.randomUUID();

        this.creator = creator;
        this.position = pos;
        this.dimension = dim;

        this.id = Text.empty();
        this.description = Text.empty();
    }

    public Waypoint(GameProfile creator, Vec3i pos, String dim) {
        this(creator, pos, new Identifier(dim));
    }

    public Waypoint(GameProfile creator, Vec3i pos, String dim, Text id) {
        this(creator, pos, dim);
        this.id = id;
    }

    public static Waypoint generateFromXaeroMap(String data, GameProfile creator) {
        String[] cache = data.split(":");
        int x = Integer.parseInt(cache[3]);
        int y = Integer.parseInt(cache[4]);
        int z = Integer.parseInt(cache[5]);
        String dim = cache[9].split("-")[1];
        return new Waypoint(creator, new Vec3i(x, y, z), dim, Text.of(cache[1]));
    }

    public static Waypoint generateFromJourneyMap(String data, GameProfile creator) {
        String[] cache = data.split(":");
        int x = Integer.parseInt(cache[1].split(",")[0]);
        int y = Integer.parseInt(cache[2].split(",")[0]);
        int z = Integer.parseInt(cache[3].split(",")[0]);
        String dim = cache[5];
        return new Waypoint(creator, new Vec3i(x, y, z), dim);
    }

    public void modify(GameProfile author, Vec3i position) {
        this.authors.add(author);
        this.position = position;
    }

    public UUID getUuid() {
        return uuid;
    }

    public GameProfile getCreator() {
        return creator;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Waypoint v && v.position == this.position;
    }

    public List<GameProfile> getAuthors() {
        return authors;
    }

    public Text getId() {
        return id;
    }

    public Text getDescription() {
        return description;
    }

    public Identifier getDimension() {
        return dimension;
    }
}
