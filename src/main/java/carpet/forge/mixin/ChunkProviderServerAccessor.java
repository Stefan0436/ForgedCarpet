package carpet.forge.mixin;

import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkProviderServer;

import java.util.Set;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;

@Mixin(ChunkProviderServer.class)
public interface ChunkProviderServerAccessor
{
    @Accessor("droppedChunksSet")
    Set<Long> getDroppedChunks();

    @Accessor("id2ChunkMap")
    // Stefan0436: added a way to get the chunk list as Long2ObjectMap
    Long2ObjectMap<Chunk> getLoadedChunksC();
}
