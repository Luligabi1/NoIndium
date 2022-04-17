package me.luligabi.noindium;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.WarningScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;

@Environment(EnvType.CLIENT)
public class NoIndiumWarningScreen extends WarningScreen {

    private static final Text HEADER = new TranslatableText("noindium.header").formatted(Formatting.BOLD);
    private static final Text MESSAGE = new TranslatableText("noindium.message");
    private static final Text CHECK_MESSAGE = new TranslatableText("multiplayerWarning.check");
    private static final Text NARRATED_TEXT = HEADER.shallowCopy().append("\n").append(MESSAGE);

    public NoIndiumWarningScreen(Screen parent) {super(HEADER, MESSAGE, CHECK_MESSAGE, NARRATED_TEXT, parent);}

    @Override
    protected void initButtons(int yOffset) {
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 155, 100 + yOffset, 150, 20, new LiteralText("CurseForge"), buttonWidget -> Util.getOperatingSystem().open("https://www.curseforge.com/minecraft/mc-mods/indium")));
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 155 + 160, 100 + yOffset, 150, 20, new LiteralText("Modrinth"), buttonWidget -> Util.getOperatingSystem().open("https://modrinth.com/mod/indium")));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 75, 130 + yOffset, 150, 20, new TranslatableText("gui.ok"), buttonWidget ->  {
            /*if(this.checkbox.isChecked()) {
                this.client.options.skipMultiplayerWarning = true;
                this.client.options.write();
            }*/
            this.client.setScreen(new TitleScreen(false));
        }));
    }

    @Override public boolean shouldCloseOnEsc() {return false;}
}