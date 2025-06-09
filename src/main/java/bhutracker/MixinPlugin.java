package bhutracker;

import java.util.Map;
import fermiumbooter.FermiumRegistryAPI;
import net.minecraftforge.fml.common.Loader;
import org.spongepowered.asm.launch.MixinBootstrap;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.MCVersion("1.12.2")
public class MixinPlugin implements IFMLLoadingPlugin {

	public MixinPlugin() {
		MixinBootstrap.init();

		FermiumRegistryAPI.enqueueMixin(true, "mixins.bhutracker.base.json", () -> !Loader.isModLoaded("rlmixins"));
		FermiumRegistryAPI.enqueueMixin(true, "mixins.bhutracker.rlmixins.json", () -> Loader.isModLoaded("rlmixins"));
	}

	@Override
	public String[] getASMTransformerClass()
	{
		return new String[0];
	}
	
	@Override
	public String getModContainerClass()
	{
		return null;
	}
	
	@Override
	public String getSetupClass()
	{
		return null;
	}
	
	@Override
	public void injectData(Map<String, Object> data) { }
	
	@Override
	public String getAccessTransformerClass()
	{
		return null;
	}
}