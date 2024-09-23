package dev.kineticcat.helpfromhexxy.fabric;

import dev.kineticcat.helpfromhexxy.HelpFromHexxy;
//import dev.kineticcat.complexhex.block.ComplexHexBlocks
//import dev.kineticcat.complexhex.block.entity.ComplexHexBlockEntities
//import dev.kineticcat.complexhex.entity.ComplexHexEntities
//import dev.kineticcat.complexhex.item.ComplexHexCreativeTabs
//import dev.kineticcat.complexhex.item.ComplexHexItems
import net.fabricmc.api.ModInitializer;

/**
 * This is your loading entrypoint on fabric(-likes), in case you need to initialize
 * something platform-specific.
 * <br/>
 * Since quilt can load fabric mods, you develop for two platforms in one fell swoop.
 * Feel free to check out the <a href="https://github.com/architectury/architectury-templates">Architectury templates</a>
 * if you want to see how to add quilt-specific code.
 */
object HelpFromHexxyFabric : ModInitializer {

    override fun onInitialize() {
        HelpFromHexxy.init()
    }
}
