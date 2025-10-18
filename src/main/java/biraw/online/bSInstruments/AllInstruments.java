package biraw.online.bSInstruments;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;

public class AllInstruments {
    public static final List<Instrument> AllInstruments = List.of(
            new Instrument("Piano", org.bukkit.Instrument.PIANO, 1, Material.WOODEN_SWORD),
            new Instrument("Piano", org.bukkit.Instrument.PIANO, 0, Material.WOODEN_SWORD),

            new Instrument("Bass Drum", org.bukkit.Instrument.BASS_DRUM, 1, Material.WOODEN_SWORD),
            new Instrument("Bass Drum", org.bukkit.Instrument.BASS_DRUM, 0, Material.WOODEN_SWORD),

            new Instrument("Snare Drum", org.bukkit.Instrument.SNARE_DRUM, 1, Material.WOODEN_SWORD),
            new Instrument("Snare Drum", org.bukkit.Instrument.SNARE_DRUM, 0, Material.WOODEN_SWORD),

            new Instrument("Sticks", org.bukkit.Instrument.STICKS, 1, Material.WOODEN_SWORD),
            new Instrument("Sticks", org.bukkit.Instrument.STICKS, 0, Material.WOODEN_SWORD),

            new Instrument("Bass Guitar", org.bukkit.Instrument.BASS_GUITAR, 1, Material.WOODEN_SWORD),
            new Instrument("Bass Guitar", org.bukkit.Instrument.BASS_GUITAR, 0, Material.WOODEN_SWORD),

            new Instrument("Flute", org.bukkit.Instrument.FLUTE, 1, Material.WOODEN_SWORD),
            new Instrument("Flute", org.bukkit.Instrument.FLUTE, 0, Material.WOODEN_SWORD),

            new Instrument("Bell", org.bukkit.Instrument.BELL, 1, Material.WOODEN_SWORD),
            new Instrument("Bell", org.bukkit.Instrument.BELL, 0, Material.WOODEN_SWORD),

            new Instrument("Guitar", org.bukkit.Instrument.GUITAR, 1, Material.WOODEN_SWORD),
            new Instrument("Guitar", org.bukkit.Instrument.GUITAR, 0, Material.WOODEN_SWORD),

            new Instrument("Chime", org.bukkit.Instrument.CHIME, 1, Material.WOODEN_SWORD),
            new Instrument("Chime", org.bukkit.Instrument.CHIME, 0, Material.WOODEN_SWORD),

            new Instrument("Xylophone", org.bukkit.Instrument.XYLOPHONE, 1, Material.WOODEN_SWORD),
            new Instrument("Xylophone", org.bukkit.Instrument.XYLOPHONE, 0, Material.WOODEN_SWORD),

            new Instrument("Iron Xylophone", org.bukkit.Instrument.IRON_XYLOPHONE, 1, Material.WOODEN_SWORD),
            new Instrument("Iron Xylophone", org.bukkit.Instrument.IRON_XYLOPHONE, 0, Material.WOODEN_SWORD),

            new Instrument("Cow Bell", org.bukkit.Instrument.COW_BELL, 1, Material.WOODEN_SWORD),
            new Instrument("Cow Bell", org.bukkit.Instrument.COW_BELL, 0, Material.WOODEN_SWORD),

            new Instrument("Didgeridoo", org.bukkit.Instrument.DIDGERIDOO, 1, Material.WOODEN_SWORD),
            new Instrument("Didgeridoo", org.bukkit.Instrument.DIDGERIDOO, 0, Material.WOODEN_SWORD),

            new Instrument("Bit", org.bukkit.Instrument.BIT, 1, Material.WOODEN_SWORD),
            new Instrument("Bit", org.bukkit.Instrument.BIT, 0, Material.WOODEN_SWORD),

            new Instrument("Banjo", org.bukkit.Instrument.BANJO, 1, Material.WOODEN_SWORD),
            new Instrument("Banjo", org.bukkit.Instrument.BANJO, 0, Material.WOODEN_SWORD),

            new Instrument("Pling", org.bukkit.Instrument.PLING, 1, Material.WOODEN_SWORD),
            new Instrument("Pling", org.bukkit.Instrument.PLING, 0, Material.WOODEN_SWORD)
    );

    public static Instrument GetInstrumentByName(String name){
        for (Instrument i : AllInstruments)
        {
            if ((i.sname+"-"+i.octave).equalsIgnoreCase(name)) return i;
        }
        return null;
    }

    public static List<String> GetAllInstrumentNames(){
        List<String> ret = new ArrayList<>();
        for (Instrument i : AllInstruments){
            ret.add(i.sname+"-"+i.octave);
        }
        return ret;
    }

    public static void GiveAllInstruments(Player player){
        for (Instrument i : AllInstruments){
            player.give(i.getItem());
        }
    }

    public static Instrument GetRandomInstrument(){
        return AllInstruments.get((int)(Math.random() * AllInstruments.size()));
    }
}
