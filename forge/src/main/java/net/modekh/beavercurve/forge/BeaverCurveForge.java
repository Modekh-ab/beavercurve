package net.modekh.beavercurve.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.modekh.beavercurve.BeaverCurve;
import net.modekh.beavercurve.config.Config;
import net.modekh.beavercurve.utils.Reference;

@Mod(Reference.MOD_ID)
public class BeaverCurveForge {
    public BeaverCurveForge() {
        BeaverCurve.init();
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CONFIG_SPEC);
    }
}
