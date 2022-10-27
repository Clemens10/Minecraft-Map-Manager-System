package de.clemens.map;

import de.clemens.saves.serializer.LocationSerializer;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

import java.util.List;

public class Map {

    private final String name;
    @Getter
    private final String description;
    @Getter
    private final String author;

    private final List<Location> spawnLocations;


    // Constructor for initializing a new map
    public Map(String name, Location defaultLocation, String description, String author) {

        this.name = name;
        this.spawnLocations = List.of(defaultLocation);
        this.description = description;
        this.author = author;

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
