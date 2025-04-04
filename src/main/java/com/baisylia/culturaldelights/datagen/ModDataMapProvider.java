package com.baisylia.culturaldelights.datagen;

import com.baisylia.culturaldelights.block.ModBlocks;
import com.baisylia.culturaldelights.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModBlocks.AVOCADO_SAPLING.getId(), new FurnaceFuel(50), false)
                .add(ModBlocks.AVOCADO_LOG.getId(), new FurnaceFuel(50), false)
                .add(ModBlocks.AVOCADO_WOOD.getId(), new FurnaceFuel(50), false);

        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(ModItems.CUCUMBER_SEEDS.getId(), new Compostable(0.25f), false)
                .add(ModItems.EGGPLANT_SEEDS.getId(), new Compostable(0.25f), false)
                .add(ModItems.CORN_KERNELS.getId(), new Compostable(0.25f), false)
                .add(ModBlocks.AVOCADO_PIT.getId(), new Compostable(0.25f), false)
                .add(ModItems.CUCUMBER.getId(), new Compostable(0.45f), false)
                .add(ModItems.EGGPLANT.getId(), new Compostable(0.45f), false)
                .add(ModItems.CORN_COB.getId(), new Compostable(0.45f), false)
                .add(ModItems.PICKLE.getId(), new Compostable(0.45f), false)
                .add(ModItems.AVOCADO_TOAST.getId(), new Compostable(0.45f), false)
                .add(ModBlocks.AVOCADO_SAPLING.getId(), new Compostable(0.45f), false);
    }
}