package dev.kineticcat.helpfromhexxy.fabric

import dev.kineticcat.helpfromhexxy.HelpFromHexxyClient
import net.fabricmc.api.ClientModInitializer

/**
 * Fabric client loading entrypoint.
 */
object HelpFromHexxyClientFabric : ClientModInitializer {

    override fun onInitializeClient() {
        HelpFromHexxyClient.init()
    }
}
