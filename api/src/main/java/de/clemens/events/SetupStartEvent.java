package de.clemens.events;

import de.clemens.map.setup.MapSetup;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SetupStartEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final MapSetup setup;

    public SetupStartEvent(Player player, MapSetup setup) {
        this.player = player;
        this.setup = setup;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Player getPlayer() {
        return player;
    }

    public MapSetup getSetup() {
        return this.setup;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}
