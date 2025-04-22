package brokenheart_undershirt_tracker;

import fermiumbooter.FermiumRegistryAPI;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;

import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.12.2")
public class BrokenHeartUndershirtTrackerPlugin implements IFMLLoadingPlugin {

	public BrokenHeartUndershirtTrackerPlugin() {
		MixinBootstrap.init();

		FermiumRegistryAPI.enqueueMixin(true, "mixins.bhut.base.json", () -> !Loader.isModLoaded("rlmixins"));
		FermiumRegistryAPI.enqueueMixin(true, "mixins.bhut.rlmixinspresent.json", () -> Loader.isModLoaded("rlmixins"));
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