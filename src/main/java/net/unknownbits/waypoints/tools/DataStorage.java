package net.unknownbits.waypoints.tools;

import net.unknownbits.waypoints.entity.Waypoint;

import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    static final DataStorage INSTANCE = new DataStorage();
    public List<Waypoint> waypointList;

    private DataStorage(){
        this.waypointList = new ArrayList<>();
    }

    public static DataStorage getInstance()
    {
        return INSTANCE;
    }

    public static void addWaypointData(Waypoint wp) {
        for (Waypoint waypoint : DataStorage.getInstance().waypointList) {
            if (waypoint == wp) return;
        }
        DataStorage.getInstance().waypointList.add(wp);
    }
}
