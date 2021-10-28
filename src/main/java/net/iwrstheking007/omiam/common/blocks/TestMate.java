package net.iwrstheking007.omiam.common.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class TestMate extends Block {
    public TestMate(Properties properties) {
        super(properties);
    }

    @Override
    public void fallOn(Level world, BlockState state, BlockPos blockPos, Entity entity, float number) {
        ItemStack itemStack = new ItemStack(Items.NETHERITE_BLOCK);

        ItemEntity itementity = new ItemEntity(world, blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), itemStack);
        itementity.setDefaultPickUpDelay();
        world.addFreshEntity(itementity);
    }
}