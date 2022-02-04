package tnt.tnt;

import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown extends BukkitRunnable {

    private Area area;
    private int seconds;

    public Countdown(Area area) {
        this.area = area;
        seconds = 30;
    }

    public void begin() {
        area.setStates(lemmensthijmen.tntrun.enums.Gamestates.COUNTDOWN);
        this.runTaskTimer(Tnt.getTnt(), 0, 20);
    }

    @Override
    public void run() {
        if (seconds == 0) {
            cancel();
            Manager.getArea().start();
            return;
        }

        if (seconds % 30 == 0 || seconds <= 10) {
            if (seconds == 1) {
                Manager.getArea().sendMessage(ChatColor.GREEN + "game is starting");
            } else {
                Manager.getArea().sendMessage(ChatColor.GREEN + "game is starting in " + seconds);
            }
        }

        if (Manager.getArea().getPlayers().size() < 1) {
            cancel();
            Manager.getArea().setStates(lemmensthijmen.tntrun.enums.Gamestates.PLAYERJOIN);
            Manager.getArea().sendMessage(ChatColor.RED + "game canceld!");
            return;
        }

        seconds--;
    }
}