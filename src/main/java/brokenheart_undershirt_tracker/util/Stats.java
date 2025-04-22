package brokenheart_undershirt_tracker.util;

import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatBasic;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class Stats {
    public static final StatBase BROKEN_HEART_ACTIVATED =
            new StatBasic(
                "stat.BROKEN_HEART_ACTIVATED",
                new TextComponentString(TextFormatting.DARK_RED+"Broken Heart Activated")
            ).registerStat();

    public static final StatBase UNDERSHIRT_ACTIVATED =
            new StatBasic(
                "stat.UNDERSHIRT_ACTIVATED",
                new TextComponentString(TextFormatting.AQUA + "Undershirt Activated")
            ).registerStat();
}
