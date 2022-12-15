package de.clemens.demo.impl;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import de.clemens.*;

import java.io.File;
import java.util.ArrayList;

public class WorldsInit {

    @Getter
    private ArrayList<File> worlds;

    public void initWorlds(Player player) {
        worlds = new ArrayList<>();

        for (var file : new File("api/worlds").listFiles()) {
            if (file.isDirectory()) {
                var setup = new MapSetup(player, file.getName(), new Location(Bukkit.getWorld(file.getName()), 0, 0, 0), "description", "author");
            }
        }
    }
}
