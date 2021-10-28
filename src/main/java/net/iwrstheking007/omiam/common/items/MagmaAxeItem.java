package net.iwrstheking007.omiam.common.items;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MagmaAxeItem extends AxeItem {
    public MagmaAxeItem(Tier tier, int damage, float attackSpeed, Properties properties) {
        super(tier, damage, attackSpeed, properties);
    }

    @Override
    public void onCraftedBy(ItemStack itemStack, Level world, Player player) {
        itemStack.enchant(Enchantments.FIRE_ASPECT, 5);
    }
}