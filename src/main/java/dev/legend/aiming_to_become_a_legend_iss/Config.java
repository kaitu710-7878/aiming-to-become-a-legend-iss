package dev.legend.aiming_to_become_a_legend_iss;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class Config {
    public static final ServerConfig SERVER;
    public static final ForgeConfigSpec SERVER_SPEC;

    static {
        Pair<ServerConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
        SERVER = specPair.getLeft();
        SERVER_SPEC = specPair.getRight();
    }

    public static class ServerConfig {
        public final ForgeConfigSpec.DoubleValue manaRegenPerTier;
        public final ForgeConfigSpec.DoubleValue spellPowerPerTier;
        public final ForgeConfigSpec.DoubleValue maxManaPerTier;
        public final ForgeConfigSpec.DoubleValue cooldownReductionPerTier;
        public final ForgeConfigSpec.DoubleValue castTimeReductionPerTier;
        public final ForgeConfigSpec.DoubleValue spellResistPerTier;

        public ServerConfig(ForgeConfigSpec.Builder builder) {
            builder.push("iss_attribute_bonuses");

            manaRegenPerTier = builder
                    .comment("Mana regeneration multiplier increase per tier (0.05 = +5%). Default: 0.05")
                    .defineInRange("manaRegenPerTier", 0.05, 0.0, 100.0);

            spellPowerPerTier = builder
                    .comment("Global spell power multiplier increase per tier (0.05 = +5%). Default: 0.05")
                    .defineInRange("spellPowerPerTier", 0.05, 0.0, 100.0);

            maxManaPerTier = builder
                    .comment("Maximum mana pool increase per tier. Default: 20.0")
                    .defineInRange("maxManaPerTier", 20.0, 0.0, 100000.0);

            cooldownReductionPerTier = builder
                    .comment("Cooldown reduction multiplier increase per tier (0.05 = +5%). Default: 0.05")
                    .defineInRange("cooldownReductionPerTier", 0.05, 0.0, 10.0);

            castTimeReductionPerTier = builder
                    .comment("Cast time reduction multiplier increase per tier (0.05 = +5%). Default: 0.05")
                    .defineInRange("castTimeReductionPerTier", 0.05, 0.0, 10.0);

            spellResistPerTier = builder
                    .comment("Spell resistance multiplier increase per tier (0.01 = +1%). Default: 0.01")
                    .defineInRange("spellResistPerTier", 0.01, 0.0, 1.0);

            builder.pop();
        }
    }
}
