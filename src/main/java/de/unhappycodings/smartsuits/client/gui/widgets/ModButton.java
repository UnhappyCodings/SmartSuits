package de.unhappycodings.smartsuits.client.gui.widgets;

import com.mojang.blaze3d.vertex.PoseStack;
import de.unhappycodings.smartsuits.client.gui.widgets.base.BaseWidget;
import de.unhappycodings.smartsuits.common.container.base.screen.BaseScreen;
import de.unhappycodings.smartsuits.common.util.GuiUtil;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.function.Supplier;

public class ModButton extends BaseWidget {
    private final Runnable onClick;
    private final Supplier<Boolean> isValid;
    private final ResourceLocation texture;
    boolean playSound;
    int tX = 0;
    int tY = 0;
    private Supplier<Component> hoverText;

    public ModButton(int x, int y, int width, int height, ResourceLocation texture, Runnable onClick, BaseScreen<?> screen, int tX, int tY, boolean playSound) {
        super(x, y, width, height, screen);
        this.onClick = onClick;
        this.isValid = () -> true;
        this.texture = texture;
        this.tX = tX;
        this.tY = tY;
        this.playSound = playSound;
    }

    public ModButton(int x, int y, int width, int height, ResourceLocation texture, Runnable onClick, BaseScreen<?> screen, int tX, int tY, boolean playSound, Supplier<Component> hoverText) {
        super(x, y, width, height, screen);
        this.onClick = onClick;
        this.isValid = () -> true;
        this.texture = texture;
        this.tX = tX;
        this.tY = tY;
        this.playSound = playSound;
        this.hoverText = hoverText;
    }

    @Override
    public void renderToolTip(@NotNull PoseStack matrixStack, int mouseX, int mouseY) {
        super.renderToolTip(matrixStack, mouseX, mouseY);
        if (hoverText != null && isMouseOver(mouseX, mouseY))
            renderComponentTooltip(matrixStack, Collections.singletonList(hoverText.get()), mouseX, mouseY);
    }

    @Override
    public void onClick(double pMouseX, double pMouseY) {
        if (isMouseOver(pMouseX, pMouseY)) {
            if (isValid != null && isValid.get() && onClick != null) {
                onClick.run();
                playDownSound(minecraft.getSoundManager());
            }
        }
        super.onClick(pMouseX, pMouseY);
    }

    @Override
    public void render(@NotNull PoseStack matrixStack, int x, int y, float partialTicks) {
        super.render(matrixStack, x, y, partialTicks);
        GuiUtil.bind(texture);

        if (!isMouseOver(x, y) || (isValid != null && !isValid.get()))
            blit(matrixStack, this.x, this.y, 0, 0, width, height, tX, tY);
        if (isMouseOver(x, y) && (isValid != null && isValid.get()))
            blit(matrixStack, this.x, this.y, 0, tY / 2f, width, height, tX, tY);
    }

    @Override
    public void updateNarration(@NotNull NarrationElementOutput pNarrationElementOutput) {
        // overridden by purpose
    }

    @Override
    public void playDownSound(@NotNull SoundManager pHandler) {
        if (playSound)
            super.playDownSound(pHandler);
    }
}
