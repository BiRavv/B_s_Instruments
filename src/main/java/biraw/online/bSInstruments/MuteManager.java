package biraw.online.bSInstruments;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;


public class MuteManager implements CommandExecutor, TabExecutor {
    private static List<Player> Muted = new ArrayList<>();
    public static List<Player> getMuted(){return Muted;}

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (!(commandSender instanceof Player plr)) return false;
        if (strings.length<1) {
            if (Muted.contains(plr)) plr.sendMessage("§cInstruments are MUTED for you.");
            else plr.sendMessage("§aInstruments are NOT MUTED for you.");
            return true;
        }
        if (strings[0].equals("true"))
        {
            if (!Muted.contains(plr)) Muted.add(plr);
            return true;
        } else if (strings[0].equals("false")) {
            Muted.remove(plr);
            return true;
        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        return List.of("true","false");
    }
}
