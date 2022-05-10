package com.github.alexthe666.iceandfire.misc;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;

public class IafDamageRegistry {
    public static final String GORGON_DMG_TYPE = "gorgon";
    public static final String DRAGON_FIRE_TYPE = "dragon_fire";
    public static final String DRAGON_ICE_TYPE = "dragon_ice";
    public static final String DRAGON_LIGHTNING_TYPE = "dragon_lightning";

    static class CustomEntityDamageSource extends EntityDamageSource {
        public CustomEntityDamageSource(String damageTypeIn, @Nullable Entity damageSourceEntityIn) {
            super(damageTypeIn, damageSourceEntityIn);
        }

        public ITextComponent getDeathMessage(LivingEntity entityLivingBaseIn) {
            LivingEntity livingentity = entityLivingBaseIn.getAttackingEntity();
            String s = "death.attack." + this.damageType;
            int index = entityLivingBaseIn.getRNG().nextInt(2);
            String s1 = s + "." + index;
            String s2 = s + ".attacker_" + index;
            return livingentity != null ? new TranslationTextComponent(s2, entityLivingBaseIn.getDisplayName(), livingentity.getDisplayName()) : new TranslationTextComponent(s1, entityLivingBaseIn.getDisplayName());
        }
    }

    public static CustomEntityDamageSource causeGorgonDamage(@Nullable Entity entity) {
        return new CustomEntityDamageSource(GORGON_DMG_TYPE, entity);
    }

    public static CustomEntityDamageSource causeDragonFireDamage(@Nullable Entity entity) {
        return new CustomEntityDamageSource(DRAGON_FIRE_TYPE, entity);
    }

    public static CustomEntityDamageSource causeDragonIceDamage(@Nullable Entity entity) {
        return new CustomEntityDamageSource(DRAGON_ICE_TYPE, entity);
    }

    public static CustomEntityDamageSource causeDragonLightningDamage(@Nullable Entity entity) {
        return new CustomEntityDamageSource(DRAGON_LIGHTNING_TYPE, entity);
    }
}
