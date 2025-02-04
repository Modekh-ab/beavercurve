package net.modekh.beavercurve.utils;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

import java.util.Random;

public enum PolishPhrase {
    PHRASE_0,
    PHRASE_1,
    PHRASE_2;

    private final MutableComponent message;

    PolishPhrase() {
        this.message = Component.translatable("message." + Reference.MOD_ID + ".phrase_" + this.ordinal());
    }

    public MutableComponent getMessage() {
        return this.message;
    }

    public static PolishPhrase next(PolishPhrase phrase) {
        Random random = new Random();
        return phrase == null ? values()[0] : values()[random.nextInt(values().length)];
    }
}
