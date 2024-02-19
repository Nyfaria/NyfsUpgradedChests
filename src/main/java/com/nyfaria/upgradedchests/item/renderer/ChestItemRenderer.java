package com.nyfaria.upgradedchests.item.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.nyfaria.upgradedchests.block.UpgradedChestBlock;
import com.nyfaria.upgradedchests.block.entity.UpgradedChestBlockEntity;
import com.nyfaria.upgradedchests.item.UpgradedChestBlockItem;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.ChestBlockEntity;

public class ChestItemRenderer extends BlockEntityWithoutLevelRenderer {
    private final BlockEntityRenderDispatcher blockEntityRenderDispatcher;
    public ChestItemRenderer(BlockEntityRenderDispatcher pBlockEntityRenderDispatcher, EntityModelSet pEntityModelSet) {
        super(pBlockEntityRenderDispatcher, pEntityModelSet);
        blockEntityRenderDispatcher = pBlockEntityRenderDispatcher;
    }


    @Override
    public void renderByItem(ItemStack pStack, ItemTransforms.TransformType pTransformType, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        if(pStack.getItem() instanceof UpgradedChestBlockItem blockItem) {
            if(blockItem.getBlock() instanceof UpgradedChestBlock block) {
                UpgradedChestBlockEntity chest = new UpgradedChestBlockEntity(BlockPos.ZERO, block.defaultBlockState());
                this.blockEntityRenderDispatcher.renderItem(chest, pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
            }
        }
    }
}
