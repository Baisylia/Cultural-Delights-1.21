package com.ncpbails.culturaldelights.world;

import com.ncpbails.culturaldelights.CulturalDelights;
import com.ncpbails.culturaldelights.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> AVOCADO_PLACED_KEY = registerKey("avocado_placed");
    public static final ResourceKey<PlacedFeature> CORN_PLACED_KEY = registerKey("corn_placed");
    public static final ResourceKey<PlacedFeature> EGGPLANT_PLACED_KEY = registerKey("eggplant_placed");
    public static final ResourceKey<PlacedFeature> CUCUMBER_PLACED_KEY = registerKey("cucumber_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, AVOCADO_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.AVOCADO_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1f, 1),
                        ModBlocks.AVOCADO_SAPLING.get()));

        register(context, CORN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CORN_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

        register(context, EGGPLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EGGPLANT_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

        register(context, CUCUMBER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CUCUMBER_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(CulturalDelights.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
