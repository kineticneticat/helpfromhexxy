package dev.kineticcat.helpfromhexxy;

//import dev.kineticcat.complexhex.client.RegisterClientStuff;

import com.samsthenerd.inline.api.client.InlineClientAPI;
import com.samsthenerd.inline.api.matching.InlineMatch;
import com.samsthenerd.inline.api.matching.MatcherInfo;
import com.samsthenerd.inline.api.matching.RegexMatcher;
import dev.kineticcat.helpfromhexxy.client.HexxySaysRenderer;
import dev.kineticcat.helpfromhexxy.notclient.Emote1616Data;
import dev.kineticcat.helpfromhexxy.notclient.HexxySaysData;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.regex.MatchResult;

import static dev.kineticcat.helpfromhexxy.HelpFromHexxy.id;

/**
 * Common client loading entrypoint.
 */
public class HelpFromHexxyClient {
//    public enum IotaIcons {
//        VECTOR ("vector"),
//        DOUBLE ("number"),
//        ENTITY ("entity"),




//        private String name;
//        IotaIcons(String name) {
//            this.name = name;
//        }
//    }

    private static void filereguv(String name, String file, float MinU, float MinV, float MaxU, float MaxV) {
        InlineClientAPI.INSTANCE.addMatcher(new RegexMatcher.Simple(
                ":%s:".formatted(name),
                id(file),
                (MatchResult match) -> new InlineMatch.DataMatch(new Emote1616Data(id("textures/inline/%s.png".formatted(file)),MinU, MinV, MaxU, MaxV)),
                MatcherInfo.fromId(id(file))
        ));
    }

    public static void init() {
        InlineClientAPI.INSTANCE.addMatcher(new RegexMatcher.Standard(
                "deaqq",
                "[\\s\\S]+?",
                id("deaqq"),
                (String text) -> new InlineMatch.DataMatch(new HexxySaysData(text)),
                MatcherInfo.fromId(id("deaqq"))
        ));
        InlineClientAPI.INSTANCE.addRenderer(HexxySaysRenderer.INSTANCE);



        BiConsumer<String, String> filereg = (name, file) -> filereguv(name, file, 0, 0, 1, 1);
        Consumer<String> register = name -> filereg.accept(name, name);

        register.accept("hexxy");
        register.accept("weedhexxy");
        register.accept("fluxxy");
        register.accept("clueless");
        register.accept("cluedin");
        filereg.accept("I_Use_WispOS_Btw", "iusewisposbtw");
        register.accept("psexxy");
        register.accept("concern");
        filereg.accept("amethyst_cherish", "amethystcherish");


    }
}
