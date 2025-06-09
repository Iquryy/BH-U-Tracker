package bhutracker.mixin.base;

import bhutracker.BrokenHeartUndershirtTracker;
import codersafterdark.reskillable.skill.defense.TraitUndershirt;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TraitUndershirt.class)
public class TraitUndershirtMixin {

    @Inject(
            method = "onHurt",
            at = @At(value = "INVOKE", target = "Lnet/minecraftforge/event/entity/living/LivingHurtEvent;setAmount(F)V"),
            remap = false
    )
    public void bhutracker_trackUndershirt(LivingHurtEvent event, CallbackInfo ci, @Local EntityLivingBase entity) {
        if (entity instanceof EntityPlayer)
            ((EntityPlayer) entity).addStat(BrokenHeartUndershirtTracker.UNDERSHIRT_ACTIVATED);
    }
}