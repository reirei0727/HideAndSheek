package hideandsheek.hideandsheek;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.scoreboard.DisplaySlot;
import org.jetbrains.annotations.NotNull;

public class command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args[0].equalsIgnoreCase("start")){
            Timer.countdown();
            Bukkit.broadcastMessage("ゲーム開始まで残り3分");
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            String scommand = "worldborder set 300";
            Bukkit.dispatchCommand(console, scommand);
            Timer.count = 600;
            Gtimer.i = 930;
        } else if(args[0].equalsIgnoreCase("0")){
            Timer.count =1;
            Gtimer.i = 1;
        }
       return true;
    }
}
