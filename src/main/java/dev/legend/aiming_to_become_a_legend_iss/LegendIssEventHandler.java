package dev.legend.aiming_to_become_a_legend_iss;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Event-driven handler for Aiming to become a legend: ISS Addon.
 * Uses LOWEST priority so the parent mod processes the milestone points and updates AppliedTier first.
 * Then this handler immediately synchronizes the ISS magic attributes.
 * No Mixins or bytecode modifications used!
 */
@Mod.EventBusSubscriber(modid = AimingToBecomeALegendIss.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LegendIssEventHandler {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onAdvancementEarn(AdvancementEvent.AdvancementEarnEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            LegendIssData.updateBuffs(player);
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onLivingDeath(LivingDeathEvent event) {
        LivingEntity victim = event.getEntity();
        if (victim instanceof Player) {
            return;
        }

        var sourceEntity = event.getSource().getEntity();
        ServerPlayer player = null;
        if (sourceEntity instanceof ServerPlayer sp) {
            player = sp;
        } else if (sourceEntity instanceof TamableAnimal tamable && tamable.getOwner() instanceof ServerPlayer sp) {
            player = sp;
        }

        if (player != null) {
            LegendIssData.updateBuffs(player);
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onItemUseFinish(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) {
            return;
        }

        ItemStack itemStack = event.getItem();
        if (!itemStack.isEmpty() && itemStack.getItem().isEdible()) {
            LegendIssData.updateBuffs(player);
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            LegendIssData.updateBuffs(player);
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            LegendIssData.updateBuffs(player);
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            LegendIssData.updateBuffs(player);
        }
    }
}
