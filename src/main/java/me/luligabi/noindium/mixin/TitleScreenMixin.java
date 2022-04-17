package me.luligabi.noindium.mixin;

import me.luligabi.noindium.hook.TitleScreenHook;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {

    @Inject(method = "tick", at = @At("RETURN"))
    public void noindium_tick(CallbackInfo ci) {
        TitleScreenHook.tick();
    }

}
