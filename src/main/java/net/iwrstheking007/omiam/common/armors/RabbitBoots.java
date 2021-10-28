package net.iwrstheking007.omiam.common.armors;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

public class RabbitBoots extends ArmorItem {
    public RabbitBoots(ArmorMaterial material, EquipmentSlot equipSlot, Properties properties) {
        super(material, equipSlot, properties);
    }

    @Override
    public void onArmorTick(ItemStack itemStack, Level world, Player player) {
        if(!world.isClientSide) {
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 5, 2, false, false, true));
        }
        player.fallDistance = 0F;
    }

}
