package net.modekh.beavercurve.fabric;

import fuzs.forgeconfigapiport.api.config.v2.ModConfigEvents;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.world.InteractionResult;
import net.minecraftforge.fml.config.ModConfig;
import net.modekh.beavercurve.BeaverCurve;
import net.modekh.beavercurve.utils.EventUtils;
import net.modekh.beavercurve.utils.Reference;

public class BeaverCurveFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        BeaverCurve.init();

        ModConfigEvents.reloading(Reference.MOD_ID).register(config -> {
            if (config.getType() == ModConfig.Type.CLIENT) {
            }
        });

        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (world.isClientSide()) {
                return EventUtils.triggerSound(player, entity, hand)
                        ? InteractionResult.SUCCESS : InteractionResult.PASS;
            }

            return InteractionResult.PASS;
        });
    }
}
