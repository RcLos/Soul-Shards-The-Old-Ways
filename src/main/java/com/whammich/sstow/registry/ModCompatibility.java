package com.whammich.sstow.registry;

import com.whammich.sstow.compat.hardmode.CompatibilityHardMode;
import com.whammich.sstow.compat.theoneprobe.CompatibilityTheOneProbe;
import net.minecraftforge.fml.common.Loader;
import tehnut.lib.iface.ICompatibility;

import java.util.ArrayList;
import java.util.List;

public class ModCompatibility {

    private static List<ICompatibility> compatibilities = new ArrayList<ICompatibility>();

    public static void registerModCompat() {
        compatibilities.add(new CompatibilityHardMode());
        compatibilities.add(new CompatibilityTheOneProbe());
    }

    public static void loadCompat(ICompatibility.InitializationPhase phase) {
        for (ICompatibility compatibility : compatibilities)
            if (Loader.isModLoaded(compatibility.getModId()) && compatibility.enableCompat())
                compatibility.loadCompatibility(phase);
    }
}
