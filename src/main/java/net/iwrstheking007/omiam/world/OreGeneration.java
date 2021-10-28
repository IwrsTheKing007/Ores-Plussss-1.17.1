package net.iwrstheking007.omiam.world;

import net.iwrstheking007.omiam.setup.ModBlocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGeneration {

    public static void generateOres(final BiomeLoadingEvent event) {
        if(!(event.getCategory().equals(Biome.BiomeCategory.NETHER) || event.getCategory().equals(Biome.BiomeCategory.THEEND))) {
            generateOre(event.getGeneration(), OreConfiguration.Predicates.NATURAL_STONE, ModBlocks.PLATINUM_ORE.get().defaultBlockState(), 6, VerticalAnchor.absolute(0), VerticalAnchor.absolute(64), 10);
        }

        if(!(event.getCategory().equals(Biome.BiomeCategory.NETHER) || event.getCategory().equals(Biome.BiomeCategory.THEEND))) {
            generateOre(event.getGeneration(), OreConfiguration.Predicates.NATURAL_STONE, ModBlocks.DRAGON_FRUIT_ORE.get().defaultBlockState(), 9, VerticalAnchor.absolute(0), VerticalAnchor.absolute(256), 50);
        }

        if(!(event.getCategory().equals(Biome.BiomeCategory.NETHER) || event.getCategory().equals(Biome.BiomeCategory.THEEND))) {
            generateOre(event.getGeneration(), OreConfiguration.Predicates.NATURAL_STONE, ModBlocks.ANTHRACITE_ORE.get().defaultBlockState(), 22, VerticalAnchor.absolute(0), VerticalAnchor.absolute(110), 13);
        }
        if(!(event.getCategory().equals(Biome.BiomeCategory.NETHER) || event.getCategory().equals(Biome.BiomeCategory.THEEND))) {
            generateOre(event.getGeneration(), OreConfiguration.Predicates.NATURAL_STONE, ModBlocks.MJOLNIR_ORE.get().defaultBlockState(), 2, VerticalAnchor.absolute(0), VerticalAnchor.absolute(30), 2);
        }
        if(!(event.getCategory().equals(Biome.BiomeCategory.NETHER) || event.getCategory().equals(Biome.BiomeCategory.THEEND))) {
            generateOre(event.getGeneration(), OreConfiguration.Predicates.NATURAL_STONE, ModBlocks.STEEL_ORE.get().defaultBlockState(), 6, VerticalAnchor.absolute(0), VerticalAnchor.absolute(64), 12);
        }
        if(event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            generateOre(event.getGeneration(), OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_MAGMA_ORE.get().defaultBlockState(), 6, VerticalAnchor.absolute(0), VerticalAnchor.absolute(64), 12);
        }
    }

    private static void generateOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state, int veinSize, VerticalAnchor minHeight, VerticalAnchor maxHeight, int amount){
        settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Feature.ORE.configured(new OreConfiguration(fillerType, state, veinSize)).decorated(FeatureDecorator.RANGE.configured(new RangeDecoratorConfiguration(UniformHeight.of(minHeight, maxHeight)))).squared().countRandom(amount));

    }
}
