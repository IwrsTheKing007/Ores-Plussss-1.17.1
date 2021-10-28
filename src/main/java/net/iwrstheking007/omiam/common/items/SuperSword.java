package net.iwrstheking007.omiam.common.items;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;

public class SuperSword extends SwordItem {
    private final double range;
    public SuperSword(Tier tier, int damage, float attackSpeed, double thunderRange, Properties properties) {
        super(tier, damage, attackSpeed, properties);
        this.range = thunderRange;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return false;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        BlockHitResult ray = rayTrace(world, user, ClipContext.Fluid.NONE);
        BlockPos lookPos = ray.getBlockPos().relative(ray.getDirection());
        if (user.isShiftKeyDown()) {
            PrimedTnt tntEntity = EntityType.TNT.create(world);
            assert tntEntity != null;
            tntEntity.setPos(lookPos.getX(), lookPos.getY(), lookPos.getZ());
            tntEntity.setFuse(0);
            world.addFreshEntity(tntEntity);
        }
        else {
            LightningBolt lightningBoltEntity = EntityType.LIGHTNING_BOLT.create(world);
            assert lightningBoltEntity != null;
            lightningBoltEntity.setPos(lookPos.getX(), lookPos.getY(), lookPos.getZ());
            world.addFreshEntity(lightningBoltEntity);
        }
        return super.use(world, user, hand);
    }

    protected BlockHitResult rayTrace(Level world, Player player, ClipContext.Fluid fluidMode) {

        float f = player.xRotO;
        float f1 = player.yRotO;
        Vec3 vector3d = player.getEyePosition(1.0F);
        float f2 = Mth.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = Mth.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -Mth.cos(-f * ((float)Math.PI / 180F));
        float f5 = Mth.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        Vec3 vector3d1 = vector3d.add((double)f6 * this.range, (double)f5 * this.range, (double)f7 * this.range);
        return world.clip(new ClipContext(vector3d, vector3d1, ClipContext.Block.OUTLINE, fluidMode, player));
    }
}
