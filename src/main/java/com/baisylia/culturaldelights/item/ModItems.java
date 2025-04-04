package com.baisylia.culturaldelights.item;

import com.baisylia.culturaldelights.CulturalDelights;
import com.baisylia.culturaldelights.block.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CulturalDelights.MOD_ID);

    //Items                                                                  item id

    public static final DeferredItem<Item> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CUCUMBERS.get(),
                    new Item.Properties()));

    public static final DeferredItem<Item> CORN_KERNELS = ITEMS.register("corn_kernels",
            () -> new ItemNameBlockItem(ModBlocks.CORN.get(),
                    new Item.Properties()));

    public static final DeferredItem<Item> EGGPLANT_SEEDS = ITEMS.register("eggplant_seeds",
            () -> new ItemNameBlockItem(ModBlocks.EGGPLANTS.get(),
                    new Item.Properties()));


    //Ingredients
    public static final DeferredItem<Item> AVOCADO = ITEMS.register("avocado",
            () -> new Item(new Item.Properties().food(ModFoods.AVOCADO)));

    public static final DeferredItem<Item> CUT_AVOCADO = ITEMS.register("cut_avocado",
            () -> new Item(new Item.Properties().food(ModFoods.CUT_AVOCADO)));

    public static final DeferredItem<Item> CUCUMBER = ITEMS.register("cucumber",
            () -> new Item(new Item.Properties().food(ModFoods.CUCUMBER)));

    public static final DeferredItem<Item> PICKLE = ITEMS.register("pickle",
            () -> new Item(new Item.Properties().food(ModFoods.PICKLE)));

    public static final DeferredItem<Item> CUT_CUCUMBER = ITEMS.register("cut_cucumber",
            () -> new Item(new Item.Properties().food(ModFoods.CUT_CUCUMBER)));

    public static final DeferredItem<Item> CUT_PICKLE = ITEMS.register("cut_pickle",
            () -> new Item(new Item.Properties().food(ModFoods.CUT_PICKLE)));

    public static final DeferredItem<Item> EGGPLANT = ITEMS.register("eggplant",
            () -> new Item(new Item.Properties().food(ModFoods.EGGPLANT)));

    public static final DeferredItem<Item> CUT_EGGPLANT = ITEMS.register("cut_eggplant",
            () -> new Item(new Item.Properties().food(ModFoods.CUT_EGGPLANT)));

    public static final DeferredItem<Item> SMOKED_EGGPLANT = ITEMS.register("smoked_eggplant",
            () -> new Item(new Item.Properties().food(ModFoods.SMOKED_EGGPLANT)));

    public static final DeferredItem<Item> SMOKED_TOMATO = ITEMS.register("smoked_tomato",
            () -> new Item(new Item.Properties().food(ModFoods.SMOKED_TOMATO)));

    public static final DeferredItem<Item> SMOKED_CUT_EGGPLANT = ITEMS.register("smoked_cut_eggplant",
            () -> new Item(new Item.Properties().food(ModFoods.SMOKED_CUT_EGGPLANT)));

    public static final DeferredItem<Item> SMOKED_WHITE_EGGPLANT = ITEMS.register("smoked_white_eggplant",
            () -> new Item(new Item.Properties().food(ModFoods.SMOKED_WHITE_EGGPLANT)));
    public static final DeferredItem<Item> WHITE_EGGPLANT = ITEMS.register("white_eggplant",
            () -> new Item(new Item.Properties().food(ModFoods.WHITE_EGGPLANT)));
    public static final DeferredItem<Item> CORN_COB = ITEMS.register("corn_cob",
            () -> new Item(new Item.Properties().food(ModFoods.CORN_COB)));
    //public static final DeferredItem<Item> GINGER = ITEMS.register("ginger",
    //        () -> new Item(new Item.Properties().food(ModFoods.GINGER)));

    public static final DeferredItem<Item> SQUID = ITEMS.register("squid",
            () -> new Item(new Item.Properties().food(ModFoods.SQUID)));

    public static final DeferredItem<Item> COOKED_SQUID = ITEMS.register("cooked_squid",
            () -> new Item(new Item.Properties().food(ModFoods.COOKED_SQUID)));

    public static final DeferredItem<Item> GLOW_SQUID = ITEMS.register("glow_squid",
            () -> new Item(new Item.Properties().food(ModFoods.GLOW_SQUID)));

    public static final DeferredItem<Item> RAW_CALAMARI = ITEMS.register("raw_calamari",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_CALAMARI)));

    public static final DeferredItem<Item> COOKED_CALAMARI = ITEMS.register("cooked_calamari",
            () -> new Item(new Item.Properties().food(ModFoods.COOKED_CALAMARI)));


    //Meals
    public static final DeferredItem<Item> POPCORN = ITEMS.register("popcorn",
            () -> new Item(new Item.Properties().food(ModFoods.POPCORN)));

    public static final DeferredItem<Item> CORN_DOUGH = ITEMS.register("corn_dough",
            () -> new Item(new Item.Properties().food(ModFoods.CORN_DOUGH)));

    public static final DeferredItem<Item> TORTILLA = ITEMS.register("tortilla",
            () -> new Item(new Item.Properties().food(ModFoods.TORTILLA)));

    public static final DeferredItem<Item> TORTILLA_CHIPS = ITEMS.register("tortilla_chips",
            () -> new Item(new Item.Properties().food(ModFoods.TORTILLA_CHIPS)));

    public static final DeferredItem<Item> ELOTE = ITEMS.register("elote",
            () -> new Item(new Item.Properties().food(ModFoods.ELOTE)));

    public static final DeferredItem<Item> EMPANADA = ITEMS.register("empanada",
            () -> new Item(new Item.Properties().food(ModFoods.EMPANADA)));

    public static final DeferredItem<Item> HEARTY_SALAD = ITEMS.register("hearty_salad",
            () -> new Item(new Item.Properties().stacksTo(16).food(ModFoods.HEARTY_SALAD)));

    public static final DeferredItem<Item> BEEF_BURRITO = ITEMS.register("beef_burrito",
            () -> new Item(new Item.Properties().food(ModFoods.BEEF_BURRITO)));

    public static final DeferredItem<Item> MUTTON_SANDWICH = ITEMS.register("mutton_sandwich",
            () -> new Item(new Item.Properties().food(ModFoods.MUTTON_SANDWICH)));

    public static final DeferredItem<Item> EGGPLANT_PARMESAN = ITEMS.register("eggplant_parmesan",
            () -> new Item(new Item.Properties().stacksTo(16).food(ModFoods.EGGPLANT_PARMESAN)));

    public static final DeferredItem<Item> POACHED_EGGPLANTS = ITEMS.register("poached_eggplants",
            () -> new Item(new Item.Properties().stacksTo(16).food(ModFoods.POACHED_EGGPLANTS)));

    public static final DeferredItem<Item> EGGPLANT_BURGER = ITEMS.register("eggplant_burger",
            () -> new Item(new Item.Properties().food(ModFoods.EGGPLANT_BURGER)));

    public static final DeferredItem<Item> AVOCADO_TOAST = ITEMS.register("avocado_toast",
            () -> new Item(new Item.Properties().food(ModFoods.AVOCADO_TOAST)));

    public static final DeferredItem<Item> CREAMED_CORN = ITEMS.register("creamed_corn",
            () -> new Item(new Item.Properties().stacksTo(16).food(ModFoods.CREAMED_CORN)));

    public static final DeferredItem<Item> CHICKEN_TACO = ITEMS.register("chicken_taco",
            () -> new Item(new Item.Properties().food(ModFoods.CHICKEN_TACO)));

    public static final DeferredItem<Item> SPICY_CURRY = ITEMS.register("spicy_curry",
            () -> new Item(new Item.Properties().stacksTo(16).food(ModFoods.SPICY_CURRY)));

    public static final DeferredItem<Item> PORK_WRAP = ITEMS.register("pork_wrap",
            () -> new Item(new Item.Properties().food(ModFoods.PORK_WRAP)));

    public static final DeferredItem<Item> FISH_TACO = ITEMS.register("fish_taco",
            () -> new Item(new Item.Properties().food(ModFoods.FISH_TACO)));

    public static final DeferredItem<Item> MIDORI_ROLL = ITEMS.register("midori_roll",
            () -> new Item(new Item.Properties().food(ModFoods.MIDORI_ROLL)));

    public static final DeferredItem<Item> MIDORI_ROLL_SLICE = ITEMS.register("midori_roll_slice",
            () -> new Item(new Item.Properties().food(ModFoods.MIDORI_ROLL_SLICE)));

    public static final DeferredItem<Item> EGG_ROLL = ITEMS.register("egg_roll",
            () -> new Item(new Item.Properties().food(ModFoods.EGG_ROLL)));

    public static final DeferredItem<Item> CHICKEN_ROLL = ITEMS.register("chicken_roll",
            () -> new Item(new Item.Properties().food(ModFoods.CHICKEN_ROLL)));

    public static final DeferredItem<Item> CHICKEN_ROLL_SLICE = ITEMS.register("chicken_roll_slice",
            () -> new Item(new Item.Properties().food(ModFoods.CHICKEN_ROLL_SLICE)));

    public static final DeferredItem<Item> PUFFERFISH_ROLL = ITEMS.register("pufferfish_roll",
            () -> new Item(new Item.Properties().food(ModFoods.PUFFERFISH_ROLL)));

    public static final DeferredItem<Item> TROPICAL_ROLL = ITEMS.register("tropical_roll",
            () -> new Item(new Item.Properties().food(ModFoods.TROPICAL_ROLL)));

    public static final DeferredItem<Item> RICE_BALL = ITEMS.register("rice_ball",
            () -> new Item(new Item.Properties().food(ModFoods.RICE_BALL)));

    public static final DeferredItem<Item> CALAMARI_ROLL = ITEMS.register("calamari_roll",
            () -> new Item(new Item.Properties().food(ModFoods.CALAMARI_ROLL)));
    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
