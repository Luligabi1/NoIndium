package me.luligabi.noindium;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

@Environment(EnvType.CLIENT)
public class NoIndium implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
    }

    public static void openWarningScreen(MinecraftClient client) {
        if((HAS_SODIUM && CONFIG.showIndiumScreen) || (HAS_OPTIFABRIC && CONFIG.showOptifabricScreen)) {
            client.setScreen(new NoIndiumWarningScreen());
        }
    }


    private static ModConfig createConfig() {
        ModConfig finalConfig;
        LOGGER.info("Trying to read config file...");
        try {
            if(CONFIG_FILE.createNewFile()) {
                LOGGER.info("No config file found, creating a new one...");
                writeConfig(GSON.toJson(JsonParser.parseString(GSON.toJson(new ModConfig()))));
                finalConfig = new ModConfig();
                LOGGER.info("Successfully created default config file.");
            } else {
                LOGGER.info("A config file was found, loading it..");
                finalConfig = GSON.fromJson(new String(Files.readAllBytes(CONFIG_FILE.toPath())), ModConfig.class);
                if(finalConfig == null) {
                    throw new NullPointerException("The config file was empty.");
                } else {
                    LOGGER.info("Successfully loaded config file.");
                }
            }
        } catch(Exception e) {
            LOGGER.error("There was an error creating/loading the config file!", e);
            finalConfig = new ModConfig();
            LOGGER.warn("Defaulting to original config.");
        }
        return finalConfig;
    }

    public static void saveConfig(ModConfig modConfig) {
        try {
            writeConfig(GSON.toJson(JsonParser.parseString(GSON.toJson(modConfig))));
            LOGGER.info("Saved new config file.");
        } catch(Exception e) {
            LOGGER.error("There was an error saving the config file!", e);
        }
    }

    private static void writeConfig(String json) {
        try(PrintWriter printWriter = new PrintWriter(CONFIG_FILE)) {
            printWriter.write(json);
            printWriter.flush();
        } catch(IOException e) {
            LOGGER.error("Failed to write config file", e);
        }
    }

    public static final boolean HAS_SODIUM;
    public static final boolean HAS_OPTIFABRIC;

    public static final Logger LOGGER;

    private static final Gson GSON;
    private static final File CONFIG_FILE;
    public static final ModConfig CONFIG;


    static {
        HAS_SODIUM = (FabricLoader.getInstance().isModLoaded("sodium") && !FabricLoader.getInstance().isModLoaded("indium"));
        HAS_OPTIFABRIC = FabricLoader.getInstance().isModLoaded("optifabric");

        LOGGER = LoggerFactory.getLogger("No Indium?");

        GSON = new GsonBuilder().setPrettyPrinting().create();
        CONFIG_FILE = new File(String.format("%s%snoindium.json", FabricLoader.getInstance().getConfigDir(), File.separator));
        CONFIG = createConfig();
    }
}