package hideandsheek.hideandsheek;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

public class Gtimer {
    public static int i = 930;

    public static void gcountdown(){
        BukkitRunnable task = new BukkitRunnable() {
            @Override
            public void run() {
                if(i == 0){
                    Bukkit.getOnlinePlayers().forEach((player)->{
                        player.getLocation().getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH,0.2F,1);
                        player.sendTitle(net.md_5.bungee.api.ChatColor.DARK_PURPLE + "FINISH","VS最強のハンター", 40, 250, 40);
                    });
                    Timer.ss = false;
                    Bukkit.broadcastMessage("お疲れさまでした。");
                    cancel();
                    return;
                } else if( i < 5){
                    Bukkit.getOnlinePlayers().forEach((player)->{
                        Location loc = player.getLocation();
                        loc.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_HARP, 1, 10);
                    });
                } else if(i == 60){
                    Bukkit.getOnlinePlayers().forEach((player)->{
                        Location loc = player.getLocation();
                        loc.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_HARP, 1, 10);
                        player.sendMessage("残り1分");
                    });
                } else if(i == 180){
                    Bukkit.getOnlinePlayers().forEach((player)->{
                        Location loc = player.getLocation();
                        loc.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_HARP, 1, 10);
                        player.sendMessage("残り3分");
                    });
                } else if(i == 600){
                    Bukkit.getOnlinePlayers().forEach((player)->{
                        Location loc = player.getLocation();
                        loc.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_HARP, 1, 10);
                        player.sendMessage("残り10分");
                    });
                }
                Bukkit.getOnlinePlayers().forEach((player)->{
                    player.setLevel(i);
                });

                i--;
            }
        };
        task.runTaskTimer(HideAndSheek.getPlugin(), 8L,20L);
    }
}
