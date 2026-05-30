package com.pekar.safeleash.events;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;

public final class LivingEntityEvents
{
    private LivingEntityEvents()
    {
    }

    public static void register()
    {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
            if (entity instanceof Mob mob && mob.isLeashed() && source.is(DamageTypes.DROWN))
            {
                mob.dropLeash();
                mob.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200));
                return false;
            }

            return true;
        });
    }
}
