package hideandsheek.hideandsheek;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.scheduler.BukkitRunnable;

public class LightningSchedule {

    public static int count = 30;

    public static void lightning(){
        BukkitRunnable task = new BukkitRunnable() {
            @Override
            public void run() {
                if(count == 0){
                    Bukkit.getOnlinePlayers().forEach((player)->{
                        player.getLocation().getWorld().playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN,0.5F,1);
                        player.sendTitle(net.md_5.bungee.api.ChatColor.DARK_PURPLE + "GAME START","VS最強のハンター", 40, 250, 40);
                        Gtimer.gcountdown();
                        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                        String command = "worldborder set 16 900";
                        Bukkit.dispatchCommand(console, command);
                    });
                    cancel();
                    return;
                } else if( count < 5){
                    Bukkit.getOnlinePlayers().forEach((player)->{
                        Location loc = player.getLocation();
                        loc.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_HARP, 1, 10);
                    });
                } else if(count == 60){
                    Bukkit.getOnlinePlayers().forEach((player)->{
                        Location loc = player.getLocation();
                        loc.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_HARP, 1, 10);
                        player.sendMessage("残り1分");
                    });
                }
                Bukkit.getOnlinePlayers().forEach((player)->{
                    player.setLevel(count);
                });

                count--;
            }
        };
        task.runTaskTimer(HideAndSheek.getPlugin(), 8L,20L);
    }
}
