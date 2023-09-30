package net.unknownbits.waypoints;

import com.mojang.authlib.GameProfile;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

import java.util.UUID;

public class Waypoint extends Vec3i {
    public Waypoint (int x, int y, int z, GameProfile gameProfile){
        super(x, y, z);
        this.gameProfile = gameProfile;
    }
    public Waypoint (Vec3i pos, GameProfile gameProfile) {
        this(pos.getX(), pos.getY(), pos.getZ(),gameProfile);
    }
    private GameProfile gameProfile;

    public GameProfile getGameProfile() {
        return gameProfile;
    }

    public void setGameProfile(GameProfile gameProfile) {
        this.gameProfile = gameProfile;
    }
}
