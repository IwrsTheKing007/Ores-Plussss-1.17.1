package net.iwrstheking007.omiam.setup;

import net.iwrstheking007.omiam.common.enchantments.PoisonEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ModEnchants {

    public static final RegistryObject<Enchantment> POISON_ENCHANT = Registrations.ENCHANTMENTS.register("poison", () -> new PoisonEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

    static void register() {}
}
