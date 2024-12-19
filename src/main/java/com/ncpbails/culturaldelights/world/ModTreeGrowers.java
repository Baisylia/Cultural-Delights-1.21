package com.ncpbails.culturaldelights.world;

import com.ncpbails.culturaldelights.CulturalDelights;
import com.ncpbails.culturaldelights.world.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower AVOCADO = new TreeGrower(CulturalDelights.MOD_ID + ":avocado",
            Optional.empty(), Optional.of(ModConfiguredFeatures.AVOCADO_KEY), Optional.empty());
}
