package net.modekh.beavercurve.config;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.Animal;

public enum EntityClass {
    ANIMAL(Animal.class),
    MOB(Mob.class),
    LIVING_ENTITY(LivingEntity.class),
    ENTITY(Entity.class);

    private final Class<? extends Entity> entityClass;

    EntityClass(Class<? extends Entity> entityClass) {
        this.entityClass = entityClass;
    }

    public Class<? extends Entity> get() {
        return entityClass;
    }

    public static Class<? extends Entity> getByConfig(EntityClass configEntityClass) {
        for (EntityClass entityClass : EntityClass.values()) {
            if (entityClass.equals(configEntityClass)) {
                return entityClass.get();
            }
        }

        return MOB.get();
    }
}
