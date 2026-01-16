package com.zephyrx0.mod.mixin;

import net.minecraft.entity.ItemEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {

    @Inject(method = "tick", at = @At("TAIL"))
    private void itemsink$onTick(CallbackInfo ci) {
        ItemEntity item = (ItemEntity) (Object) this;

        // Only care about water
        if (!item.isTouchingWater()) return;

        // Get item ID safely
        Identifier id = Registries.ITEM.getId(item.getStack().getItem());

        // Change this later to FD rice panicles
        if (!id.toString().equals("minecraft:apple")) return;

        // Apply gentle sinking
        Vec3d v = item.getVelocity();
        item.setVelocity(v.x, Math.min(v.y - 0.03, -0.08), v.z);
    }
}
