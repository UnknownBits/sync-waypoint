package top.unknownbits.sync_waypoint.util;

import java.util.function.Supplier;

public class Utils {
    public static <T> T make(Supplier<T> factory) {
        return factory.get();
    }
}
