package de.clemens.config;

import de.clemens.map.util.SerializedLocation;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
public class MapConfig {

    private String name;
    private String author;
    private String description;

    private ArrayList<SerializedLocation> spawnLocations;

}
