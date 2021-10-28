package net.iwrstheking007.omiam.common.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.item.Item.Properties;

public class SandiaAlloyArmorItem extends ArmorItem {
    public SandiaAlloyArmorItem(ArmorMaterial material, EquipmentSlot slotType, Properties properties) {
        super(material, slotType, properties);
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }
}
