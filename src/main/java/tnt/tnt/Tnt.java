package tnt.tnt;

import org.bukkit.plugin.java.JavaPlugin;
import tnt.tnt.command.Reset;
import tnt.tnt.command.TntToggle;

public final class Tnt extends JavaPlugin {

    private static Tnt tnt;
    private boolean toggle;

    @Override
    public void onEnable() {
        tnt = this;
        new TntToggle();
        new TntEvent();
        new Reset();
    }




    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Tnt getTnt() {
        return tnt;
    }

    public boolean getToggle() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }


}

