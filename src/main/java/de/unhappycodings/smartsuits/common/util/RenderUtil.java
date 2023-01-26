package de.unhappycodings.smartsuits.common.util;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemStack;

public class RenderUtil {

    public static boolean mouseInArea(int x1, int y1, int x2, int y2, int mouseX, int mouseY) {
        int differenceX = x2 - x1 + 1;
        int differenceY = y2 - y1 + 1;
        boolean isXOver = false;
        boolean isYOver = false;
        for (int i = x1; i < x1 + differenceX; i++)
            for (int e = y1; e < y1 + differenceY; e++) {
                if (i == mouseX && !isXOver) isXOver = true;
                if (e == mouseY && !isYOver) isYOver = true;
            }
        return isXOver && isYOver;
    }

    public static void drawCenteredText(String text, PoseStack stack, int x, int y) {
        Minecraft.getInstance().font.draw(stack, text, x - (Minecraft.getInstance().font.width(text) / 2f), y, 1315860);
    }

    public static void drawCenteredText(String text, PoseStack stack, int x, int y, int color) {
        Minecraft.getInstance().font.draw(stack, text, x - (Minecraft.getInstance().font.width(text) / 2f), y, color);
    }

    public static void drawText(String text, PoseStack stack, int x, int y) {
        Minecraft.getInstance().font.draw(stack, text, x, y, 1315860);
    }

    public static void drawText(String text, PoseStack stack, int x, int y, int color) {
        Minecraft.getInstance().font.draw(stack, text, x, y, color);
    }

    //Adapted from ItemRenderer
    public static void renderGuiItem(ItemStack stack, int x, int y) {
        if (stack == null || stack.isEmpty()) return;

        Minecraft minecraft = Minecraft.getInstance();
        ItemRenderer itemRenderer = minecraft.getItemRenderer();
        BakedModel bakedmodel = itemRenderer.getModel(stack, null, null, 0);

        minecraft.getTextureManager().getTexture(TextureAtlas.LOCATION_BLOCKS).setFilter(false, false);
        RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_BLOCKS);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        PoseStack posestack = RenderSystem.getModelViewStack();
        posestack.pushPose();
        posestack.translate(x, y, 100);
        posestack.translate(32.0D, 32.0D, 0.0D);
        posestack.scale(1.0F, -1.0F, 1.0F);
        posestack.scale(64.0F, 64.0F, 64.0F);
        RenderSystem.applyModelViewMatrix();
        PoseStack posestack1 = new PoseStack();
        MultiBufferSource.BufferSource bufferSource = Minecraft.getInstance().renderBuffers().bufferSource();
        boolean flag = !bakedmodel.usesBlockLight();
        if (flag) Lighting.setupForFlatItems();

        itemRenderer.render(stack, ItemTransforms.TransformType.GUI, false, posestack1, bufferSource, 15728880, OverlayTexture.NO_OVERLAY, bakedmodel);
        bufferSource.endBatch();
        RenderSystem.enableDepthTest();
        if (flag) {
            Lighting.setupFor3DItems();
        }

        posestack.popPose();
        RenderSystem.applyModelViewMatrix();
    }

}
