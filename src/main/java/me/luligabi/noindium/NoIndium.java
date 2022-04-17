package me.luligabi.noindium;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;

@Environment(EnvType.CLIENT)
public class NoIndium implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
            if(HAS_SODIUM || HAS_OPTIFABRIC) {
                MinecraftClient.getInstance().setScreen(new NoIndiumWarningScreen());
            }
        });
    }

    public static final boolean HAS_SODIUM = (FabricLoader.getInstance().isModLoaded("sodium") && !FabricLoader.getInstance().isModLoaded("indium"));
    public static final boolean HAS_OPTIFABRIC = FabricLoader.getInstance().isModLoaded("optifabric");

}