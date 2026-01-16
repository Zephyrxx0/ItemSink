package com.zephyrx0.mod.mixin;

import net.minecraft.entity.ItemEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {

    private static final Identifier SINK_ITEM =
            Identifier.of("minecraft", "apple");

    @Inject(method = "tick", at = @At("TAIL"))
    private void itemsink$tick(CallbackInfo ci) {
        ItemEntity item = (ItemEntity) (Object) this;

        if (item.getWorld().isClient()) return;
        if (!item.isTouchingWater()) return;

        if (!Registries.ITEM.getId(item.getStack().getItem()).equals(SINK_ITEM)) return;
        if (item.getVelocity().y < 0) return;

        item.addVelocity(0.0, -0.03, 0.0);
    }
}
