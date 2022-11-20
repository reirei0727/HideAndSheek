package hideandsheek.hideandsheek;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HideAndSheek extends JavaPlugin {
    public static HideAndSheek plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new EventListner(),this);

        getCommand("azgame").setExecutor(new command());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

    public static HideAndSheek getPlugin(){
        return plugin;
    }
}
