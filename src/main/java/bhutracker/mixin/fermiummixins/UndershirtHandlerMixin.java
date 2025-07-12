package bhutracker.mixin.fermiummixins;

import bhutracker.BrokenHeartUndershirtTracker;
import fermiummixins.handlers.reskillable.UndershirtHandler;
import ichttt.mods.firstaid.api.event.FirstAidLivingDamageEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(UndershirtHandler.class)
public class UndershirtHandlerMixin {
    @Inject(
            method = "onFirstAidLivingDamageHigh",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/EntityPlayer;DDDLnet/minecraft/util/SoundEvent;Lnet/minecraft/util/SoundCategory;FF)V")
    )
    private static void bhutracker_trackUndershirt(FirstAidLivingDamageEvent event, CallbackInfo ci) {
        event.getEntityPlayer().addStat(BrokenHeartUndershirtTracker.UNDERSHIRT_ACTIVATED);
    }
}