package com.sammy.malum.core.setup;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.Entity;

public class DamageSourceRegistry {

    public static final DamageSource VOODOO = new DamageSource("voodoo").setMagic();
    public static final DamageSource VOODOO_NO_SHATTER = new DamageSource("no_shatter_voodoo").setMagic();
    public static final DamageSource FORCED_SHATTER = new DamageSource("forced_shatter").setMagic().bypassArmor().bypassMagic();

    public static DamageSource causeVoodooDamage(Entity attacker) {
        return new EntityDamageSource("voodoo", attacker).setMagic();
    }
    public static DamageSource causeMagebaneDamage(Entity attacker) {
        return new EntityDamageSource("magebane", attacker).setThorns().setMagic();
    }
}