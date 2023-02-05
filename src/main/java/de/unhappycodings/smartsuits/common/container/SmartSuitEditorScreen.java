package de.unhappycodings.smartsuits.common.container;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import de.unhappycodings.smartsuits.SmartSuits;
import de.unhappycodings.smartsuits.client.config.ClientConfig;
import de.unhappycodings.smartsuits.client.gui.widgets.ModButton;
import de.unhappycodings.smartsuits.common.container.base.screen.BaseScreen;
import de.unhappycodings.smartsuits.common.enums.SuitTypeEnum;
import de.unhappycodings.smartsuits.common.enums.SuitTypeItemEnum;
import de.unhappycodings.smartsuits.common.registration.ModItems;
import de.unhappycodings.smartsuits.common.util.EnumUtil;
import de.unhappycodings.smartsuits.common.util.RenderUtil;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SmartSuitEditorScreen extends BaseScreen<SmartSuitEditorContainer> {
    private final SmartSuitEditorContainer container;
    public SuitTypeItemEnum selection;

    public SmartSuitEditorScreen(SmartSuitEditorContainer screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn);
        this.container = screenContainer;
        this.selection = EnumUtil.getItemEnum(ClientConfig.smartSuitEditorSelection.get());
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
    }

    @Override
    protected void renderBg(@NotNull PoseStack matrixStack, float partialTicks, int x, int y) {
        super.renderBg(matrixStack, partialTicks, x, y);
        this.selection = EnumUtil.getItemEnum(ClientConfig.smartSuitEditorSelection.get());

        // Left Preview Window
        blit(matrixStack, getGuiLeft() - 5, getGuiTop() + 11, 251, 107, 5, 149);
        for (int i = 1; i < 10; i++) blit(matrixStack, getGuiLeft() - (105 - (i * 10)), getGuiTop() + 11, 239, 107, 10, 149);
        blit(matrixStack, getGuiLeft() - 99, getGuiTop() + 11, 235, 107, 5, 149);

        // Right Settings
        blit(matrixStack, getGuiLeft() + 176, getGuiTop() + 11, 214, 156, 21, 21);

        // Armor Piece
        renderArmorPiece(matrixStack, new ItemStack(selection.getItem()), getGuiLeft() + 57, getGuiTop() + 48,
                this.getMinecraft().player.getItemBySlot(EnumUtil.getEquipSlot(selection)).is(selection.getItem()));

        // Reset Rendering
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, getTexture());
        RenderSystem.disableDepthTest();

        // Slots
        renderModuleSlots(matrixStack);

        // Player In Preview
        InventoryScreen.renderEntityInInventory(getGuiLeft() - 50, getGuiTop() + 145, 55, 0, 0, getMinecraft().player);

    }

    public void renderModuleSlots(PoseStack matrixStack) {
        int offset = this.getMinecraft().player.getItemBySlot(EnumUtil.getEquipSlot(selection)).is(selection.getItem()) ? 0 : 18;
        switch (selection) {
            case HELMET -> {
                blit(matrixStack, getGuiLeft() + 60, getGuiTop() + 71, 238, offset, 18, 18);
                blit(matrixStack, getGuiLeft() + 80, getGuiTop() + 56, 238, offset, 18, 18);
                blit(matrixStack, getGuiLeft() + 100, getGuiTop() + 71, 238, offset, 18, 18);
            }
            case CHESTPLATE -> {
                blit(matrixStack, getGuiLeft() + 59, getGuiTop() + 54, 238, offset, 18, 18);
                blit(matrixStack, getGuiLeft() + 102, getGuiTop() + 54, 238, offset, 18, 18);
                blit(matrixStack, getGuiLeft() + 80, getGuiTop() + 74, 238, offset, 18, 18);
                blit(matrixStack, getGuiLeft() + 80, getGuiTop() + 95, 238, offset, 18, 18);
            }
            case LEGGINGS, BOOTS -> {
                blit(matrixStack, getGuiLeft() + 64, getGuiTop() + 74, 238, offset, 18, 18);
                blit(matrixStack, getGuiLeft() + 80, getGuiTop() + 53, 238, offset, 18, 18);
                blit(matrixStack, getGuiLeft() + 96, getGuiTop() + 74, 238, offset, 18, 18);
            }
        }
    }

    @Override
    protected void init() {
        super.init();
        addButtons();
    }

    protected void addButtons() {
        addRenderableWidget(new ModButton(9, 43, 20, 20, SmartSuits.HELMET_NORMAL, () -> setSelection(SuitTypeEnum.HELMET), this, 20, 40, true));
        addRenderableWidget(new ModButton(9, 70, 20, 20, SmartSuits.CHESTPLATE_NORMAL, () -> setSelection(SuitTypeEnum.CHESTPLATE), this, 20, 40, true));
        addRenderableWidget(new ModButton(9, 97, 20, 20, SmartSuits.LEGGINGS_NORMAL, () -> setSelection(SuitTypeEnum.LEGGINGS), this, 20, 40, true));
        addRenderableWidget(new ModButton(9, 124, 20, 20, SmartSuits.BOOTS_NORMAL, () -> setSelection(SuitTypeEnum.BOOTS), this, 20, 40, true));
    }

    private void setSelection(SuitTypeEnum selection) {
        ClientConfig.smartSuitEditorSelection.set(selection);
    }

    public void renderArmorPiece(PoseStack stack, ItemStack item, int x, int y, boolean normal) {
        stack.pushPose();
        RenderUtil.renderGuiItem(item, x, y);
        RenderSystem.setShaderTexture(0, normal ? SmartSuits.BLANK : SmartSuits.GHOST_OVERLAY);
        RenderSystem.setShaderColor(1, 1, 1, 0.65f);
        RenderSystem.enableBlend();
        RenderSystem.disableDepthTest();
        blit(stack, x, y, 0, 0, 64, 64, 16, 16);
        RenderSystem.disableBlend();
        RenderSystem.enableDepthTest();
        RenderSystem.setShaderColor(1, 1, 1, 1f);
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
