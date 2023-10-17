package net.unknownbits.waypoints.entity;

import com.mojang.authlib.GameProfile;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3i;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Waypoint {
    private final UUID uuid;
    private final GameProfile creator;
    private final Instant createtimestamp;
    private final List<GameProfile> authors = new ArrayList<>();
    private Vec3i position;
    private Instant lastmodifytimestamp;
    private Text id;
    private Text description;

    public Waypoint(GameProfile creator, Vec3i position, Instant cts) {
        this.id = Text.empty();
        this.description = Text.empty();
        this.creator = creator;
        this.position = position;
        this.createtimestamp = cts;
        this.lastmodifytimestamp = cts;
        this.uuid = UUID.randomUUID();
    }

    public Waypoint(GameProfile creator, int x, int y, int z, Instant cts) {
        this(creator, new Vec3i(x, y, z), cts);
    }

    public UUID getUuid() {
        return uuid;
    }

    public GameProfile getCreator() {
        return creator;
    }

    public List<GameProfile> getAuthors() {
        return authors;
    }

    public Vec3i getPosition() {
        return position;
    }

    public Instant getCreatetimestamp() {
        return createtimestamp;
    }

    public Instant getLastmodifytimestamp() {
        return lastmodifytimestamp;
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

    public void modify(GameProfile author, Vec3i position, Instant lmts) {
        this.authors.add(author);
        this.position = position;
        this.lastmodifytimestamp = lmts;
    }
}
