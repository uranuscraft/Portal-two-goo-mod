package portaltwogunmod.plugins.galaticraft;

import portaltwogunmod.plugins.ICompatPlugin;

public class Moon implements ICompatPlugin
{
    @Override
    public String getModId() {
        return "GalacticraftMoon";
    }

	@Override
	public void preInit() {
		// TODO Auto-generated method stub
		
	}
	public static int moonid;
	@Override
	public void init() {
		MoonLoader.RegisterModMoon(moonid);
		
	}

	@Override
	public void postInit() {
		// TODO Auto-generated method stub
		
	}
}
