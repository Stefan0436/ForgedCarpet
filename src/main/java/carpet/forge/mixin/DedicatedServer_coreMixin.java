package carpet.forge.mixin;

import carpet.forge.CarpetServer;
import net.minecraft.server.dedicated.DedicatedServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DedicatedServer.class)
public abstract class DedicatedServer_coreMixin
{
    @Inject(
            method = "init",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/server/dedicated/DedicatedServer;loadAllWorlds(Ljava/lang/String;Ljava/lang/String;JLnet/minecraft/world/WorldType;Ljava/lang/String;)V",
                    shift = At.Shift.BEFORE)
    )
    private void gameStartHook(CallbackInfoReturnable<Boolean> cir)
    {
        // [FCM] start game hook
        CarpetServer.onGameStarted();
    }

}
