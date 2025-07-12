package bhutracker.mixin.fermiummixins;

import bhutracker.BrokenHeartUndershirtTracker;
import com.llamalad7.mixinextras.sugar.Local;
import fermiummixins.handlers.bountifulbaubles.BrokenHeartBaubleHandler;
import ichttt.mods.firstaid.api.event.FirstAidLivingDamageEvent;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrokenHeartBaubleHandler.class)
public class BrokenHeartBaubleHandlerMixin {
    @Inject(
            method = "onFirstAidLivingDamageLow",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/EntityPlayer;DDDLnet/minecraft/util/SoundEvent;Lnet/minecraft/util/SoundCategory;FF)V")
    )
    private static void bhutracker_trackBrokenHeart(FirstAidLivingDamageEvent event, CallbackInfo ci, @Local EntityPlayer player) {
        player.addStat(BrokenHeartUndershirtTracker.BROKEN_HEART_ACTIVATED);
    }
}