package com.ncpbails.culturaldelights.block;

import com.ncpbails.culturaldelights.CulturalDelights;
import com.ncpbails.culturaldelights.block.custom.*;
import com.ncpbails.culturaldelights.item.ModItems;
import com.ncpbails.culturaldelights.world.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.util.function.Supplier;

import static net.minecraft.world.item.Items.registerBlock;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CulturalDelights.MOD_ID);

    public static final DeferredBlock<Block> WILD_CUCUMBERS = registerBlock("wild_cucumbers",
            () -> new WildCropBlock(MobEffects.FIRE_RESISTANCE, 6,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));

    public static final DeferredBlock<Block> WILD_CORN = registerBlock("wild_corn",
            () -> new WildCropBlock(MobEffects.HUNGER, 6,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));

    public static final DeferredBlock<Block> WILD_EGGPLANTS = registerBlock("wild_eggplants",
            () -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));


    public static final DeferredBlock<Block> AVOCADO_PIT = registerBlock("avocado_pit",
            () -> new AvocadoPitBlock(ModTreeGrowers.AVOCADO, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<Block> AVOCADO_SAPLING = registerBlock("avocado_sapling",
            () -> new SaplingBlock(ModTreeGrowers.AVOCADO, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<Block> AVOCADO_LOG = registerBlock("avocado_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LOG)));

    public static final DeferredBlock<Block> AVOCADO_WOOD = registerBlock("avocado_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD)));

    public static final DeferredBlock<Block> AVOCADO_LEAVES = registerBlock("avocado_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            });

    public static final DeferredBlock<Block> FRUITING_AVOCADO_LEAVES = registerBlock("fruiting_avocado_leaves",
            () -> new FruitingLeaves(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES)) {
                @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) { return 30; }
            });


    public static final DeferredBlock<Block> CUCUMBERS = BLOCKS.register("cucumbers",
            () -> new CucumbersBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion()));

    public static final DeferredBlock<Block> EGGPLANTS = BLOCKS.register("eggplants",
            () -> new EggplantsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion()));

    public static final DeferredBlock<Block> CORN = BLOCKS.register("corn",
            () -> new CornBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion()));

    public static final DeferredBlock<Block> CORN_UPPER = BLOCKS.register("corn_upper",
            () -> new CornUpperBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion()));


    public static final DeferredBlock<Block> AVOCADO_CRATE = registerBlock("avocado_crate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(vectorwing.farmersdelight.common.registry.ModBlocks.CARROT_CRATE.get()))
            );

    public static final DeferredBlock<Block> CUCUMBER_CRATE = registerBlock("cucumber_crate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(vectorwing.farmersdelight.common.registry.ModBlocks.CARROT_CRATE.get()))
            );

    public static final DeferredBlock<Block> PICKLE_CRATE = registerBlock("pickle_crate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(vectorwing.farmersdelight.common.registry.ModBlocks.CARROT_CRATE.get()))
            );

    public static final DeferredBlock<Block> CORN_COB_CRATE = registerBlock("corn_cob_crate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(vectorwing.farmersdelight.common.registry.ModBlocks.CARROT_CRATE.get()))
            );

    public static final DeferredBlock<Block> EGGPLANT_CRATE = registerBlock("eggplant_crate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(vectorwing.farmersdelight.common.registry.ModBlocks.CARROT_CRATE.get()))
            );

    public static final DeferredBlock<Block> WHITE_EGGPLANT_CRATE = registerBlock("white_eggplant_crate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(vectorwing.farmersdelight.common.registry.ModBlocks.CARROT_CRATE.get()))
            );


    public static final DeferredBlock<Block> EXOTIC_ROLL_MEDLEY = registerBlock("exotic_roll_medley",
            () -> new ExoticRollMedleyBlock(BlockBehaviour.Properties.ofFullCopy(vectorwing.farmersdelight.common.registry.ModBlocks.RICE_ROLL_MEDLEY_BLOCK.get()).noOcclusion()));




    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
