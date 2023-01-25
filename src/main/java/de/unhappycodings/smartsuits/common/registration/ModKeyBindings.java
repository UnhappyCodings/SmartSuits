package de.unhappycodings.smartsuits.common.registration;

import com.mojang.blaze3d.platform.InputConstants;
import de.unhappycodings.smartsuits.SmartSuits;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import org.lwjgl.glfw.GLFW;

public class ModKeyBindings {

    public static final KeyMapping OPEN_EDITOR =
            new KeyMapping("keybind." + SmartSuits.MOD_ID + ".open_editor_keybind", KeyConflictContext.IN_GAME, KeyModifier.NONE, InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_MOUSE_BUTTON_5), "keybind." + SmartSuits.MOD_ID + ".category");

}
