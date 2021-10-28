package net.iwrstheking007.omiam.common.blocks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.core.BlockPos;

public class DragonFruitOreEXPDrop extends OreBlock {
    public DragonFruitOreEXPDrop(Properties p_i48357_1_) {
        super(p_i48357_1_);
    }

    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.level.LevelReader reader, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? 13 : 0;
    }
}
