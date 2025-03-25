package dev.kineticcat.helpfromhexxy.forge;

import dev.kineticcat.helpfromhexxy.HelpFromHexxyAbstractions;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class ComplexhexAbstractionsImpl {
    /**
     * This is the actual implementation of {@link HelpFromHexxyAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
	
    public static void initPlatformSpecific() {
        HelpFromHexxyConfigForge.init();
    }
}
