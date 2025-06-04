package com.example.worldguard.event;

import com.example.worldguard.WorldGuardMod;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.Mod.EventBusSubscriber;
import net.neoforged.fml.common.Mod.EventBusSubscriber.Bus;
import net.neoforged.fml.common.Mod.EventBusSubscriber.Entrypoint;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.world.BlockEvent;

@Mod.EventBusSubscriber(modid = WorldGuardMod.MODID, bus = Bus.FORGE)
public class WGForgeEventHandlers {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        // Placeholder logic: cancel all block breaking
        event.setCanceled(true);
    }

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        // Placeholder: send a message on login
        event.getEntity().sendSystemMessage(net.minecraft.network.chat.Component.literal("WorldGuard active"));
    }
}
