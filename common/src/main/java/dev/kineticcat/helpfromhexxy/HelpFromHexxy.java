package dev.kineticcat.helpfromhexxy;

//import dev.kineticcat.complexhex.api.casting.iota.ComplexHexIotaTypes;
//import dev.kineticcat.complexhex.casting.ComplexhexPatternRegistry;
//import dev.kineticcat.complexhex.casting.arithmetic.ComplexHexArithmetic;
//import dev.kineticcat.complexhex.client.render.ComplexHexGaslighting;
//import dev.kineticcat.complexhex.client.render.CoolerGaslightingTracker;
//import dev.kineticcat.complexhex.entity.AssemblyManagerEntity;

import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is effectively the loading entrypoint for most of your code, at least
 * if you are using Architectury as intended.
 */
public class HelpFromHexxy {
    public static final String MOD_ID = "helpfromhexxy";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    public static void init() {
        LOGGER.info("Help From Hexxy says 'ough'");

        HelpFromHexxyAbstractions.initPlatformSpecific();

        LOGGER.info(HelpFromHexxyAbstractions.getConfigDirectory().toAbsolutePath().normalize().toString());
    }

    public static ResourceLocation id(String string) {
        return new ResourceLocation(MOD_ID, string);
    }
}
