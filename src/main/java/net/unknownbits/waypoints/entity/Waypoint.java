package net.unknownbits.waypoints.entity;

import com.mojang.authlib.GameProfile;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3i;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Waypoint {
    private final UUID uuid;
    private final GameProfile creator;
    private final List<GameProfile> authors = new ArrayList<>();
    private Vec3i position;
    private Text id;
    private Text description;

    public Waypoint(GameProfile creator, Vec3i pos) {
        this.uuid = UUID.randomUUID();

        this.creator = creator;
        this.position = pos;

        this.id = Text.empty();
        this.description = Text.empty();
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

    @Override
    public String toString() {
        return "waypoint::" + uuid + "::" + id + "::" + description + "::" + position.toShortString();
    }

    public List<GameProfile> getAuthors() {
        return authors;
    }

    public Text getId() {
        return id;
    }

    public void setId(Text id) {
        this.id = id;
    }

    public Text getDescription() {
        return description;
    }

    public void setDescription(Text description) {
        this.description = description;
    }
}
