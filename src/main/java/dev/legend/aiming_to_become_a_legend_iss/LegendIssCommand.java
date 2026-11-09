package dev.legend.aiming_to_become_a_legend_iss;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class LegendIssCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("legend-iss")
                        .executes(ctx -> showStatus(ctx.getSource(), ctx.getSource().getPlayerOrException()))
                        .then(Commands.literal("status")
                                .executes(ctx -> showStatus(ctx.getSource(), ctx.getSource().getPlayerOrException()))
                                .then(Commands.argument("player", EntityArgument.player())
                                        .requires(src -> src.hasPermission(2))
                                        .executes(ctx -> showStatus(ctx.getSource(), EntityArgument.getPlayer(ctx, "player")))
                                )
                        )
                        .then(Commands.literal("sync")
                                .executes(ctx -> syncPlayer(ctx.getSource(), ctx.getSource().getPlayerOrException()))
                                .then(Commands.argument("player", EntityArgument.player())
                                        .requires(src -> src.hasPermission(2))
                                        .executes(ctx -> syncPlayer(ctx.getSource(), EntityArgument.getPlayer(ctx, "player")))
                                )
                        )
        );
    }

    private static int showStatus(CommandSourceStack source, ServerPlayer target) {
        int tier = LegendIssData.getParentTier(target);

        double manaRegenBonus = tier * Config.SERVER.manaRegenPerTier.get() * 100.0;
        double spellPowerBonus = tier * Config.SERVER.spellPowerPerTier.get() * 100.0;
        double maxManaBonus = tier * Config.SERVER.maxManaPerTier.get();
        double cooldownReductionBonus = tier * Config.SERVER.cooldownReductionPerTier.get() * 100.0;
        double castTimeReductionBonus = tier * Config.SERVER.castTimeReductionPerTier.get() * 100.0;
        double spellResistBonus = tier * Config.SERVER.spellResistPerTier.get() * 100.0;

        source.sendSuccess(() -> Component.translatable("command.aiming_to_become_a_legend_iss.status.header"), false);
        source.sendSuccess(() -> Component.translatable("command.aiming_to_become_a_legend_iss.status.tier", tier), false);
        source.sendSuccess(() -> Component.translatable("command.aiming_to_become_a_legend_iss.status.mana_regen", String.format("%.1f", manaRegenBonus)), false);
        source.sendSuccess(() -> Component.translatable("command.aiming_to_become_a_legend_iss.status.spell_power", String.format("%.1f", spellPowerBonus)), false);
        source.sendSuccess(() -> Component.translatable("command.aiming_to_become_a_legend_iss.status.max_mana", String.format("%.0f", maxManaBonus)), false);
        source.sendSuccess(() -> Component.translatable("command.aiming_to_become_a_legend_iss.status.cooldown_reduction", String.format("%.1f", cooldownReductionBonus)), false);
        source.sendSuccess(() -> Component.translatable("command.aiming_to_become_a_legend_iss.status.cast_time_reduction", String.format("%.1f", castTimeReductionBonus)), false);
        source.sendSuccess(() -> Component.translatable("command.aiming_to_become_a_legend_iss.status.spell_resist", String.format("%.1f", spellResistBonus)), false);

        if (!IssAttributes.isIssAvailable()) {
            source.sendSuccess(() -> Component.translatable("command.aiming_to_become_a_legend_iss.status.iss_missing"), false);
        }

        return 1;
    }

    private static int syncPlayer(CommandSourceStack source, ServerPlayer target) {
        LegendIssData.updateBuffs(target);
        source.sendSuccess(() -> Component.translatable("command.aiming_to_become_a_legend_iss.sync.success", target.getDisplayName().getString()), false);
        return 1;
    }
}
