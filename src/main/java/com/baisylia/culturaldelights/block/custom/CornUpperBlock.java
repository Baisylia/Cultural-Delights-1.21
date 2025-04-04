package com.baisylia.culturaldelights.block.custom;


import com.baisylia.culturaldelights.block.ModBlocks;
import com.baisylia.culturaldelights.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CornUpperBlock extends CropBlock {
    public static final IntegerProperty CORN_AGE;
    private static final VoxelShape[] SHAPE_BY_AGE;

    public CornUpperBlock(Properties properties) {
        super(properties);
    }

    public IntegerProperty getAgeProperty() {
        return CORN_AGE;
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[(Integer)state.getValue(this.getAgeProperty())];
    }

    public int getMaxAge() {
        return 3;
    }

    protected ItemLike getBaseSeedId() {
        return (ItemLike) ModItems.CORN_KERNELS.get();
    }

    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(new Property[]{CORN_AGE});
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return state.getBlock() == ModBlocks.CORN.get();
    }

    protected int getBonemealAgeIncrease(Level worldIn) {
        return super.getBonemealAgeIncrease(worldIn) / 3;
    }

    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        return (worldIn.getRawBrightness(pos, 0) >= 8 || worldIn.canSeeSky(pos)) && worldIn.getBlockState(pos.below()).getBlock() == ModBlocks.CORN.get();
    }

    static {
        CORN_AGE = BlockStateProperties.AGE_3;
        SHAPE_BY_AGE = new VoxelShape[]{Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D),
                                        Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D),
                                        Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D),
                                        Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D)};
    }
}
