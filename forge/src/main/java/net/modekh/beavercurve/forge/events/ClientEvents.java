package net.modekh.beavercurve.forge.events;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.modekh.beavercurve.utils.EventUtils;
import net.modekh.beavercurve.utils.PolishPhrase;
import net.modekh.beavercurve.utils.Reference;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {
    private static final PolishPhrase phrase = PolishPhrase.PHRASE_0;

    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.EntityInteract event) {
        Level level = event.getLevel();
        Player player = event.getEntity();

        if (!level.isClientSide) {
            return;
        }

        if (event.getHand().equals(InteractionHand.MAIN_HAND)) {
            EventUtils.triggerSound(player, event.getTarget(), event.getHand());
        }
    }
}
