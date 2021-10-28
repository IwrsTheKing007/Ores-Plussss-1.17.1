package net.iwrstheking007.omiam.common.commands.impl;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.iwrstheking007.omiam.common.commands.BaseCommand;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;

public class MaxCommand extends BaseCommand {
    public MaxCommand(String name, int permissionLevel, boolean enabled) {
        super(name, permissionLevel, enabled);
    }

    @Override
    public LiteralArgumentBuilder<CommandSourceStack> setExecution() {
        return builder.then(Commands.argument("player", EntityArgument.players()).executes(source -> execute(source.getSource(), EntityArgument.getPlayer(source, "player"), InteractionHand.MAIN_HAND)));
    }

    private int execute(CommandSourceStack source, ServerPlayer player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        int max = itemStack.getMaxStackSize();
        itemStack.setCount(max);

        return Command.SINGLE_SUCCESS;
    }
}
