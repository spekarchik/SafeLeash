package com.pekar.safeleash.events;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

public class LivingEntityEvents implements IEventHandler
{
    @SubscribeEvent
    public void onLivingDamage(LivingDamageEvent.Pre event)
    {
        if (event.getEntity() instanceof Mob mob && event.getSource() == mob.damageSources().drown())
        {
            if (mob.isLeashed())
            {
                mob.dropLeash();
                mob.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200));
            }
        }
    }
}
