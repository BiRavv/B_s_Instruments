package biraw.online.bSInstruments;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Note;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.CustomModelDataComponent;
import org.bukkit.metadata.Metadatable;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Instrument implements Listener {
    private static List<Note.Tone> NOTES = List.of(Note.Tone.A, Note.Tone.B, Note.Tone.C, Note.Tone.D, Note.Tone.E, Note.Tone.F,Note.Tone.G);
    private static final List<String> NOTECOLORS = List.of(
            "§cA", // A - Red
            "§6B", // B - Gold/Orange
            "§eC", // C - Yellow
            "§aD", // D - Green
            "§bE", // E - Aqua
            "§9F", // F - Blue
            "§dG"  // G - Light Purple
    );

    final String name;
    final String sname;
    final int octave;
    final org.bukkit.Instrument instrument;
    final Material item;

    public Instrument(String name, org.bukkit.Instrument instrument, int octave, Material item){
        this.octave = octave;
        this.instrument = instrument;
        this.name = name;
        this.item = item;
        this.sname = name.replace(' ', '-').toLowerCase();

        Bukkit.getServer().getPluginManager().registerEvents(this,BSInstruments.getInstance());
    }

    // get the item of the instrument
    public ItemStack getItem(){
        ItemStack give = new ItemStack(item);
        ItemMeta meta = give.getItemMeta();
        meta.setDisplayName("§d"+name);
        if (octave > 0) meta.setLore(List.of("§a♪ High note ♪","§8B's Instruments"));
        else meta.setLore(List.of("§a♫ Low note ♫","§8B's Instruments"));
        meta.getPersistentDataContainer().set(
                BSInstruments.NSKEY,
                PersistentDataType.STRING,
                "instrument_"+sname+"_"+octave
        );
            switch (sname.toLowerCase()) {
                case "guitar":
                    meta.setCustomModelData(7);
                    break;
                case "piano":
                    meta.setCustomModelData(16);
                    break;
                case "bass-drum":
                    meta.setCustomModelData(1);
                    break;
                case "snare-drum":
                    meta.setCustomModelData(2);
                    break;
                case "sticks":
                    meta.setCustomModelData(3);
                    break;
                case "bass-guitar":
                    meta.setCustomModelData(4);
                    break;
                case "flute":
                    meta.setCustomModelData(5);
                    break;
                case "bell":
                    meta.setCustomModelData(6);
                    break;
                case "chime":
                    meta.setCustomModelData(8);
                    break;
                case "xylophone":
                    meta.setCustomModelData(9);
                    break;
                case "iron-xylophone":
                    meta.setCustomModelData(10);
                    break;
                case "cow-bell":
                    meta.setCustomModelData(11);
                    break;
                case "didgeridoo":
                    meta.setCustomModelData(12);
                    break;
                case "bit":
                    meta.setCustomModelData(13);
                    break;
                case "banjo":
                    meta.setCustomModelData(14);
                    break;
                case "pling":
                    meta.setCustomModelData(15);
                    break;
                default:
                    meta.setCustomModelData(999); // fallback or unknown
                    break;
            }
        give.setItemMeta(meta);
        return give;
    }

    @EventHandler
    private void playerPlayEvent(PlayerInteractEvent event){
        ItemMeta meta = event.getPlayer().getInventory().getItemInOffHand().getItemMeta();
        if (meta == null) return;
        if (!meta.getPersistentDataContainer().has(BSInstruments.NSKEY)) return;
        if (!Objects.equals(meta.getPersistentDataContainer().get(
                BSInstruments.NSKEY,
                PersistentDataType.STRING),
                "instrument_"+sname+"_"+octave
        )) return; // If the player has the item with the specific metadata only then...

        Player plr = event.getPlayer();
        float pitch = plr.getPitch();

        pitch+=90; pitch /= 180; pitch *=NOTES.size()-1; // convert player pitch to a note

        Note note;
        if (plr.isSneaking()) {
            note = Note.flat(octave, NOTES.get(Math.round(pitch)));
            plr.sendActionBar(NOTECOLORS.get(Math.round(pitch)) + "♭");
        } else if (event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR) {
            note = Note.natural(octave, NOTES.get(Math.round(pitch)));
            plr.sendActionBar(NOTECOLORS.get(Math.round(pitch)));
        } else {
            note = Note.sharp(octave, NOTES.get(Math.round(pitch)));
            plr.sendActionBar(NOTECOLORS.get(Math.round(pitch)) + "#");
        }

        for (Player listener : Bukkit.getOnlinePlayers()) {
            if (!MuteManager.getMuted().contains(listener)) {
                listener.playNote(plr.getLocation(), instrument, note);
            }
        }

        event.setCancelled(true);

    }
}
