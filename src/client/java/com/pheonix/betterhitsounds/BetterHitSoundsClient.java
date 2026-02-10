package com.pheonix.betterhitsounds;

import com.pheonix.betterhitsounds.client.config.BHSConfig;
import com.pheonix.betterhitsounds.client.sound.ComboTracker;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;

import java.util.Random;

public class BetterHitSoundsClient implements ClientModInitializer {

    private static final Random RANDOM = new Random();
    private static final SoundEvent HIT_SOUND =
            SoundEvent.of(Identifier.of("betterhitsounds", "hit"));

    @Override
    public void onInitializeClient() {
        BHSConfig.load();

        ClientTickEvents.END_CLIENT_TICK.register(client ->
                ComboTracker.tick()
        );

        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (!world.isClient()) return ActionResult.PASS;
            if (hand != Hand.MAIN_HAND) return ActionResult.PASS;
            if (!BHSConfig.INSTANCE.enabled) return ActionResult.PASS;
            if (player.getAttackCooldownProgress(0) < 0.9f) return ActionResult.PASS;

            play(player, entity);
            return ActionResult.PASS;
        });
    }

    private void play(PlayerEntity player, Entity target) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.world == null) return;

        double distSq = player.squaredDistanceTo(target);
        double maxSq = BHSConfig.INSTANCE.maxHearDistance *
                BHSConfig.INSTANCE.maxHearDistance;

        if (distSq > maxSq) return;

        float distanceFactor = 1.0f - (float)(distSq / maxSq);

        boolean crit =
                player.fallDistance > 0 &&
                        !player.isOnGround() &&
                        !player.isClimbing();

        int combo = ComboTracker.hit(target);

        // 🎵 SMART PITCH LOGIC
        float pitch =
                0.88f +
                        RANDOM.nextFloat() * 0.28f +      // randomness
                        (combo * 0.02f) +                 // combo ramp
                        (crit ? 0.12f : 0.0f);            // crit punch

        pitch = Math.min(pitch, 1.8f);

        float volume =
                BHSConfig.INSTANCE.volume *
                        distanceFactor *
                        (crit ? 1.2f : 1.0f);

        client.world.playSound(
                player,
                player.getBlockPos(),
                HIT_SOUND,
                SoundCategory.PLAYERS,
                volume,
                pitch
        );
    }
}
