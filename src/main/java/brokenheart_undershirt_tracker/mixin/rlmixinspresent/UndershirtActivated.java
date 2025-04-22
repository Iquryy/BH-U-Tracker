package brokenheart_undershirt_tracker.mixin.rlmixinspresent;

import brokenheart_undershirt_tracker.util.Stats;
import ichttt.mods.firstaid.api.event.FirstAidLivingDamageEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rlmixins.handlers.reskillable.UndershirtHandler;

@Mixin(UndershirtHandler.class)
public abstract class UndershirtActivated {
    @Inject(
            method = "onFirstAidLivingDamageHigh",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/EntityPlayer;DDDLnet/minecraft/util/SoundEvent;Lnet/minecraft/util/SoundCategory;FF)V")
    )
    private static void trackUndershirtActivations(FirstAidLivingDamageEvent event, CallbackInfo ci) {
        event.getEntityPlayer().addStat(Stats.UNDERSHIRT_ACTIVATED);
    }
}