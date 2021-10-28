package net.iwrstheking007.omiam.common.enchantments;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class PoisonEnchantment extends Enchantment {
    public PoisonEnchantment(Enchantment.Rarity rarity, EnchantmentCategory enchantType, EquipmentSlot... equipSlot) {
        super(rarity, enchantType, equipSlot);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public void doPostAttack(LivingEntity user, Entity target, int level) {
            for(int i = 0; i < level; i++) {
                ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.POISON, 100 * level, -1 + level));
            }
    }
}
