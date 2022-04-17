package me.luligabi.noindium.hook;

import me.luligabi.noindium.NoIndiumWarningScreen;
import net.minecraft.client.MinecraftClient;

public class TitleScreenHook {

    public static void tick() {
        if(hasOpenedOnThisInstance) return;
        MinecraftClient.getInstance().setScreen(new NoIndiumWarningScreen(null));
        hasOpenedOnThisInstance = true;
    }

    private static boolean hasOpenedOnThisInstance = false;

}