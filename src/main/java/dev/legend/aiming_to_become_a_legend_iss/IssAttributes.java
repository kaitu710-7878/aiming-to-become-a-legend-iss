package dev.legend.aiming_to_become_a_legend_iss;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.UUID;

public class IssAttributes {
    public static final String ISS_MODID = "irons_spellbooks";

    public static final ResourceLocation MANA_REGEN_ID = new ResourceLocation(ISS_MODID, "mana_regen");
    public static final ResourceLocation SPELL_POWER_ID = new ResourceLocation(ISS_MODID, "spell_power");
    public static final ResourceLocation MAX_MANA_ID = new ResourceLocation(ISS_MODID, "max_mana");
    public static final ResourceLocation COOLDOWN_REDUCTION_ID = new ResourceLocation(ISS_MODID, "cooldown_reduction");
    public static final ResourceLocation CAST_TIME_REDUCTION_ID = new ResourceLocation(ISS_MODID, "cast_time_reduction");
    public static final ResourceLocation SPELL_RESIST_ID = new ResourceLocation(ISS_MODID, "spell_resist");

    // Dedicated fixed UUIDs for this addon's modifiers
    public static final UUID MANA_REGEN_UUID = UUID.fromString("c4f3c3a2-83eb-4c9d-a0c6-79156718b001");
    public static final UUID SPELL_POWER_UUID = UUID.fromString("c4f3c3a2-83eb-4c9d-a0c6-79156718b002");
    public static final UUID MAX_MANA_UUID = UUID.fromString("c4f3c3a2-83eb-4c9d-a0c6-79156718b003");
    public static final UUID COOLDOWN_REDUCTION_UUID = UUID.fromString("c4f3c3a2-83eb-4c9d-a0c6-79156718b004");
    public static final UUID CAST_TIME_REDUCTION_UUID = UUID.fromString("c4f3c3a2-83eb-4c9d-a0c6-79156718b005");
    public static final UUID SPELL_RESIST_UUID = UUID.fromString("c4f3c3a2-83eb-4c9d-a0c6-79156718b006");

    public static Attribute getManaRegenAttribute() {
        return ForgeRegistries.ATTRIBUTES.getValue(MANA_REGEN_ID);
    }

    public static Attribute getSpellPowerAttribute() {
        return ForgeRegistries.ATTRIBUTES.getValue(SPELL_POWER_ID);
    }

    public static Attribute getMaxManaAttribute() {
        return ForgeRegistries.ATTRIBUTES.getValue(MAX_MANA_ID);
    }

    public static Attribute getCooldownReductionAttribute() {
        return ForgeRegistries.ATTRIBUTES.getValue(COOLDOWN_REDUCTION_ID);
    }

    public static Attribute getCastTimeReductionAttribute() {
        return ForgeRegistries.ATTRIBUTES.getValue(CAST_TIME_REDUCTION_ID);
    }

    public static Attribute getSpellResistAttribute() {
        return ForgeRegistries.ATTRIBUTES.getValue(SPELL_RESIST_ID);
    }

    public static boolean isIssAvailable() {
        return getMaxManaAttribute() != null;
    }
}
