package tnt.tnt.command;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import tnt.tnt.Manager;
import tnt.tnt.Tnt;

public class Reset implements CommandExecutor {

    public Reset() {
        Tnt.getTnt().getCommand("reset").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Manager.getArea().reset();
        return false;
    }
}