package de.unhappycodings.smartsuits.common.container;

import com.mojang.blaze3d.vertex.PoseStack;
import de.unhappycodings.smartsuits.SmartSuits;
import de.unhappycodings.smartsuits.common.container.base.screen.BaseScreen;
import de.unhappycodings.smartsuits.common.util.RenderUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class SmartSuitEditorScreen extends BaseScreen<SmartSuitEditorContainer> {
    SmartSuitEditorContainer container;

    public SmartSuitEditorScreen(SmartSuitEditorContainer screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn);
        this.container = screenContainer;
    }

    @Override
    protected void renderLabels(@NotNull PoseStack pPoseStack, int pMouseX, int pMouseY) {
        RenderUtil.drawCenteredText(new TextComponent("Thorium Crafting").getString(), pPoseStack, 163, 7);
        RenderUtil.drawText(new TextComponent("Inventory").getString(), pPoseStack, 106, 164);
    }

    @Override
    public int getSizeX() {
        return 274;
    }

    @Override
    public int getSizeY() {
        return 256;
    }

    @Override
    public ResourceLocation getTexture() {
        return new ResourceLocation(SmartSuits.MOD_ID, "textures/gui/smart_suit_editor_gui.png");
    }

}
