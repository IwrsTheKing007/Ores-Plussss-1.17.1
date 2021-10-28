package net.iwrstheking007.omiam.common.items.dragonfruit;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.item.Item.Properties;

public class EnchantedGoldenDragonFruit extends Item {
    public EnchantedGoldenDragonFruit(Properties properties) {
        super(properties);
    }

    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
