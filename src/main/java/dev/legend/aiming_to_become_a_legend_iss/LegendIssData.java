package dev.legend.aiming_to_become_a_legend_iss;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.UUID;

public class LegendIssData {
    public static final String PARENT_DATA_KEY = "AimingToBecomeALegend";
    public static final String TAG_APPLIED_TIER = "AppliedTier";

    /**
     * Retrieves the current milestone tier achieved from the parent mod "Aiming to become a legend".
     * Reads directly from player's persistent data where the parent mod stores its progress.
     */
    public static int getParentTier(ServerPlayer player) {
        CompoundTag persistent = player.getPersistentData();
        if (persistent.contains(PARENT_DATA_KEY, Tag.TAG_COMPOUND)) {
            CompoundTag parentTag = persistent.getCompound(PARENT_DATA_KEY);
            return parentTag.getInt(TAG_APPLIED_TIER);
        }
        return 0;
    }

    /**
     * Synchronizes and applies the Iron's Spells 'n Spellbooks magic bonuses
     * based on the parent mod's tier progression.
     */
    public static void updateBuffs(ServerPlayer player) {
        if (!IssAttributes.isIssAvailable()) {
            return;
        }

        int tier = getParentTier(player);

        double manaRegenBonus = tier * Config.SERVER.manaRegenPerTier.get();
        double spellPowerBonus = tier * Config.SERVER.spellPowerPerTier.get();
        double maxManaBonus = tier * Config.SERVER.maxManaPerTier.get();
        double cooldownReductionBonus = tier * Config.SERVER.cooldownReductionPerTier.get();
        double castTimeReductionBonus = tier * Config.SERVER.castTimeReductionPerTier.get();
        double spellResistBonus = tier * Config.SERVER.spellResistPerTier.get();

        applyModifier(player, IssAttributes.getManaRegenAttribute(), IssAttributes.MANA_REGEN_UUID,
                "Legend Mana Regen", manaRegenBonus, AttributeModifier.Operation.MULTIPLY_BASE);

        applyModifier(player, IssAttributes.getSpellPowerAttribute(), IssAttributes.SPELL_POWER_UUID,
                "Legend Spell Power", spellPowerBonus, AttributeModifier.Operation.MULTIPLY_BASE);

        applyModifier(player, IssAttributes.getMaxManaAttribute(), IssAttributes.MAX_MANA_UUID,
                "Legend Max Mana", maxManaBonus, AttributeModifier.Operation.ADDITION);

        applyModifier(player, IssAttributes.getCooldownReductionAttribute(), IssAttributes.COOLDOWN_REDUCTION_UUID,
                "Legend Cooldown Reduction", cooldownReductionBonus, AttributeModifier.Operation.MULTIPLY_BASE);

        applyModifier(player, IssAttributes.getCastTimeReductionAttribute(), IssAttributes.CAST_TIME_REDUCTION_UUID,
                "Legend Cast Time Reduction", castTimeReductionBonus, AttributeModifier.Operation.MULTIPLY_BASE);

        applyModifier(player, IssAttributes.getSpellResistAttribute(), IssAttributes.SPELL_RESIST_UUID,
                "Legend Spell Resist", spellResistBonus, AttributeModifier.Operation.MULTIPLY_BASE);
    }

    private static void applyModifier(ServerPlayer player, Attribute attribute, UUID uuid, String name, double amount, AttributeModifier.Operation operation) {
        if (attribute == null) {
            return;
        }

        AttributeInstance instance = player.getAttribute(attribute);
        if (instance == null) {
            return;
        }

        AttributeModifier existing = instance.getModifier(uuid);
        if (existing != null) {
            if (Math.abs(existing.getAmount() - amount) < 1e-6 && existing.getOperation() == operation) {
                return;
            }
            instance.removeModifier(uuid);
        }

        if (amount > 0.0) {
            instance.addPermanentModifier(new AttributeModifier(
                    uuid,
                    name,
                    amount,
                    operation
            ));
        }
    }
}
