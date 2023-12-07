package me.luligabi.noindium.mixin;

import me.luligabi.noindium.NoIndium;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
 * Responsible for triggering the warning screen, since the old event-based method
 * no longer works. Note this has a slightly higher than normal priority
 * to ensure the warning screen is triggered before modifications
 * made to the actual title screen; if this is causing issues to your mod, please
 * contact me through an issue on the repository.
 */
@Mixin(
    value = TitleScreen.class,
    priority = 950
)
public abstract class TitleScreenMixin {

    @Inject(
        method = "init",
        at = @At("HEAD")
    )
    public void init(CallbackInfo ci) {
        TitleScreen titleScreen = ((TitleScreen) (Object) this);
        if(((TitleScreenAccessor) titleScreen).doBackgroundFade()) {
            NoIndium.openWarningScreen(((ScreenAccessor) titleScreen).getClient());
        }
    }

}