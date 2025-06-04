package com.example.worldguard.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.example.worldguard.WorldGuardMod;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.neoforged.fml.common.Mod.EventBusSubscriber;
import net.neoforged.fml.common.Mod.EventBusSubscriber.Bus;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@EventBusSubscriber(modid = WorldGuardMod.MODID, bus = Bus.FORGE)
public class WGCommandRegistry {
    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(
                Commands.literal("region")
                        .then(Commands.literal("info")
                                .executes(ctx -> sendInfo(ctx.getSource())))
                        .then(Commands.literal("create")
                                .then(Commands.argument("name", StringArgumentType.word())
                                        .executes(ctx -> createRegion(ctx.getSource(), StringArgumentType.getString(ctx, "name")))))
        );
    }

    private static int sendInfo(CommandSourceStack source) {
        source.sendSuccess(() -> Component.literal("WorldGuard region info"), false);
        return Command.SINGLE_SUCCESS;
    }

    private static int createRegion(CommandSourceStack source, String name) {
        source.sendSuccess(() -> Component.literal("Created region " + name), false);
        return Command.SINGLE_SUCCESS;
    }
}
