package dev.kineticcat.helpfromhexxy.forge;

import dev.kineticcat.helpfromhexxy.HelpFromHexxyClient;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Forge client loading entrypoint.
 */
public class ComplexhexClientForge {
    public static void init(FMLClientSetupEvent event) {
        HelpFromHexxyClient.init();
    }
}
