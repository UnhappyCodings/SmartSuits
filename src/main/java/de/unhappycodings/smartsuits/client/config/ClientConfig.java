package de.unhappycodings.smartsuits.client.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import de.unhappycodings.smartsuits.common.enums.SuitTypeEnum;
import de.unhappycodings.smartsuits.common.enums.SuitTypeItemEnum;
import net.minecraftforge.common.ForgeConfigSpec;

import java.io.File;

public class ClientConfig {
    public static ForgeConfigSpec clientConfig;
    public static ForgeConfigSpec.EnumValue<SuitTypeEnum> smartSuitEditorSelection;

    static {
        ForgeConfigSpec.Builder clientBuilder = new ForgeConfigSpec.Builder();

        init(clientBuilder);
        clientConfig = clientBuilder.build();
    }

    private static void init(ForgeConfigSpec.Builder clientBuilder) {
        clientBuilder.push("General");
        smartSuitEditorSelection = clientBuilder.comment("Current Selected Mode.")
                .defineEnum("smart_suit_editor_selection", SuitTypeEnum.HELMET);
        clientBuilder.pop();
    }

    public static void loadConfigFile(ForgeConfigSpec config, String path) {
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        file.load();
        config.setConfig(file);
    }
}
