package com.nyfaria.upgradedchests.item;

import com.nyfaria.upgradedchests.block.UpgradedChestBlock;
import com.nyfaria.upgradedchests.item.renderer.ChestItemRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.IItemRenderProperties;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class UpgradedChestBlockItem extends BlockItem {
    private final Block block;
    public UpgradedChestBlockItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
        this.block = pBlock;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
        List<String> words = new ArrayList<>();
        Arrays.stream(((UpgradedChestBlock) block).getType().getLoc().split("_")).toList().forEach(e -> {

                    words.add(StringUtils.capitalize(e));

                }
        );

        pTooltip.add(new TextComponent("Type: " + String.join(" ",words).trim()));
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties(){
            @Override
            public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
                return new ChestItemRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
            }
        });
    }

}
