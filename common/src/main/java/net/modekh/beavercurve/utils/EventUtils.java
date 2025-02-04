package net.modekh.beavercurve.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.modekh.beavercurve.config.Config;
import net.modekh.beavercurve.config.EntityClass;

public class EventUtils {
    private static long prevTime = 0;

    private static final PolishPhrase phrase = PolishPhrase.PHRASE_0;

    public static boolean triggerSound(Player player, Entity entity, InteractionHand hand) {
        if (EntityClass.getByConfig(Config.ENTITY_CLASS.get()).isInstance(entity)) { // EntityClass.getByConfig(Config.ENTITY_CLASS.get())
            long currentTime = System.currentTimeMillis();

            if (currentTime - prevTime >= Config.COOLDOWN.get()) {
                swingMainHand(player, hand);

                if (Config.SOUND_ENABLED.get()) {
                    playPolishSound();
                }

                if (Config.MESSAGE_ENABLED.get()) {
                    ChatUtils.sendPolishMessage(player, PolishPhrase.next(phrase).getMessage(), Config.MESSAGE_TYPE.get());
                }

                prevTime = currentTime;

                return true;
            }
        }

        return false;
    }

    public static void playPolishSound() {
        String sound = "polish_word";
        SoundEvent soundEvent = SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID, sound));

        Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forLocalAmbience(
                soundEvent, 1.0F, 1.0F
        ));
    }

    public static void swingMainHand(Player player, InteractionHand hand) {
        if (player instanceof LocalPlayer localPlayer) {
            localPlayer.swing(hand);
        }
    }
}
