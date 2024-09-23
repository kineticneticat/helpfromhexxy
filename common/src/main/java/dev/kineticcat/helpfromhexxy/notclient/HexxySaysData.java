package dev.kineticcat.helpfromhexxy.notclient;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.samsthenerd.inline.api.InlineData;
import net.minecraft.resources.ResourceLocation;

import static dev.kineticcat.helpfromhexxy.HelpFromHexxy.id;

public class HexxySaysData implements InlineData<HexxySaysData> {

    public HexxySaysData(String text) {
        this.text = text;
    }

    @Override
    public InlineDataType<HexxySaysData> getType() {
        return HexxySaysDataType.INSTANCE;
    }

    @Override
    public ResourceLocation getRendererId() {
        return id("deaqq");
    }

    public String text;

    public static class HexxySaysDataType implements InlineDataType<HexxySaysData> {
        public static HexxySaysDataType INSTANCE = new HexxySaysDataType();
        @Override
        public ResourceLocation getId() { return id("hexxy_says"); }

        @Override
        public Codec<HexxySaysData> getCodec() {
            return Codec.STRING.flatComapMap(
                    HexxySaysData::new,
                    (HexxySaysData data) -> DataResult.success(data.text)
            );
        }

    }


}
