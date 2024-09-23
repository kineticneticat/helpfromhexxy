package dev.kineticcat.helpfromhexxy;

//import dev.kineticcat.complexhex.client.RegisterClientStuff;

import com.samsthenerd.inline.api.client.InlineClientAPI;
import com.samsthenerd.inline.api.matching.InlineMatch;
import com.samsthenerd.inline.api.matching.MatcherInfo;
import com.samsthenerd.inline.api.matching.RegexMatcher;
import dev.kineticcat.helpfromhexxy.client.HexxySaysRenderer;
import dev.kineticcat.helpfromhexxy.notclient.HexxySaysData;

import static dev.kineticcat.helpfromhexxy.HelpFromHexxy.id;

/**
 * Common client loading entrypoint.
 */
public class HelpFromHexxyClient {
    public static void init() {
        InlineClientAPI.INSTANCE.addMatcher(new RegexMatcher.Standard(
                "deaqq",
                "[\\s\\S]+?",
                id("deaqq"),
                (String text) -> new InlineMatch.DataMatch(new HexxySaysData(text)),
                MatcherInfo.fromId(id("deaqq"))
        ));
        InlineClientAPI.INSTANCE.addRenderer(HexxySaysRenderer.INSTANCE);
    }
}
