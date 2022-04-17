package me.luligabi.noindium;


import draylar.omegaconfig.api.Comment;
import draylar.omegaconfig.api.Config;

public class ModConfig implements Config {

    @Comment(value = "Whether the 'missing indium' screen can show up. This config value is set to false if the user uses the checkbox.")
    public boolean showIndiumScreen = true;

    @Comment(value = "Whether the 'remove optifabric' screen can show up. This config value is set to false if the user uses the checkbox.")
    public boolean showOptifabricScreen = true;

    @Comment(value = "Allow the user to proceed to the Title Screen even if one of the screens shows up. Setting this to false also removes the checkbox.")
    public boolean allowToProceed = true;

    @Override
    public String getName() { return "noindium"; }
}
