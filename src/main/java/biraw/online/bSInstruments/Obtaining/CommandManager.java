package biraw.online.bSInstruments.Obtaining;

import biraw.online.bSInstruments.AllInstruments;
import biraw.online.bSInstruments.BSInstruments;
import biraw.online.bSInstruments.Instrument;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CommandManager implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (!(commandSender instanceof Player))
        {
            BSInstruments.getInstance().getLogger().warning("This command can only be used by players!");
            return true;
        }

        if (strings.length < 1) return false;

        if (strings[0].equals("all"))
        {
            AllInstruments.GiveAllInstruments((Player) commandSender);
            return true;
        }
        Instrument item = AllInstruments.GetInstrumentByName(strings[0]);
        if (item == null) return false;
        ((Player) commandSender).give(item.getItem());
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        List<String> list = AllInstruments.GetAllInstrumentNames();
        list.add("all");
        return list;
    }
}
