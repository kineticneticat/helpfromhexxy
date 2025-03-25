package dev.kineticcat.helpfromhexxy.notclient;

import com.samsthenerd.inline.api.data.SpriteInlineData;
import com.samsthenerd.inline.utils.TextureSprite;
import net.minecraft.resources.ResourceLocation;

public class Emote1616Data extends SpriteInlineData {
    public Emote1616Data(ResourceLocation resLoc) {
        super(new TextureSprite(resLoc));
    }
    public Emote1616Data(ResourceLocation resLoc, float minU, float minV, float maxU, float maxV) {
        super(new TextureSprite(resLoc, minU, minV, maxU, maxV, 16, 16));
    }
}
