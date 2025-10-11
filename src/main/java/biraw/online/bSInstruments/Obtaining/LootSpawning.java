package biraw.online.bSInstruments.Obtaining;

import biraw.online.bSInstruments.AllInstruments;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.LootGenerateEvent;

public class LootSpawning implements Listener {
    @EventHandler
    private void OnLootSpawning(LootGenerateEvent event){
        if (!(event.getInventoryHolder() instanceof Chest)) return;
        if (Math.random() > 0.2) return;

        event.getLoot().add(AllInstruments.GetRandomInstrument().getItem());
    }
}
