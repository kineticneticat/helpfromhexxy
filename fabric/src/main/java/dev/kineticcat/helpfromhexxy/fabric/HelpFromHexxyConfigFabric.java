package dev.kineticcat.helpfromhexxy.fabric;

import dev.architectury.platform.Platform;
import dev.kineticcat.helpfromhexxy.HelpFromHexxy;
import dev.kineticcat.helpfromhexxy.api.config.HelpFromHexxyConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.fabricmc.api.EnvType;


@SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal"})
@Config(name = HelpFromHexxy.MOD_ID)
public class HelpFromHexxyConfigFabric extends PartitioningSerializer.GlobalData {
    @ConfigEntry.Category("common")
    @ConfigEntry.Gui.TransitiveObject
    public final Common common = new Common();
    @ConfigEntry.Category("client")
    @ConfigEntry.Gui.TransitiveObject
    public final Client client = new Client();
    @ConfigEntry.Category("server")
    @ConfigEntry.Gui.TransitiveObject
    public final Server server = new Server();


    public static void init() {
        AutoConfig.register(HelpFromHexxyConfigFabric.class, PartitioningSerializer.wrap(JanksonConfigSerializer::new));
        var instance = AutoConfig.getConfigHolder(HelpFromHexxyConfigFabric.class).getConfig();

        HelpFromHexxyConfig.setCommon(instance.common);

        if (Platform.getEnv().equals(EnvType.CLIENT)) {
            HelpFromHexxyConfig.setClient(instance.client);
        }

        // Needed for logical server in singleplayer, do not access server configs from client code
        HelpFromHexxyConfig.setServer(instance.server);
    }


    @Config(name = "common")
    private static class Common implements ConfigData, HelpFromHexxyConfig.CommonConfigAccess {
    }

    @Config(name = "client")
    private static class Client implements ConfigData, HelpFromHexxyConfig.ClientConfigAccess {
    }


    @Config(name = "server")
    private static class Server implements ConfigData, HelpFromHexxyConfig.ServerConfigAccess {
    }
}