package com.nyfaria.upgradedchests.init;

import com.nyfaria.upgradedchests.block.UpgradedChestBlock;
import com.nyfaria.upgradedchests.block.api.UpgradedChestType;
import com.nyfaria.upgradedchests.block.entity.UpgradedChestBlockEntity;
import com.nyfaria.upgradedchests.item.UpgradedChestBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.nyfaria.upgradedchests.NyfsUpgradedChests.MODID;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MODID);

    public static final RegistryObject<Block> OAK_UPGRADED_CHEST = registerBlock("oak_upgraded_chest", ()->new UpgradedChestBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD), UpgradedChestType.OAK));
    public static final RegistryObject<Block> SPRUCE_UPGRADED_CHEST = registerBlock("spruce_upgraded_chest", ()->new UpgradedChestBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD), UpgradedChestType.SPRUCE));
    public static final RegistryObject<Block> BIRCH_UPGRADED_CHEST = registerBlock("birch_upgraded_chest", ()->new UpgradedChestBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD), UpgradedChestType.BIRCH));
    public static final RegistryObject<Block> JUNGLE_UPGRADED_CHEST = registerBlock("jungle_upgraded_chest", ()->new UpgradedChestBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD), UpgradedChestType.JUNGLE));
    public static final RegistryObject<Block> ACACIA_UPGRADED_CHEST = registerBlock("acacia_upgraded_chest", ()->new UpgradedChestBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD), UpgradedChestType.ACACIA));
    public static final RegistryObject<Block> DARK_OAK_UPGRADED_CHEST = registerBlock("dark_oak_upgraded_chest", ()->new UpgradedChestBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD), UpgradedChestType.DARK_OAK));
    public static final RegistryObject<Block> CRIMSON_UPGRADED_CHEST = registerBlock("crimson_upgraded_chest", ()->new UpgradedChestBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD), UpgradedChestType.CRIMSON));
    public static final RegistryObject<Block> WARPED_UPGRADED_CHEST = registerBlock("warped_upgraded_chest", ()->new UpgradedChestBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD), UpgradedChestType.WARPED));



    public static final RegistryObject<BlockEntityType<UpgradedChestBlockEntity>> UPGRADED_CHEST_BLOCK_ENTITY = BLOCK_ENTITIES.register("upgraded_chest", () -> BlockEntityType.Builder.of(UpgradedChestBlockEntity::new,
            OAK_UPGRADED_CHEST.get(),
            SPRUCE_UPGRADED_CHEST.get(),
            BIRCH_UPGRADED_CHEST.get(),
            JUNGLE_UPGRADED_CHEST.get(),
            ACACIA_UPGRADED_CHEST.get(),
            DARK_OAK_UPGRADED_CHEST.get(),
            CRIMSON_UPGRADED_CHEST.get(),
            WARPED_UPGRADED_CHEST.get()
            ).build(null));

    protected static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, b -> () -> new UpgradedChestBlockItem(b.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    }
    protected static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, Function<RegistryObject<T>, Supplier<? extends BlockItem>> item) {
        var reg = BLOCKS.register(name, block);
        ItemInit.ITEMS.register(name, () -> item.apply(reg).get());
        return reg;
    }
}
