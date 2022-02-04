package tnt.tnt;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import tnt.tnt.Tnt;

import java.awt.geom.Area;
import java.util.UUID;

public class Game {

    private Area area;

    public Game(Area area) {
        this.area = area;
    }

    public void begin() {
        Tnt.getTnt().setToggle(true);
        for (UUID uuid : area.getPlayers()) {
            area.addPlayerGame(Bukkit.getPlayer(uuid));
        }
    }

    public void fix() {
        if (area.getPlayerGame().size() == 1) {
            Player player = Bukkit.getPlayer(area.getPlayerGame().get(0));
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(
                    ChatColor.GREEN + "You have Won"));
            area.sendMessage(ChatColor.GREEN + player.getDisplayName() + " has won!");
            area.reset();
        }
    }
}