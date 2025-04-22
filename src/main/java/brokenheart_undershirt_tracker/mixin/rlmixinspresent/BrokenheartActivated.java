package brokenheart_undershirt_tracker.mixin.rlmixinspresent;

import brokenheart_undershirt_tracker.util.Stats;
import ichttt.mods.firstaid.api.event.FirstAidLivingDamageEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rlmixins.handlers.bountifulbaubles.BrokenHeartBaubleHandler;

@Mixin(BrokenHeartBaubleHandler.class)
public abstract class BrokenheartActivated {
    @Inject(
            method = "onFirstAidLivingDamageLow",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/EntityPlayer;DDDLnet/minecraft/util/SoundEvent;Lnet/minecraft/util/SoundCategory;FF)V")
    )
    private static void trackBrokenHeartActivations(FirstAidLivingDamageEvent event, CallbackInfo ci) {
        event.getEntityPlayer().addStat(Stats.BROKEN_HEART_ACTIVATED);
    }
}