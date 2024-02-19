package com.nyfaria.upgradedchests.cap;

import com.nyfaria.upgradedchests.NyfsUpgradedChests;
import dev._100media.capabilitysyncer.core.CapabilityAttacher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NyfsUpgradedChests.MODID)
public class ExampleHolderAttacher extends CapabilityAttacher {

    public static final Capability<ExampleHolder> EXAMPLE_CAPABILITY = getCapability(new CapabilityToken<>() {
    });
    public static final ResourceLocation EXAMPLE_RL = new ResourceLocation(NyfsUpgradedChests.MODID, "example");
    private static final Class<ExampleHolder> CAPABILITY_CLASS = ExampleHolder.class;

    public static ExampleHolder getCustomHolderUnwrap(Entity player) {
        return getAirHolder(player).orElse(null);
    }

    public static LazyOptional<ExampleHolder> getAirHolder(Entity player) {
        return player.getCapability(EXAMPLE_CAPABILITY);
    }

    private static void attach(AttachCapabilitiesEvent<Entity> event, Entity player) {
        genericAttachCapability(event, new ExampleHolder(player), EXAMPLE_CAPABILITY, EXAMPLE_RL);
    }

    public static void register() {
        CapabilityAttacher.registerCapability(CAPABILITY_CLASS);
        CapabilityAttacher.registerEntityAttacher(LivingEntity.class, ExampleHolderAttacher::attach, ExampleHolderAttacher::getAirHolder);
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        Player oldPlayer = event.getOriginal();
        Player newPlayer = event.getPlayer();

        // So we can copy capabilities
        oldPlayer.revive();

        getAirHolder(oldPlayer).ifPresent(oldAbilityHolder -> getAirHolder(newPlayer)
                .ifPresent(newAbilityHolder -> newAbilityHolder.deserializeNBT(oldAbilityHolder.serializeNBT(false), false)));
    }
}
