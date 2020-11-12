package carpet.forge.core;

import carpet.forge.config.CarpetConfig;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.io.File;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion("@MCVER@")
@IFMLLoadingPlugin.SortingIndex(Integer.MIN_VALUE + 1000)
@IFMLLoadingPlugin.TransformerExclusions("carpet.forge.core.CarpetCore")
public class CarpetCore implements IFMLLoadingPlugin
{
    private static File minecraftDir;
    
    public CarpetCore() {
    	// Stefan0436: Cleaned methods, added prioritize function for making carpet load first (sponge will load before carpet if it is installed)
    	
    	PrioritizeCarpet(); // Stefan0436: Prioritize carpet, but load sponge first if installed
    	MixinLoad(); // Stefan0436: Load mixins
    	
    	// Stefan0436:
    	// Inspired by VanillaFIX, source: https://github.com/DimensionalDevelopment/VanillaFix/blob/51790666e0390204cd93e3543d75535564af51cf/src/main/java/org/dimdev/vanillafix/VanillaFixLoadingPlugin.java#L171
    	// Note: PrioritizeCarpet was inspired by VanillaFIX, the here code is my own (and parts of the original ForgedCarpet project)
    }
    
    static void MixinLoad() { // Stefan0436: Mixin loading function, all code for mixin is here
    	MixinBootstrap.init();
        
        Mixins.addConfiguration("mixins.forgedcarpet.json");
        Mixins.addConfiguration("mixins.carpet.logging.json");
        
    	// Stefan0436: I am confused, the carpet config file (in the config directory) looks like it is ignored...
        // The config file WAS used by the following mixins, but the if statements were disabled.
        // 
        Mixins.addConfiguration("mixins.carpet.fastdust.json");
        Mixins.addConfiguration("mixins.carpet.newlight.json");
        
        try
        {
            Class.forName("com.mumfrey.liteloader.LiteMod");
            Mixins.addConfiguration("mixins.carpet.liteloader.json");
        }
        catch (ClassNotFoundException e)
        {
            Mixins.addConfiguration("mixins.carpet.forge.json");
        }
    }
    
    static void PrioritizeCarpet() { // Stefan0436: Give carpet (or sponge) priority in the classpath
    	//TODO
    }
    
    public static File getMinecraftDir()
    {
        return minecraftDir;
    }
    
    @Override
    public String[] getASMTransformerClass()
    {
        return new String[]{
        
        };
    }
    
    @Override
    public String getModContainerClass()
    {
        return null;
    }
    
    @Nullable
    @Override
    public String getSetupClass()
    {
        return null;
    }
    
    @Override
    public void injectData(Map<String, Object> data)
    {
        minecraftDir = (File) data.get("mcLocation");
    }
    
    @Override
    public String getAccessTransformerClass()
    {
        return null;
    }
}
