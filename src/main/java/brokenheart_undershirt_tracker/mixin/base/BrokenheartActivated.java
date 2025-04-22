package brokenheart_undershirt_tracker.mixin.base;

import brokenheart_undershirt_tracker.util.Stats;
import com.llamalad7.mixinextras.sugar.Local;
import cursedflames.bountifulbaubles.item.ItemTrinketBrokenHeart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemTrinketBrokenHeart.class)
public abstract class BrokenheartActivated {
    @Inject(
            method = "onDamage",
            at = @At(value = "INVOKE", target = "Lnet/minecraftforge/event/entity/living/LivingDamageEvent;setAmount(F)V"),
            remap = false
    )
    private static void trackBrokenHeartActivations(LivingDamageEvent event, CallbackInfo ci, @Local EntityPlayer player) {
        player.addStat(Stats.BROKEN_HEART_ACTIVATED);
    }
}