package com.logisticscraft.logisticsapi;

import com.logisticscraft.logisticsapi.energy.wire.WireManager;
import com.logisticscraft.logisticsapi.util.nms.NmsHelper;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.logisticscraft.logisticsapi.energy.EnergyManager;
import com.logisticscraft.logisticsapi.liquid.FluidManager;
import com.logisticscraft.logisticsapi.util.console.Tracer;
import com.logisticscraft.logisticsapi.util.nms.bossbar.BossBarManager;

/**
 * @author JARvis (Пётр) PROgrammer
 */
public final class LogisticsApiPlugin extends JavaPlugin {
    private static LogisticsApiPlugin instance;

    public static LogisticsApiPlugin getInstance() {
        return instance;
    }

    private static void disableAll() {
        Tracer.msg("Undisplaying EnergyBars for all Players...");
        EnergyManager.undisplayEnergyBarAll();
        Tracer.msg("EnergyBars for all Players has been undisplayed");
    }

    @Override
    public void onDisable() {
        Tracer.msg("Disabling...");

        disableAll();

        PluginDescriptionFile description = getDescription();
        Tracer.msg(description.getName() + " (v" + description.getVersion() + ") has been disabled.");
    }

    private static void enableNms() {
        Tracer.msg("Enabling NMS...");

        NmsHelper.setupVersion();

        BossBarManager.init();

        Tracer.msg("NMS has been enabled");
    }

    private static void enableEnergyManagers() {
        Tracer.msg("Enabling EnergyManagers...");

        EnergyManager.init();
        WireManager.init();

        Tracer.msg("EnergyManagers has been enabled");
    }
    
    private static void enableFluidManager() {
        Tracer.msg("Enabling FluidManager...");

        FluidManager.getFluid("water");

        Tracer.msg("FluidManager has been enabled");
    }

    @Override
    public void onEnable() {
        instance = this;

        Tracer.setLogger(getLogger());

        Tracer.msg("Enabling...");
        Tracer.msg("Server version: " + getServer().getVersion());
        Tracer.msg("Bukkit version: " + getServer().getBukkitVersion());

        enableNms();
        enableEnergyManagers();
        enableFluidManager();

        PluginDescriptionFile description = getDescription();
        Tracer.msg(description.getName() + " (v" + description.getVersion() + ") has been enabled.");
    }
}
