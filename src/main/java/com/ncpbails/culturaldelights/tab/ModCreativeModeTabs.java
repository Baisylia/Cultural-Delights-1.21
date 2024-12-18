package com.ncpbails.culturaldelights.tab;

import com.ncpbails.culturaldelights.CulturalDelights;
import com.ncpbails.culturaldelights.block.ModBlocks;
import com.ncpbails.culturaldelights.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CulturalDelights.MOD_ID);

    public static final Supplier<CreativeModeTab> CULTURALDELIGHTS_TAB = CREATIVE_MODE_TAB.register("culturaldelights_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.CHICKEN_TACO.get()))
            .title(Component.translatable("creativetab.culturaldelights.culturaldelights_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.CUCUMBER_SEEDS);
                output.accept(ModItems.CORN_KERNELS);
                output.accept(ModItems.EGGPLANT_SEEDS);
                output.accept(ModItems.AVOCADO);
                output.accept(ModItems.CUT_AVOCADO);
                output.accept(ModItems.CUCUMBER);
                output.accept(ModItems.PICKLE);
                output.accept(ModItems.CUT_CUCUMBER);
                output.accept(ModItems.CUT_PICKLE);
                output.accept(ModItems.EGGPLANT);
                output.accept(ModItems.CUT_EGGPLANT);
                output.accept(ModItems.SMOKED_EGGPLANT);
                output.accept(ModItems.SMOKED_TOMATO);
                output.accept(ModItems.SMOKED_CUT_EGGPLANT);
                output.accept(ModItems.SMOKED_WHITE_EGGPLANT);
                output.accept(ModItems.WHITE_EGGPLANT);
                output.accept(ModItems.CORN_COB);
                output.accept(ModItems.SQUID);
                output.accept(ModItems.COOKED_SQUID);
                output.accept(ModItems.GLOW_SQUID);
                output.accept(ModItems.RAW_CALAMARI);
                output.accept(ModItems.COOKED_CALAMARI);
                output.accept(ModItems.POPCORN);
                output.accept(ModItems.CORN_DOUGH);
                output.accept(ModItems.TORTILLA);
                output.accept(ModItems.TORTILLA_CHIPS);
                output.accept(ModItems.ELOTE);
                output.accept(ModItems.EMPANADA);
                output.accept(ModItems.HEARTY_SALAD);
                output.accept(ModItems.BEEF_BURRITO);
                output.accept(ModItems.MUTTON_SANDWICH);
                output.accept(ModItems.FRIED_EGGPLANT_PASTA);
                output.accept(ModItems.EGGPLANT_BURGER);
                output.accept(ModItems.AVOCADO_TOAST);
                output.accept(ModItems.CREAMED_CORN);
                output.accept(ModItems.CHICKEN_TACO);
                output.accept(ModItems.SPICY_CURRY);
                output.accept(ModItems.PORK_WRAP);
                output.accept(ModItems.FISH_TACO);
                output.accept(ModItems.MIDORI_ROLL);
                output.accept(ModItems.MIDORI_ROLL_SLICE);
                output.accept(ModItems.EGG_ROLL);
                output.accept(ModItems.CHICKEN_ROLL);
                output.accept(ModItems.CHICKEN_ROLL_SLICE);
                output.accept(ModItems.PUFFERFISH_ROLL);
                output.accept(ModItems.TROPICAL_ROLL);
                output.accept(ModItems.RICE_BALL);
                output.accept(ModItems.CALAMARI_ROLL);
                output.accept(ModBlocks.WILD_CUCUMBERS);
                output.accept(ModBlocks.WILD_CORN);
                output.accept(ModBlocks.WILD_EGGPLANTS);
                output.accept(ModBlocks.AVOCADO_PIT);
                output.accept(ModBlocks.AVOCADO_SAPLING);
                output.accept(ModBlocks.AVOCADO_LOG);
                output.accept(ModBlocks.AVOCADO_WOOD);
                output.accept(ModBlocks.AVOCADO_LEAVES);
                output.accept(ModBlocks.FRUITING_AVOCADO_LEAVES);
                output.accept(ModBlocks.AVOCADO_CRATE);
                output.accept(ModBlocks.CUCUMBER_CRATE);
                output.accept(ModBlocks.PICKLE_CRATE);
                output.accept(ModBlocks.CORN_COB_CRATE);
                output.accept(ModBlocks.EGGPLANT_CRATE);
                output.accept(ModBlocks.WHITE_EGGPLANT_CRATE);
                output.accept(ModBlocks.EXOTIC_ROLL_MEDLEY);

            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
