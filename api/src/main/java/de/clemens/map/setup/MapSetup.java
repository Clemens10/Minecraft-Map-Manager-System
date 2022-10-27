package de.clemens.map.setup;

import de.clemens.config.MapConfig;
import de.clemens.events.SetupFinishEvent;
import de.clemens.events.SetupStartEvent;
import de.clemens.exception.SetupFailedException;
import de.clemens.map.Map;
import de.clemens.map.util.SerializedLocation;
import de.clemens.saves.JsonConfig;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MapSetup {

    private final Player player;
    private final String mapName;
    private final ArrayList<Location> spawnLocations;
    @Getter
    private JsonConfig config;

    @Getter
    private final Map map;

    public MapSetup(Player player, String mapName, Location defaultSpawn, String description, String author) {

        this.player = player;
        this.mapName = mapName;
        this.spawnLocations = new ArrayList<>();
        this.map = new Map(mapName, defaultSpawn, description, author);


        //Ads the default spawn location
        this.spawnLocations.add(defaultSpawn);
    }

    public void start(String world) {

        player.teleport(new Location(Bukkit.getWorld(world), 0, 0, 0));

        ArrayList<SerializedLocation> serializedLocations = new ArrayList<>();

        //Converts the locations to serialized locations

        for(int i = 0; i < spawnLocations.size(); i++) {
            Location current = spawnLocations.get(i);
            serializedLocations.add(new SerializedLocation(current.getWorld().getName(), current.getX(), current.getY(), current.getZ(), current.getYaw(), current.getPitch()));
        }


        config = new JsonConfig(new File("frames/config", "core-database-module.json"), c ->
                c.set("core-database-module", new MapConfig(mapName, getMap().getAuthor(), getMap().getDescription(), serializedLocations))).
                get("core-database-module", (Type) MapConfig.class);

        Bukkit.getPluginManager().callEvent(new SetupStartEvent(player, this));
    }

    public boolean save() throws SetupFailedException {
        if (this.spawnLocations.size() < 2) {
            throw new SetupFailedException("Not enough spawn locations. (min: 2, current: " + this.spawnLocations.size() + ")");
        }
        return true;
    }

    public void finish() throws SetupFailedException {
        if (save()) {
            Bukkit.getPluginManager().callEvent(new SetupFinishEvent(player, this));
        }
    }

    public void addSpawnLocation(Location location) {
        this.spawnLocations.add(location);
    }

    public List<Location> getSpawnLocations() {
        return this.spawnLocations;
    }

    public String getMapName() {
        return this.mapName;
    }

    public Player getPlayer() {
        return this.player;
    }
}
