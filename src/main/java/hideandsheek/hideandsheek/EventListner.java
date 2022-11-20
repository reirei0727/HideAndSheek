package hideandsheek.hideandsheek;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class EventListner implements Listener {
    public static int lcount = 30;

    @EventHandler
    public void onClickEvent(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(!p.getName().equals("Yuta0919"))return;
        if(p.getInventory().getItemInMainHand().getType() == Material.GOLD_INGOT){
            p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount()-1);
            p.chat("/execute at @a[distance=..8,name=!" + p.getName() + "] run summon minecraft:lightning_bolt ~ ~ ~");

            BukkitRunnable task = new BukkitRunnable() {
                public void run() {
                    if(lcount == 0){
                        p.sendMessage("ライトニング使用可能");
                        p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT,1));
                        lcount = 30;
                        cancel();
                        return;
                    } else if( lcount < 5){
                        Location loc = p.getLocation();
                        loc.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_HARP, 1, 10);
                    } else if( lcount == 10){
                        p.sendMessage("残り10秒");
                    } else if( lcount == 20){
                        p.sendMessage("残り20秒");
                    }
                    lcount--;
                }
            };
            task.runTaskTimer(HideAndSheek.getPlugin(), 0,20L);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (p.getName().equals("Yuta0919")){
            p.chat("/team join red " + p.getName());
            p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(60);
        } else {
            //Aqua.blue.addEntry(p.getName());
            p.chat("/team join blue " + p.getName());
            p.chat("/chat team");
        }
    }

    @EventHandler
    public void onDeathEvent(PlayerDeathEvent e){
        if(Timer.ss == false)return;
        Player p = e.getPlayer();
        Location l = p.getLocation();
        l.getWorld().strikeLightningEffect(l);
        p.setGameMode(GameMode.SPECTATOR);
        p.sendMessage(ChatColor.AQUA + "観戦モードに切り替わります");
    }

}
