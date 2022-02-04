package lemmensthijmen.tntrun.GameLisnener;

import lemmensthijmen.tntrun.Manager;
import lemmensthijmen.tntrun.TntRun;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import tnt.tnt.Manager;
import tnt.tnt.Tnt;

public class DeathEvent implements Listener {

    public DeathEvent() {
        Tnt.getTntrun().getServer().getPluginManager().registerEvents(this, TntRun.getTntrun());
    }

    @EventHandler
    public void deathEvent(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();

        Manager.getArea().removePlayerGame(player);

        Manager.getArea().getGame().fix();
        Manager.getArea().sendMessage(player + "is dead");
    }
}