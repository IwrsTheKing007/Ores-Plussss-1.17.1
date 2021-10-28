package net.iwrstheking007.omiam.common.blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.core.BlockPos;

public class AnthraciteOreEXPDrop extends OreBlock {
    public AnthraciteOreEXPDrop(BlockBehaviour.Properties properties) {
        super(properties);
    }



    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.level.LevelReader reader, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? 9 : 0;
    }
}