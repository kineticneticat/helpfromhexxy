package dev.kineticcat.helpfromhexxy.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.samsthenerd.inline.api.client.InlineRenderer;
import dev.kineticcat.helpfromhexxy.notclient.HexxySaysData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

import static dev.kineticcat.helpfromhexxy.HelpFromHexxy.id;

public class HexxySaysRenderer implements InlineRenderer<HexxySaysData> {
    public static HexxySaysRenderer INSTANCE = new HexxySaysRenderer();
    @Override
    public ResourceLocation getId() {
        return id("deaqq");
    }

    public static float BUBBLE_SCALE = 1.5f;

    @Override
    public int render(HexxySaysData data, GuiGraphics context, int index, Style style, int codepoint, TextRenderingContext trContext) {
        String text = data.text;
        ResourceLocation hexture = id("textures/inline/hexxy_says.png") ;
        RenderSystem.setShaderTexture(0, hexture);
        RenderSystem.setShader(GameRenderer::getRendertypeEntityTranslucentShader);
        VertexConsumer consumer = context.bufferSource().getBuffer(RenderType.entityTranslucent(hexture));
        context.pose().translate(0, 0, 1);
        Matrix3f norm = context.pose().last().normal();
        float horizDiv = 1f / 32f;
        float vertDiv = 1f / 16f;
        float startWidth = 8f * (26f / 16f);
        Font font = Minecraft.getInstance().font;
        int actualTextWidth = font.width(text);
        float scaledTextWidth = actualTextWidth/BUBBLE_SCALE;
        // (width*1.3 - width)/2 where width = startWidth + scaledTextWidth + 4f
        float width = startWidth + scaledTextWidth + 4;
        float horizDelta = (width*BUBBLE_SCALE - width)/2;
        float vertDelta = (8*BUBBLE_SCALE - 8) /2;
        context.pose().pushPose();
        context.pose().scale(BUBBLE_SCALE, BUBBLE_SCALE, 1);
        context.pose().translate(0, -vertDelta, 0);
        Matrix4f mat = context.pose().last().pose();
        quad(consumer, mat, norm, 0, 0, startWidth, 8f, 0, 0, 26 * horizDiv, 1, trContext.light(), -1);
        quad(consumer, mat, norm, startWidth, 0, scaledTextWidth, 8f, 26*horizDiv, 0, horizDiv, 1, trContext.light(), -1);
        quad(consumer, mat, norm, startWidth + scaledTextWidth, 0, 4f, 8f, 28*horizDiv, 0, 4*horizDiv, 1, trContext.light(), -1);
        context.pose().popPose();
//        font.drawInBatch(Component.literal(text).withStyle(style), startWidth, 0, 0, false, context.pose().last().pose(), context.bufferSource(), Font.DisplayMode.NORMAL, 0, trContext.light(), true );
        font.drawInBatch(Component.literal(text), startWidth+(horizDelta/1.5f), 0, 0, false, context.pose().last().pose(), context.bufferSource(), Font.DisplayMode.NORMAL, 0, trContext.light());
        return charWidth(data, style, codepoint);
    }

    @Override
    public int charWidth(HexxySaysData data, Style style, int codepoint) {
        return data.text.length()*8;
    }

    private void quad(VertexConsumer consumer, Matrix4f mat, Matrix3f norm, float posX, float posY, float sizeX, float sizeY, float posU, float posV, float sizeU, float sizeV, int light, float zHeight) {
        vertex(consumer, mat, norm, posX, posY, posU, posV, light, zHeight);
        vertex(consumer, mat, norm, posX, posY+sizeY, posU, posV+sizeV, light, zHeight);
        vertex(consumer, mat, norm, posX+sizeX, posY+sizeY, posU+sizeU, posV+sizeV, light, zHeight);
        vertex(consumer, mat, norm, posX+sizeX, posY, posU+sizeU, posV, light, zHeight);
    }
    private void vertex(VertexConsumer consumer, Matrix4f mat, Matrix3f norm, float posX, float posY, float posU, float posV, int light, float zHeight) {
        consumer
                .vertex(mat, posX, posY, zHeight)
                .color(0xffffffff)
                .uv(posU, posV)
                .overlayCoords(OverlayTexture.NO_OVERLAY)
                .uv2(light)
                .normal(norm, 0, 0, 1)
                .endVertex();
    }
}
