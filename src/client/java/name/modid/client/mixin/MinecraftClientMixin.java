package name.modid.client.mixin;

import name.modid.NoBlockDelay;
import name.modid.client.NoBlockDelayConfig;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
    @Shadow
    private int itemUseCooldown;

    @Inject(method = "handleInputEvents", at = @At("HEAD"))
    private void resetItemUseCooldown(CallbackInfo ci) {
        if (NoBlockDelayConfig.get().enabled) {
            this.itemUseCooldown = 0;
        }
    }
}
