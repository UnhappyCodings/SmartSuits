package de.unhappycodings.smartsuits.common.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.io.File;

public class CommonConfig {
    public static ForgeConfigSpec commonConfig;
    public static ForgeConfigSpec.BooleanValue smartSuitEnabled;

    static {
        ForgeConfigSpec.Builder commonBuilder = new ForgeConfigSpec.Builder();

        init(commonBuilder);
        commonConfig = commonBuilder.build();
    }

    private static void init(ForgeConfigSpec.Builder commonBuilder) {
        commonBuilder.push("General");
        smartSuitEnabled = commonBuilder.comment("Disables the Smart Suit functionality and Editor")
                .define("smart_suit_enabled", true);

        commonBuilder.pop();
    }

    public static void loadConfigFile(ForgeConfigSpec config, String path) {
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        file.load();
        config.setConfig(file);
    }

}
