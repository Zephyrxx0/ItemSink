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

    // Cached target item ID (change later to farmersdelight:rice_panicles)
    private static final Identifier SINK_ITEM =
            Identifier.of("farmersdelight", "rice_panicle");

    @Inject(method = "tick", at = @At("TAIL"))
    private void itemsink$tick(CallbackInfo ci) {
        ItemEntity item = (ItemEntity) (Object) this;

        // Server-side only
        if (item.getWorld().isClient()) return;

        // Must be touching water
        if (!item.isTouchingWater()) return;

        // Must be the correct item
        if (!Registries.ITEM.getId(item.getStack().getItem()).equals(SINK_ITEM)) return;

        // Already sinking? Don't fight physics
        if (item.getVelocity().y < 0) return;

        // Apply gentle downward force
        item.addVelocity(0.0, -0.03, 0.0);
    }
}
