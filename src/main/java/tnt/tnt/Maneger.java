package tnt.tnt;

import org.bukkit.entity.Player;

import java.awt.geom.Area;

public class Manager {

    private static Area area;

    public Manager() {
        area = new Area();
    }

    public static boolean isPlaying(Player player) {
        return area.getPlayers().contains(player.getUniqueId());
    }

    public static boolean isPlayerJoin() {
        return area.getStates() == lemmensthijmen.tntrun.enums.Gamestates.PLAYERJOIN;
    }

    public static Area getArea() {
        return area;
    }
}