package com.nyfaria.upgradedchests;

import com.nyfaria.upgradedchests.cap.ExampleHolderAttacher;
import com.nyfaria.upgradedchests.datagen.*;
import com.nyfaria.upgradedchests.init.BlockInit;
import com.nyfaria.upgradedchests.init.EntityInit;
import com.nyfaria.upgradedchests.init.ItemInit;
import com.nyfaria.upgradedchests.network.NetworkHandler;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(NyfsUpgradedChests.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NyfsUpgradedChests {
    public static final String MODID = "upgradedchests";
    public static final Logger LOGGER = LogManager.getLogger();

    public NyfsUpgradedChests() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemInit.ITEMS.register(bus);
        EntityInit.ENTITIES.register(bus);
        BlockInit.BLOCKS.register(bus);
        BlockInit.BLOCK_ENTITIES.register(bus);
        ExampleHolderAttacher.register();

    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        NetworkHandler.register();
    }

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        if (event.includeServer()) {
            generator.addProvider(new ModRecipeProvider(generator));
            generator.addProvider(new ModLootTableProvider(generator));
            generator.addProvider(new ModSoundProvider(generator, MODID,existingFileHelper));
        }
        if (event.includeClient()) {
            generator.addProvider(new ModItemModelProvider(generator, existingFileHelper));
            generator.addProvider(new ModBlockStateProvider(generator, existingFileHelper));
            generator.addProvider(new ModLangProvider(generator, MODID, "en_us"));
        }
    }
}
