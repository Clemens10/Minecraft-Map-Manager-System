package de.clemens.map.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;

@AllArgsConstructor
@Getter
public class SerializedLocation {


    private String world;

    private double coordinateX;
    private double coordinateY;
    private double coordinateZ;
    private float coordinateYaw;
    private float coordinatePitch;

    /**
     * Returns a location from the serialized object.
     *
     * @return the new location object with the values from this serializer
     */
    public Location toLocation() {
        return new Location(Bukkit.getWorld(world), coordinateX, coordinateY, coordinateZ, coordinateYaw, coordinatePitch);
    }

}
