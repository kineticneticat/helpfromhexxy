package dev.kineticcat.helpfromhexxy;

//import dev.kineticcat.complexhex.client.RegisterClientStuff;

import com.samsthenerd.inline.api.client.InlineClientAPI;
import com.samsthenerd.inline.api.data.SpriteInlineData;
import com.samsthenerd.inline.api.matching.InlineMatch;
import com.samsthenerd.inline.api.matching.InlineMatcher;
import com.samsthenerd.inline.api.matching.MatcherInfo;
import com.samsthenerd.inline.api.matching.RegexMatcher;
import com.samsthenerd.inline.utils.TextureSprite;
import dev.kineticcat.helpfromhexxy.client.HexxySaysRenderer;
import dev.kineticcat.helpfromhexxy.notclient.HexxySaysData;

import java.util.regex.MatchResult;

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

        InlineClientAPI.INSTANCE.addMatcher(new RegexMatcher.Simple(
                ":hexxy:",
                id("hexxy"),
                (MatchResult result) -> new InlineMatch.DataMatch(new SpriteInlineData(new TextureSprite(
                        id("textures/inline/hexxy.png")
                ))),
                MatcherInfo.fromId(id("hexxy"))
        ));
        InlineClientAPI.INSTANCE.addMatcher(new RegexMatcher.Simple(
                ":weedhexxy:",
                id("weedhexxy"),
                (MatchResult result) -> new InlineMatch.DataMatch(new SpriteInlineData(new TextureSprite(
                        id("textures/inline/weedhexxy.png")
                ))),
                MatcherInfo.fromId(id("weedhexxy"))
        ));
    }
}
