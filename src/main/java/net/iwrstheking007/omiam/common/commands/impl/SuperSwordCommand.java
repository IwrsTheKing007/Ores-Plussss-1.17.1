package net.iwrstheking007.omiam.common.commands.impl;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.iwrstheking007.omiam.common.commands.BaseCommand;
import net.iwrstheking007.omiam.setup.ModItems;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class SuperSwordCommand extends BaseCommand {
    public SuperSwordCommand(String name, int permissionLevel, boolean enabled) {
        super(name, permissionLevel, enabled);
    }

    @Override
    public LiteralArgumentBuilder<CommandSourceStack> setExecution() {
        return builder.then(Commands.argument("player", EntityArgument.players()).executes(source -> execute(source.getSource(), EntityArgument.getPlayer(source, "player"))));
    }

    private int execute(CommandSourceStack source, ServerPlayer player) {
        player.addItem(new ItemStack(ModItems.SUPER_SWORD.get()));
        return Command.SINGLE_SUCCESS;
    }
}
