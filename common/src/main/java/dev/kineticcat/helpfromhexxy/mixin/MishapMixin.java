package dev.kineticcat.helpfromhexxy.mixin;

import at.petrak.hexcasting.api.casting.mishaps.Mishap;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.samsthenerd.inline.impl.InlineStyle;
import dev.kineticcat.helpfromhexxy.api.config.HelpFromHexxyConfig;
import dev.kineticcat.helpfromhexxy.notclient.HexxySaysData;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Mishap.class)
public class MishapMixin {
    @ModifyReturnValue(method = "error(Ljava/lang/String;[Ljava/lang/Object;)Lnet/minecraft/network/chat/Component;", at=@At("RETURN"))
    private Component addHexxy(Component original) {
        if (!HelpFromHexxyConfig.ClientConfigAccess.modifyMishaps) return original;
        Style dataStyle = InlineStyle.fromInlineData(new HexxySaysData(original.getString()));
        return Component.literal(".").setStyle(dataStyle.applyTo(original.getStyle()));
//        return Component.literal("[deaqq:").append(original).append("]");
    }

}
