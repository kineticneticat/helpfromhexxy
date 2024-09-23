package dev.kineticcat.helpfromhexxy.api.config;

import dev.kineticcat.helpfromhexxy.HelpFromHexxy;

/**
 * Platform-agnostic class for statically accessing current config values.
 * If any of the config types (common, client, server) are not needed in your mod,
 * feel free to remove anything related to them in this class and platform-specific config implementations.
 */
public class HelpFromHexxyConfig {
    private static final CommonConfigAccess dummyCommon = new CommonConfigAccess() {
    };
    private static final ClientConfigAccess dummyClient = new ClientConfigAccess() {
    };
    private static final ServerConfigAccess dummyServer = new ServerConfigAccess() {
    };
    private static CommonConfigAccess common = dummyCommon;
    private static ClientConfigAccess client = dummyClient;
    private static ServerConfigAccess server = dummyServer;

    public static CommonConfigAccess getCommon() {
        return common;
    }

    public static void setCommon(CommonConfigAccess common) {
        if (HelpFromHexxyConfig.common != dummyCommon) {
            HelpFromHexxy.LOGGER.warn("CommonConfigAccess was replaced! Old {} New {}", HelpFromHexxyConfig.common.getClass().getName(), common.getClass().getName());
        }
        HelpFromHexxyConfig.common = common;
    }

    public static ClientConfigAccess getClient() {
        return client;
    }

    public static void setClient(ClientConfigAccess client) {
        if (HelpFromHexxyConfig.client != dummyClient) {
            HelpFromHexxy.LOGGER.warn("ClientConfigAccess was replaced! Old {} New {}", HelpFromHexxyConfig.client.getClass().getName(), client.getClass().getName());
        }
        HelpFromHexxyConfig.client = client;
    }

    public static ServerConfigAccess getServer() {
        return server;
    }

    public static void setServer(ServerConfigAccess server) {

        if (HelpFromHexxyConfig.server != dummyServer) {
            HelpFromHexxy.LOGGER.warn("ServerConfigAccess was replaced! Old {} New {}", HelpFromHexxyConfig.server.getClass().getName(), server.getClass().getName());
        }
        HelpFromHexxyConfig.server = server;
    }

    public static int bound(int toBind, int lower, int upper) {
        return Math.min(Math.max(toBind, lower), upper);
    }

    public static double bound(double toBind, double lower, double upper) {
        return Math.min(Math.max(toBind, lower), upper);
    }

    public interface CommonConfigAccess {
    }

    public interface ClientConfigAccess {
    }

    public interface ServerConfigAccess {
    }
}
