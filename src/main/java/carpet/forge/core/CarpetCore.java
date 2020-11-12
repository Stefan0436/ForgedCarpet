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
    	PrioritizeCarpet(); // Give carpet priority in the classpath, but load sponge first if installed
    	MixinLoad(); // Load mixins
    }
    
    static void MixinLoad() {
    	MixinBootstrap.init();
    	CarpetConfig config = new CarpetConfig();
        
        Mixins.addConfiguration("mixins.forgedcarpet.json");
        Mixins.addConfiguration("mixins.carpet.logging.json");
        
    	if (config.getFastRedstoneDust())
            Mixins.addConfiguration("mixins.carpet.fastdust.json");
        if (config.getNewLight())
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
    
    static void PrioritizeCarpet() {
    	
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
