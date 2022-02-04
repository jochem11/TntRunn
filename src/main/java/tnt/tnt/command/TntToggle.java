package tnt.tnt.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tnt.tnt.Tnt;

public class TntToggle implements CommandExecutor {

    public TntToggle() {
        Tnt.getTnt().getCommand("tnt").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (Tnt.getTnt().getToggle()) {
                Tnt.getTnt().setToggle(false);
                player.sendMessage("tnt run uit");
            } else {
                Tnt.getTnt().setToggle(true);
                player.sendMessage("tnt run aan");
            }
        } else {
            Tnt.getTnt().getLogger().info("you are not a player!");
        }

        return false;
    }
}
