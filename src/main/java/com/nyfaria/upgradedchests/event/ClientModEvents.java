package com.nyfaria.upgradedchests.event;

import com.nyfaria.upgradedchests.NyfsUpgradedChests;
import com.nyfaria.upgradedchests.block.api.UpgradedChestType;
import com.nyfaria.upgradedchests.block.entity.UpgradedChestRenderer;
import com.nyfaria.upgradedchests.init.BlockInit;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber(modid = NyfsUpgradedChests.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {
    public static Map<UpgradedChestType, Material> MATERIALS = new HashMap<>();
    @SubscribeEvent
    public static void onEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BlockInit.UPGRADED_CHEST_BLOCK_ENTITY.get(), UpgradedChestRenderer::new);
    }

    @SubscribeEvent
    public static void stitchTextures(TextureStitchEvent.Pre event){
        ResourceLocation loc = event.getAtlas().location();
        ResourceLocation oak = new ResourceLocation(NyfsUpgradedChests.MODID, "chest/oak");
        ResourceLocation birch = new ResourceLocation(NyfsUpgradedChests.MODID, "chest/birch");
        ResourceLocation jungle = new ResourceLocation(NyfsUpgradedChests.MODID, "chest/jungle");
        ResourceLocation acacia = new ResourceLocation(NyfsUpgradedChests.MODID, "chest/acacia");
        ResourceLocation dark_oak = new ResourceLocation(NyfsUpgradedChests.MODID, "chest/dark_oak");
        ResourceLocation spruce = new ResourceLocation(NyfsUpgradedChests.MODID, "chest/spruce");
        ResourceLocation crimson = new ResourceLocation(NyfsUpgradedChests.MODID, "chest/crimson");
        ResourceLocation warped = new ResourceLocation(NyfsUpgradedChests.MODID, "chest/warped");

        event.addSprite(oak);
        event.addSprite(birch);
        event.addSprite(jungle);
        event.addSprite(acacia);
        event.addSprite(dark_oak);
        event.addSprite(spruce);
        event.addSprite(crimson);
        event.addSprite(warped);

        MATERIALS.put(UpgradedChestType.OAK, new Material(loc, oak));
        MATERIALS.put(UpgradedChestType.BIRCH, new Material(loc, birch));
        MATERIALS.put(UpgradedChestType.JUNGLE, new Material(loc, jungle));
        MATERIALS.put(UpgradedChestType.ACACIA, new Material(loc, acacia));
        MATERIALS.put(UpgradedChestType.DARK_OAK, new Material(loc, dark_oak));
        MATERIALS.put(UpgradedChestType.SPRUCE, new Material(loc, spruce));
        MATERIALS.put(UpgradedChestType.CRIMSON, new Material(loc, crimson));
        MATERIALS.put(UpgradedChestType.WARPED, new Material(loc, warped));

    }
}
