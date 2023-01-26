package de.unhappycodings.smartsuits.common.container;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import de.unhappycodings.smartsuits.SmartSuits;
import de.unhappycodings.smartsuits.common.container.base.screen.BaseScreen;
import de.unhappycodings.smartsuits.common.enums.SuitTypeEnum;
import de.unhappycodings.smartsuits.common.registration.ModItems;
import de.unhappycodings.smartsuits.common.util.GuiUtil;
import de.unhappycodings.smartsuits.common.util.RenderUtil;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SmartSuitEditorScreen extends BaseScreen<SmartSuitEditorContainer> {
    SmartSuitEditorContainer container;
    private SuitTypeEnum selection = SuitTypeEnum.HELMET;

    public SmartSuitEditorScreen(SmartSuitEditorContainer screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn);
        this.container = screenContainer;
    }

    @Override
    protected void renderLabels(@NotNull PoseStack pPoseStack, int pMouseX, int pMouseY) {
        // Texts
        RenderUtil.drawCenteredText(new TextComponent("Smart Suit").getString(), pPoseStack, getSizeX() / 2, 7);
        RenderUtil.drawCenteredText(new TextComponent("Helmet").getString(), pPoseStack, getSizeX() / 2, 18);
        RenderUtil.drawCenteredText(new TextComponent("Modules").getString(), pPoseStack, getSizeX() / 2, 38);
        RenderUtil.drawCenteredText(new TextComponent("Settings").getString(), pPoseStack, getSizeX() / 2, 117);
        RenderUtil.drawText(new TextComponent("Inventory").getString(), pPoseStack, 8, 152);
        RenderUtil.drawCenteredText(new TextComponent("Preview").getText(), pPoseStack, -50, 21, 16777215);

        // Helmet Slots
        blit(pPoseStack, 59, 51, 238, 18, 18, 18);

    }

    @Override
    protected void renderBg(@NotNull PoseStack matrixStack, float partialTicks, int x, int y) {
        super.renderBg(matrixStack, partialTicks, x, y);

        // Left Preview Window
        blit(matrixStack, getGuiLeft() - 5, getGuiTop() + 11, 251, 107, 5, 149);
        for (int i = 1; i < 10; i++) blit(matrixStack, getGuiLeft() - (105 - (i * 10)), getGuiTop() + 11, 239, 107, 10, 149);
        blit(matrixStack, getGuiLeft() - 99, getGuiTop() + 11, 235, 107, 5, 149);

        // Right Settings
        blit(matrixStack, getGuiLeft() + 176, getGuiTop() + 11, 214, 156, 21, 21);

        // Items
        renderArmorPiece(matrixStack, new ItemStack(selection.getItem()), getGuiLeft() + 57, getGuiTop() + 48, false);

        // Player In Preview
        InventoryScreen.renderEntityInInventory(getGuiLeft() - 50, getGuiTop() + 145, 55, 0, 0, getMinecraft().player);

    }

    @Override
    protected void init() {
        addButtons();
        super.init();
    }

    protected void addButtons() {

    }

    public void renderArmorPiece(PoseStack stack, ItemStack item, int x, int y, boolean normal) {
        stack.pushPose();
        RenderUtil.renderGuiItem(item, x, y);
        RenderSystem.setShaderTexture(0, normal ? SmartSuits.BLANK : SmartSuits.GHOST_OVERLAY);
        RenderSystem.setShaderColor(1, 1, 1, 0.65f);
        RenderSystem.enableBlend();
        RenderSystem.disableDepthTest();
        GuiComponent.blit(stack, x, y, 0, 0, 64, 64, 16, 16);
        RenderSystem.disableBlend();
        RenderSystem.enableDepthTest();
        GuiUtil.reset();
        stack.popPose();
    }

    @Override
    public int getSizeX() {
        return 176;
    }

    @Override
    public int getSizeY() {
        return 244;
    }

    @Override
    public ResourceLocation getTexture() {
        return new ResourceLocation(SmartSuits.MOD_ID, "textures/gui/smart_suit_editor_gui.png");
    }

}
