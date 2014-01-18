package portaltwogunmod.core;


import java.util.EnumSet;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import portaltwogunmod.crafting.*;
import portaltwogunmod.keybind.KeyBind;
import portaltwogunmod.keybind.PlayerTickHandler;
import portaltwogunmod.plugins.PluginController;
@Mod(modid=BaseClass.modid, name="PortalTwoGunMod", version="1.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class BaseClass {
	@Instance(value = "uranuscraft_portaltwogunmod")
    public static BaseClass instance;
   public static final String modid = "uranuscraft_portaltwogunmod"; //Adds modid used for textures
   
   // Says where the client and server 'proxy' code is loaded.
   @SidedProxy(clientSide="portaltwogunmod.client.ClientProxy", serverSide="portaltwogunmod.core.CommonProxy")
   public static CommonProxy proxy;

   //Declare ints
   public static int blueportaltopID;
   public static int orangeportaltopID;
   public static int lunardustID;
   public static int lunarrockID;
   public static int longfallID;
   public static int longfallEnumID;
   public static int orangeGooID;
   public static int blueGooID;
   public static int whiteGooID;
   public static int gooBallID;
   public static int PortalGunID;
   public static int blueportalID;
   public static int orangeportalID;
   
   
   
   public BaseClass() {
	   PluginController.getController().registerBuiltins();
   }
   
   
   @EventHandler
   public void preInit(FMLPreInitializationEvent event) {
	   Configuration config = new Configuration(event.getSuggestedConfigurationFile());
       //Add Block/item id configuration
	   lunardustID = config.get(Configuration.CATEGORY_ITEM, "lunardustID", 1380).getInt();
	   lunarrockID = config.get(Configuration.CATEGORY_ITEM, "lunarrockID", 1381).getInt();
	   longfallID = config.get(Configuration.CATEGORY_ITEM, "longfallID", 1382).getInt();
	   longfallEnumID = config.get(Configuration.CATEGORY_ITEM, "longfallEnumID", 5).getInt();
	   
	   orangeGooID = config.get(Configuration.CATEGORY_BLOCK, "orangeGooID", 1383).getInt();
	   blueGooID = config.get(Configuration.CATEGORY_BLOCK, "blueGooID", 1384).getInt();
	   
	   whiteGooID = config.get(Configuration.CATEGORY_BLOCK, "whiteGooID", 1385).getInt();
	   gooBallID = config.get(Configuration.CATEGORY_ITEM, "gooBallID", 1386).getInt();
	   PortalGunID = config.get(Configuration.CATEGORY_ITEM, "PortalGunID", 1387).getInt();
	   blueportalID = config.get(Configuration.CATEGORY_BLOCK, "blueportalID", 1388).getInt();
	   orangeportalID = config.get(Configuration.CATEGORY_BLOCK, "orangeportalID", 1389).getInt();
	   
	   blueportaltopID = config.get(Configuration.CATEGORY_BLOCK, "blueportaltopID", 1390).getInt();
	   orangeportaltopID = config.get(Configuration.CATEGORY_BLOCK, "orangeportaltopID", 1391).getInt();
	   
	   
	   config.save();
	   config.load();
	   PluginController.getController().preInit();
   }

   @EventHandler
   public void load(FMLInitializationEvent event) {
	   
	   //Adds recipes
	   CraftingManger.recipeAdder(lunarrockID, lunardustID, longfallID, longfallEnumID, orangeGooID,blueGooID, whiteGooID, gooBallID, PortalGunID, blueportalID, orangeportalID,blueportaltopID, orangeportaltopID);
	   
	   
	   //Adds Keybinds
	   KeyBinding[] key = {new KeyBinding("r", Keyboard.KEY_R)};
       boolean[] repeat = {false};
       KeyBindingRegistry.registerKeyBinding(new KeyBind(key, repeat));
       
       
       KeyBinding[] left = {new KeyBinding("Orange portal shooter", -2)};
       boolean[] leftrepeat = {false};
       KeyBindingRegistry.registerKeyBinding(new KeyBind(left, leftrepeat));
       TickRegistry.registerTickHandler(new PlayerTickHandler(EnumSet.of(TickType.PLAYER)), Side.SERVER);
       PluginController.getController().init();
   }
   @EventHandler
   public void load(FMLPostInitializationEvent event) {

	   PluginController.getController().postInit();
   }

}
