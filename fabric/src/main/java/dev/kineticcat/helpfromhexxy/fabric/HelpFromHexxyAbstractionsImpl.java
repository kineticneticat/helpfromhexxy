package dev.kineticcat.helpfromhexxy.fabric;

import dev.kineticcat.helpfromhexxy.HelpFromHexxyAbstractions;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class HelpFromHexxyAbstractionsImpl {
    /**
     * This is the actual implementation of {@link HelpFromHexxyAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
	
    public static void initPlatformSpecific() {
        HelpFromHexxyConfigFabric.init();
    }
}
