package carpet.forge.helper;

import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSaplingHelper
{
    // Added code for checking water for dead shrub rule
    public static boolean hasWater(World worldIn, BlockPos pos)
    {
        for (BlockPos.MutableBlockPos blockpos_mutableblockpos : BlockPos.getAllInBoxMutable(pos.add(-4, -4, -4), pos.add(4, 1, 4)))
        {
            if (worldIn.getBlockState(blockpos_mutableblockpos).getMaterial() == Material.WATER)
            {
                return true;
            }
        }

        return false;
    }
}
