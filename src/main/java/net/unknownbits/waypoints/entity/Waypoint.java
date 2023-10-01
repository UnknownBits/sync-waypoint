package net.unknownbits.waypoints.entity;

import com.mojang.authlib.GameProfile;
import net.minecraft.util.math.Vec3i;

public class Waypoint extends Vec3i {
    private GameProfile gameProfile;

    public Waypoint(int x, int y, int z, GameProfile gameProfile) {
        super(x, y, z);
        this.gameProfile = gameProfile;
    }

    public Waypoint(Vec3i pos, GameProfile gameProfile) {
        this(pos.getX(), pos.getY(), pos.getZ(), gameProfile);
    }

    public GameProfile getGameProfile() {
        return gameProfile;
    }

    public void setGameProfile(GameProfile gameProfile) {
        this.gameProfile = gameProfile;
    }
}
