package de.clemens.map;

import com.google.common.collect.Lists;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private final String name;
    private final List<Location> spawnLocations;


    // Constructor for initializing a new map
    public Map(String name, Location defaultLocation) {
        this.name = name;
        this.spawnLocations = List.of(defaultLocation);
    }

    //Getter for the name of the map
    public String getName() {
        return this.name;
    }

    //Getter for the spawn locations of the map
    public List<Location> getSpawnLocations() {
        return spawnLocations;
    }

    //Getter of a specific spawn location
    public Location getSpawnLocation(int index) {
        return this.spawnLocations.get(index);
    }

    //Setter of a spawn location
    public void addSpawnLocation(Location location) {
        this.spawnLocations.add(location);
    }
}
