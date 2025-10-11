package biraw.online.bSInstruments.Obtaining;

import biraw.online.bSInstruments.AllInstruments;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.Recipe;

public class RegisterRecipes implements Listener {

    @EventHandler
    private void Descovery(CraftItemEvent event){
        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getType() != Material.NOTE_BLOCK) return;
        for (NamespacedKey n : BSRecipe.AllRecipeKeys){
            if (!event.getWhoClicked().hasDiscoveredRecipe(n))
                event.getWhoClicked().discoverRecipe(n);
        }
    }

    public RegisterRecipes(){
        new BSRecipe(AllInstruments.GetInstrumentByName("guitar-0").getItem(),
                null,Material.STRING,Material.STICK,
                Material.STRING,Material.STICK,Material.STRING,
                Material.NOTE_BLOCK,Material.STRING,null);
        new BSRecipe(AllInstruments.GetInstrumentByName("guitar-1").getItem(),
                null,Material.STRING,Material.STICK,
                null,Material.STICK,Material.STRING,
                Material.NOTE_BLOCK,null,null);

        new BSRecipe(AllInstruments.GetInstrumentByName("bass-drum-0").getItem(),
                Material.LEATHER,Material.LEATHER,Material.LEATHER,
                Material.STICK,null,Material.STICK,
                Material.STICK,Material.STICK,Material.STICK);
        new BSRecipe(AllInstruments.GetInstrumentByName("bass-drum-1").getItem(),
                Material.RABBIT_HIDE,Material.RABBIT_HIDE,Material.RABBIT_HIDE,
                Material.STICK,null,Material.STICK,
                Material.STICK,Material.STICK,Material.STICK);

        new BSRecipe(AllInstruments.GetInstrumentByName("snare-drum-0").getItem(),
                Material.LEATHER,Material.LEATHER,Material.LEATHER,
                Material.STICK,null,Material.STICK,
                null,null,null);
        new BSRecipe(AllInstruments.GetInstrumentByName("snare-drum-1").getItem(),
                Material.RABBIT_HIDE,Material.RABBIT_HIDE,Material.RABBIT_HIDE,
                Material.STICK,null,Material.STICK,
                null,null,null);

        new BSRecipe(AllInstruments.GetInstrumentByName("sticks-1").getItem(),
                Material.STICK,null,Material.STICK,
                Material.STICK,null,Material.STICK,
                Material.STICK,null,Material.STICK);
        new BSRecipe(AllInstruments.GetInstrumentByName("sticks-0").getItem(),
                Material.BONE,null,Material.BONE,
                Material.STICK,null,Material.STICK,
                Material.STICK,null,Material.STICK);

        new BSRecipe(AllInstruments.GetInstrumentByName("bass-guitar-0").getItem(),
                null,Material.IRON_NUGGET,Material.STICK,
                Material.IRON_NUGGET,Material.STICK,Material.IRON_NUGGET,
                Material.NOTE_BLOCK,Material.IRON_NUGGET,null);
        new BSRecipe(AllInstruments.GetInstrumentByName("bass-guitar-1").getItem(),
                null,Material.IRON_NUGGET,Material.STICK,
                null,Material.STICK,Material.IRON_NUGGET,
                Material.NOTE_BLOCK,null,null);

        new BSRecipe(AllInstruments.GetInstrumentByName("flute-0").getItem(),
                null,Material.IRON_INGOT,null,
                null,Material.COPPER_INGOT,null,
                null,null,null);
        new BSRecipe(AllInstruments.GetInstrumentByName("flute-1").getItem(),
                null,Material.IRON_NUGGET,null,
                null,Material.COPPER_INGOT,null,
                null,null,null);

        new BSRecipe(AllInstruments.GetInstrumentByName("bell-0").getItem(),
                null,Material.BELL,null,
                null,Material.BLAZE_ROD,null,
                null,null,null);
        new BSRecipe(AllInstruments.GetInstrumentByName("bell-1").getItem(),
                null,Material.BELL,null,
                null,Material.STICK,null,
                null,null,null);

        new BSRecipe(AllInstruments.GetInstrumentByName("piano-0").getItem(),
                null,null,null,
                null,null,null,
                Material.QUARTZ_SLAB,Material.QUARTZ_SLAB,Material.QUARTZ_SLAB);
        new BSRecipe(AllInstruments.GetInstrumentByName("piano-1").getItem(),
                null,null,null,
                null,null,null,
                Material.SMOOTH_QUARTZ_SLAB,Material.SMOOTH_QUARTZ_SLAB,Material.SMOOTH_QUARTZ_SLAB);

        new BSRecipe(AllInstruments.GetInstrumentByName("chime-1").getItem(),
                Material.STICK,Material.STICK,Material.STICK,
                Material.POINTED_DRIPSTONE,Material.POINTED_DRIPSTONE,Material.POINTED_DRIPSTONE,
                null,null,null);
        new BSRecipe(AllInstruments.GetInstrumentByName("chime-0").getItem(),
                Material.STICK,Material.STICK,Material.STICK,
                Material.POINTED_DRIPSTONE,Material.POINTED_DRIPSTONE,Material.POINTED_DRIPSTONE,
                Material.POINTED_DRIPSTONE,Material.POINTED_DRIPSTONE,Material.POINTED_DRIPSTONE);

        new BSRecipe(AllInstruments.GetInstrumentByName("xylophone-1").getItem(),
                null,null,null,
                Material.BONE,Material.BONE,Material.BONE,
                Material.STICK,null,Material.STICK);
        new BSRecipe(AllInstruments.GetInstrumentByName("xylophone-0").getItem(),
                null,null,null,
                Material.BONE_BLOCK,Material.BONE_BLOCK,Material.BONE_BLOCK,
                Material.STICK,null,Material.STICK);

        new BSRecipe(AllInstruments.GetInstrumentByName("iron-xylophone-0").getItem(),
                null,null,null,
                Material.IRON_INGOT,Material.IRON_INGOT,Material.IRON_INGOT,
                Material.STICK,null,Material.STICK);
        new BSRecipe(AllInstruments.GetInstrumentByName("iron-xylophone-1").getItem(),
                null,null,null,
                Material.IRON_NUGGET,Material.IRON_NUGGET,Material.IRON_NUGGET,
                Material.STICK,null,Material.STICK);

        new BSRecipe(AllInstruments.GetInstrumentByName("cow-bell-1").getItem(),
                null,Material.GOLD_INGOT,null,
                null,Material.GOLD_NUGGET,null,
                null,null,null);
        new BSRecipe(AllInstruments.GetInstrumentByName("cow-bell-0").getItem(),
                null,Material.IRON_INGOT,null,
                null,Material.IRON_NUGGET,null,
                null,null,null);

        new BSRecipe(AllInstruments.GetInstrumentByName("didgeridoo-0").getItem(),
                null,Material.MANGROVE_ROOTS,null,
                null,Material.MANGROVE_ROOTS,null,
                null,Material.MANGROVE_ROOTS,null);
        new BSRecipe(AllInstruments.GetInstrumentByName("didgeridoo-1").getItem(),
                null,Material.MANGROVE_ROOTS,null,
                null,Material.MANGROVE_ROOTS,null,
                null,null,null);

        new BSRecipe(AllInstruments.GetInstrumentByName("bit-0").getItem(),
                null,null,null,
                Material.STONE_PRESSURE_PLATE,Material.STONE_PRESSURE_PLATE,Material.STONE_PRESSURE_PLATE,
                null,Material.CALIBRATED_SCULK_SENSOR,null);
        new BSRecipe(AllInstruments.GetInstrumentByName("bit-1").getItem(),
                null,null,null,
                Material.STONE_BUTTON,Material.STONE_BUTTON,Material.STONE_BUTTON,
                null,Material.CALIBRATED_SCULK_SENSOR,null);

        new BSRecipe(AllInstruments.GetInstrumentByName("banjo-0").getItem(),
                null,Material.STRING,Material.STICK,
                null,Material.STICK,Material.STRING,
                Material.PUMPKIN,null,null);
        new BSRecipe(AllInstruments.GetInstrumentByName("banjo-1").getItem(),
                null,Material.STRING,Material.STICK,
                null,Material.STICK,Material.STRING,
                Material.CARVED_PUMPKIN,null,null);

        new BSRecipe(AllInstruments.GetInstrumentByName("pling-0").getItem(),
                null,Material.AMETHYST_SHARD,null,
                null,Material.REDSTONE_BLOCK,null,
                null,null,null);
        new BSRecipe(AllInstruments.GetInstrumentByName("pling-1").getItem(),
                null,Material.AMETHYST_SHARD,null,
                null,Material.REDSTONE,null,
                null,null,null);
    }
}
