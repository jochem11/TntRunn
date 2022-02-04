package tnt.tnt;

import lemmensthijmen.tntrun.Util.Replace;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import tnt.tnt.command.Replace;

import java.util.ArrayList;
import java.util.UUID;

public class Area {

    private ArrayList<UUID> players;
    private ArrayList<UUID> playerGame;
    private lemmensthijmen.tntrun.enums.Gamestates states;
    private Game game;
    private Countdown countdown;
    private int timer;

    public Area() {
        players = new ArrayList<>();
        playerGame = new ArrayList<>();
        states = lemmensthijmen.tntrun.enums.Gamestates.PLAYERJOIN;
        game = new Game(this);
        countdown = new Countdown(this);
        timer = 0;
    }

//    start the game

    public void start() {
        game.begin();
    }

//    reset the whole game

    public void reset() {
        for (UUID uuid : players) {
            Bukkit.getPlayer(uuid).teleport(new Location(Bukkit.getWorld("world"), 27 ,6 ,25)); // hier moet je loc zetten
            Bukkit.getPlayer(uuid).setGameMode(GameMode.ADVENTURE);
        }

        players.clear();
        states = lemmensthijmen.tntrun.enums.Gamestates.PLAYERJOIN;
        countdown = new Countdown(this);
        game = new Game(this);
        playerGame.clear();
        Tnt.getTnt().setToggle(false);
        timer = 0;
    }

//    sends a message

    public void sendMessage(String message) {
        for (UUID uuid : players) {
            Bukkit.getPlayer(uuid).sendMessage(message);
        }
    }

//    adds a player to the list

    public void addPlayerGame(Player player) {
        playerGame.add(player.getUniqueId());
    }

    public void removePlayerGame(Player player) {
        playerGame.remove(player.getUniqueId());
        player.setGameMode(GameMode.SPECTATOR);
        sendMessage(playerGame + "");
    }

    public void addPlayers(Player player) {
        players.add(player.getUniqueId());

        player.teleport(new Location(Bukkit.getWorld("world"), 809 , 120 ,-74)); // hier moet je loc zetten

        if (timer == 0) {
            Replace.replaceAll();
        }

        if (players.size() >= 2) {
            countdown.begin();
        }
        timer++;
    }

//    removed player

    public void removePlayers(Player player) {
        players.remove(player.getUniqueId());

        player.teleport(new Location(Bukkit.getWorld("world"), 27, 6,25)); // hier moet je loc zetten
    }

    public ArrayList<UUID> getPlayers() {
        return players;
    }

    public lemmensthijmen.tntrun.enums.Gamestates getStates() {
        return states;
    }

    public void setStates(lemmensthijmen.tntrun.enums.Gamestates states) {
        this.states = states;
    }

    public ArrayList<UUID> getPlayerGame() {
        return playerGame;
    }

    public Game getGame() {
        return game;
    }
}