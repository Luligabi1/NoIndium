-keep, includedescriptorclasses class me.luligabi.noindium.** { *; }
-keepattributes *Annotation*
-dontwarn org.jetbrains.annotations.**

-dontobfuscate

-optimizations library/*, class/unboxing/*, class/merging/*, field/removal/*, method/propagation/*, method/inlining/*, code/merging, code/simplification/*, code/removal/variable, code/removal/exception