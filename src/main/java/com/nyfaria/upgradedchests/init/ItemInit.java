package com.nyfaria.upgradedchests.init;

import com.nyfaria.upgradedchests.NyfsUpgradedChests;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NyfsUpgradedChests.MODID);
}
