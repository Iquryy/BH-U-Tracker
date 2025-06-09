package bhutracker;

import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatBasic;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = BrokenHeartUndershirtTracker.MODID,
        version = BrokenHeartUndershirtTracker.VERSION,
        name = BrokenHeartUndershirtTracker.NAME,
        dependencies = "required-after:fermiumbooter",
        acceptableRemoteVersions = "*"
)
public class BrokenHeartUndershirtTracker {
    public static final String MODID = "bhutracker";
    public static final String VERSION = "1.0.3";
    public static final String NAME = "Broken Heart & Undershirt Stat";

    public static StatBase UNDERSHIRT_ACTIVATED = (new StatBasic("stat.undershirt_activated", new TextComponentTranslation(TextFormatting.AQUA + "Undershirt Activated"))).registerStat();
    public static StatBase BROKEN_HEART_ACTIVATED = (new StatBasic("stat.brokenheart_activated", new TextComponentTranslation(TextFormatting.DARK_RED + "Broken Heart Activated"))).registerStat();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        //needed to load this class for some reason
    }
}
