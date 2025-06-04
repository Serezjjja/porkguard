package com.example.worldguard;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(WorldGuardMod.MODID)
public class WorldGuardMod {
    public static final String MODID = "worldguard";

    public WorldGuardMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
    }

    private void onCommonSetup(final FMLCommonSetupEvent event) {
        // Initialize WorldGuard systems (placeholder)
    }
}
