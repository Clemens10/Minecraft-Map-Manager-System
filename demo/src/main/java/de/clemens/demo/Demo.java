package de.clemens.demo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Demo extends JavaPlugin {

    @Override
    public void onEnable() {

        sendInfo();
        createWorldDirectory();
    }

    //Creates world directory for the custom worlds
    private void createWorldDirectory() {
        var file = new File("api/worlds");
        if(!file.exists()) {
            Bukkit.getLogger().info("Creating worlds directory...");
            file.mkdirs();
        }
    }

    //System Info
    private void sendInfo() {

        Bukkit.getLogger().info("--------------------");
        Bukkit.getLogger().info("you are using the demo plugin for the MMMS by IchBinBekifft");
        Bukkit.getLogger().info("the plugin is currently in development");
        Bukkit.getLogger().info("Errors may occur, so please report them on my github page ");
        Bukkit.getLogger().info("My GitHub page -> github.com/Clemens10");
        Bukkit.getLogger().info("--------------------");
    }

}
