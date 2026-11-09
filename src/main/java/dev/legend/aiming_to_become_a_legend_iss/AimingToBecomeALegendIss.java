package dev.legend.aiming_to_become_a_legend_iss;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;

@Mod(AimingToBecomeALegendIss.MODID)
public class AimingToBecomeALegendIss {
    public static final String MODID = "aiming_to_become_a_legend_iss";
    public static final Logger LOGGER = LogUtils.getLogger();

    public AimingToBecomeALegendIss() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_SPEC);
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("Aiming to become a legend - ISS Addon initialized.");
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        LegendIssCommand.register(event.getDispatcher());
    }
}
