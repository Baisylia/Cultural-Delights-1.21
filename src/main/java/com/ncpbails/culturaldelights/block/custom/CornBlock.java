package com.ncpbails.culturaldelights.block.custom;

import com.mojang.serialization.MapCodec;
import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;
import com.ncpbails.culturaldelights.block.ModBlocks;
import com.ncpbails.culturaldelights.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;

public class CornBlock extends BushBlock implements BonemealableBlock {
    public static final MapCodec<CornBlock> CODEC = simpleCodec(CornBlock::new);
    public static final IntegerProperty AGE;
    public static final BooleanProperty SUPPORTING;
    private static final VoxelShape[] SHAPE_BY_AGE;

    public CornBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)this.defaultBlockState().setValue(AGE, 0)).setValue(SUPPORTING, false));
    }

    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.tick(state, level, pos, random);
        if (level.isAreaLoaded(pos, 1)) {
            if (level.getRawBrightness(pos.above(), 0) >= 6) {
                int age = this.getAge(state);
                if (age <= this.getMaxAge()) {
                    float chance = 10.0F;
                    if (CommonHooks.canCropGrow(level, pos, state, random.nextInt((int)(25.0F / chance) + 1) == 0)) {
                        if (age == this.getMaxAge()) {
                            CornUpperBlock cornUpper = (CornUpperBlock) ModBlocks.CORN_UPPER.get();
                            if (cornUpper.defaultBlockState().canSurvive(level, pos.above()) && level.isEmptyBlock(pos.above())) {
                                level.setBlockAndUpdate(pos.above(), cornUpper.defaultBlockState());
                                CommonHooks.fireCropGrowPost(level, pos, state);
                            }
                        } else {
                            level.setBlock(pos, this.withAge(age + 1), 2);
                            CommonHooks.fireCropGrowPost(level, pos, state);
                        }
                    }
                }
            }

        }
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[(Integer)state.getValue(this.getAgeProperty())];
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    protected int getAge(BlockState state) {
        return (Integer)state.getValue(this.getAgeProperty());
    }

    public int getMaxAge() {
        return 3;
    }

    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        return new ItemStack((ItemLike) ModItems.CORN_KERNELS.get());
    }

    public BlockState withAge(int age) {
        return (BlockState)this.defaultBlockState().setValue(this.getAgeProperty(), age);
    }

    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(new Property[]{AGE, SUPPORTING});
    }

    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        BlockState state = super.updateShape(stateIn, facing, facingState, level, currentPos, facingPos);
        if (!state.isAir()) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
            if (facing == Direction.UP) {
                return (BlockState)state.setValue(SUPPORTING, this.isSupportingCornUpper(facingState));
            }
        }

        return state;
    }

    public boolean isSupportingCornUpper(BlockState topState) {
        return topState.getBlock() == ModBlocks.CORN_UPPER.get();
    }

    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        BlockState upperState = level.getBlockState(pos.above());
        if (upperState.getBlock() instanceof CornUpperBlock) {
            return !((CornUpperBlock)upperState.getBlock()).isMaxAge(upperState);
        } else {
            return true;
        }
    }

    public boolean isBonemealSuccess(Level level, RandomSource rand, BlockPos pos, BlockState state) {
        return true;
    }

    protected int getBonemealAgeIncrease(Level level) {
        return Mth.nextInt(level.random, 1, 4);
    }

    public void performBonemeal(ServerLevel level, RandomSource rand, BlockPos pos, BlockState state) {
        int ageGrowth = Math.min(this.getAge(state) + this.getBonemealAgeIncrease(level), 7);
        if (ageGrowth <= this.getMaxAge()) {
            level.setBlockAndUpdate(pos, (BlockState)state.setValue(AGE, ageGrowth));
        } else {
            BlockState top = level.getBlockState(pos.above());
            if (top.getBlock() == ModBlocks.CORN_UPPER.get()) {
                BonemealableBlock growable = (BonemealableBlock)level.getBlockState(pos.above()).getBlock();
                if (growable.isValidBonemealTarget(level, pos.above(), top)) {
                    growable.performBonemeal(level, level.random, pos.above(), top);
                }
            } else {
                CornUpperBlock cornUpper = (CornUpperBlock) ModBlocks.CORN_UPPER.get();
                int remainingGrowth = ageGrowth - this.getMaxAge() - 1;
                if (cornUpper.defaultBlockState().canSurvive(level, pos.above()) && level.isEmptyBlock(pos.above())) {
                    level.setBlockAndUpdate(pos, (BlockState)state.setValue(AGE, this.getMaxAge()));
                    level.setBlock(pos.above(), (BlockState)cornUpper.defaultBlockState().setValue(CornUpperBlock.CORN_AGE, remainingGrowth), 2);
                }
            }
        }

    }

    static {
        AGE = BlockStateProperties.AGE_3;
        SUPPORTING = BooleanProperty.create("supporting");
        SHAPE_BY_AGE = new VoxelShape[]{Block.box((double)3.0F, (double)0.0F, (double)3.0F, (double)13.0F, (double)8.0F, (double)13.0F), Block.box((double)3.0F, (double)0.0F, (double)3.0F, (double)13.0F, (double)10.0F, (double)13.0F), Block.box((double)2.0F, (double)0.0F, (double)2.0F, (double)14.0F, (double)12.0F, (double)14.0F), Block.box((double)1.0F, (double)0.0F, (double)1.0F, (double)15.0F, (double)16.0F, (double)15.0F)};
    }
}
