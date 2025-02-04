package net.modekh.beavercurve.config;

import net.minecraftforge.common.ForgeConfigSpec;

/**
 * Used <a href="https://github.com/Fuzss/forgeconfigapiport">Forge Config API Port</a>  for configs on Fabric
 */
public class Config {

    public static final ForgeConfigSpec CONFIG_SPEC;

    // config variables
    public static final ForgeConfigSpec.LongValue COOLDOWN;
    public static final ForgeConfigSpec.EnumValue<EntityClass> ENTITY_CLASS;
    public static final ForgeConfigSpec.BooleanValue SOUND_ENABLED;
    public static final ForgeConfigSpec.BooleanValue MESSAGE_ENABLED;
    public static final ForgeConfigSpec.BooleanValue MESSAGE_TYPE;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("BeaverCurve Config");

        COOLDOWN = builder
                .comment("Defines delay for right-clicking entity (milliseconds)")
                .defineInRange("cooldown", 993L, 0, Long.MAX_VALUE);
        ENTITY_CLASS = builder
                    .comment("Defines which type of entity should trigger the sound or message")
                .defineEnum("entityClass", EntityClass.MOB);
        SOUND_ENABLED = builder
                .comment("Enables sounds on right-clicking")
                .define("enableSounds", true);
        MESSAGE_ENABLED = builder
                .comment("Enables messages on right-clicking")
                .define("enableMessages", true);
        MESSAGE_TYPE = builder.comment("Defines where message should display")
                .comment("\"true\" stands for display above hotbar, \"false\" - display in chat")
                .comment("Works with messages enabled")
                .define("hotbarMessages", true);

        builder.pop();

        CONFIG_SPEC = builder.build();
    }
}
