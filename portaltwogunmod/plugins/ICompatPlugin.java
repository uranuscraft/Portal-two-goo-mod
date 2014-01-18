package portaltwogunmod.plugins;

public interface ICompatPlugin {
	 // Mod ID the plugin handles
    public abstract String getModId();

    // Called during PreInit
    public abstract void preInit();

    // Called during Init
    public abstract void init();

    // Called during PostInit
    public abstract void postInit();
}
