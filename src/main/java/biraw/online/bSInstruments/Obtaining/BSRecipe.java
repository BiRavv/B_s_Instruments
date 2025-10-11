package biraw.online.bSInstruments.Obtaining;

import biraw.online.bSInstruments.BSInstruments;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BSRecipe {
    public static List<NamespacedKey> AllRecipeKeys = new ArrayList<>();

    public BSRecipe(ItemStack resultItem,
                        Material i1_1,
                        Material i1_2,
                        Material i1_3,

                        Material i2_1,
                        Material i2_2,
                        Material i2_3,

                        Material i3_1,
                        Material i3_2,
                        Material i3_3
    )
    {

        // Define the recipe key
        NamespacedKey key = new NamespacedKey(BSInstruments.getInstance(),
                "Recipe_" + BSInstruments.getIntForRecipe());


        // Create the recipe
        org.bukkit.inventory.ShapedRecipe recipe = new org.bukkit.inventory.ShapedRecipe(key,resultItem);
        recipe.shape(
                (i1_1 != null ? "A" : " ")+
                        (i1_2 != null ? "B" : " ")+
                        (i1_3 != null ? "C" : " "),

                (i2_1 != null ? "D" : " ")+
                        (i2_2 != null ? "E" : " ")+
                        (i2_3 != null ? "F" : " "),

                (i3_1 != null ? "G" : " ")+
                        (i3_2 != null ? "H" : " ")+
                        (i3_3 != null ? "I" : " ")
        );

        if(i1_1!=null) recipe.setIngredient('A', i1_1);
        if(i1_2!=null) recipe.setIngredient('B', i1_2);
        if(i1_3!=null) recipe.setIngredient('C', i1_3);

        if(i2_1!=null) recipe.setIngredient('D', i2_1);
        if(i2_2!=null) recipe.setIngredient('E', i2_2);
        if(i2_3!=null) recipe.setIngredient('F', i2_3);

        if(i3_1!=null) recipe.setIngredient('G', i3_1);
        if(i3_2!=null) recipe.setIngredient('H', i3_2);
        if(i3_3!=null) recipe.setIngredient('I', i3_3);


        // Register the recipe
        Bukkit.addRecipe(recipe);
        AllRecipeKeys.add(key);
    }
}
