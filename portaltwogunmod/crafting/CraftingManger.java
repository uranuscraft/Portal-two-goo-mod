package portaltwogunmod.crafting;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import portaltwogunmod.block.BlueGoo;
import portaltwogunmod.block.BluePortalBlock;
import portaltwogunmod.block.LunarRock;
import portaltwogunmod.block.OrangeGoo;
import portaltwogunmod.block.OrangePortalBlock;
import portaltwogunmod.block.WhiteGoo;
import portaltwogunmod.generation.LunarRockGen;
import portaltwogunmod.item.GooBall;
import portaltwogunmod.item.LongFallBoots;
import portaltwogunmod.item.Lunardust;
import portaltwogunmod.item.PortalGun;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

public class CraftingManger {


	
	public static Block Orangegoo;
	public static Block bluegoo;
public static Block lunarrock;
public static Item lunardust;
public static int longfallID;
public static int longfallEnumID;
public static Block whitegoo;
public static Item gooball;
public static Item portalgun;
public static Block blueportal;
public static Block orangeportal;


static EnumArmorMaterial longARMOR = EnumHelper.addArmorMaterial("fall", 20, new int[] { 2, 6, 5, -1 }, 50);
public static Item longfall = new LongFallBoots(longfallID, longARMOR, 3, longfallEnumID).setTextureName("boots");
	




public static void recipeAdder(int par1, int par2, int par3, int par4, int par5, int par6, int par7, int par8, int par9, int par10, int par11) {
		 lunarrock = new LunarRock(par1, Material.rock);
		 lunardust= new Lunardust(par2);	
		 longfallID = par3;
		 longfallEnumID = par4;
		 Orangegoo = new OrangeGoo(par5, Material.sand);
		 bluegoo = new BlueGoo(par6, Material.sand);
		 whitegoo = new WhiteGoo(par7,Material.sand);		 
		 gooball = new GooBall(par8);
		 portalgun = new PortalGun(par9);
		 blueportal = new BluePortalBlock(par10, Material.circuits);
		 orangeportal = new OrangePortalBlock(par11, Material.circuits);
		 LanguageRegistry.addName(longfall, "Long Fall Boots");
		 
		 LanguageRegistry.addName(portalgun, "portal gun");
		 
		
		 LanguageRegistry.addName(orangeportal, "orange portal");
		 LanguageRegistry.addName(blueportal, "blue portal");
		 
		 LanguageRegistry.addName(lunardust, "Lunar Dust");
		 LanguageRegistry.addName(lunarrock, "Lunar Rock");
		 LanguageRegistry.addName(Orangegoo, "Orange goo");
		 LanguageRegistry.addName(whitegoo, "White goo");
		 LanguageRegistry.addName(bluegoo, "Blue goo");
		
		 GameRegistry.registerBlock(blueportal, "blueportal");
		 GameRegistry.registerBlock(orangeportal, "orangeportal");
		 
		 
		 
		 
		 
		 
		 
		 
		 MinecraftForge.setBlockHarvestLevel(lunarrock, "pickaxe", 2);
         GameRegistry.registerBlock(lunarrock, "lunarRock");
         
         GameRegistry.registerBlock(Orangegoo, "orangegoo");
         MinecraftForge.setBlockHarvestLevel(Orangegoo, "shovel", 2);
         
         
         GameRegistry.registerBlock(whitegoo, "whitegoo");
         MinecraftForge.setBlockHarvestLevel(whitegoo, "shovel", 2);
         
         GameRegistry.registerBlock(bluegoo, "bluegoo");
         MinecraftForge.setBlockHarvestLevel(bluegoo, "shovel", 2);
         
         GameRegistry.registerWorldGenerator(new LunarRockGen());
	
         
         ItemStack orange = new ItemStack(Item.dyePowder, 1, 14);
         ItemStack blue = new ItemStack(Item.dyePowder, 1, 4);
         ItemStack whitegooStack = new ItemStack(whitegoo);
         ItemStack ironStack = new ItemStack(Item.ingotIron);
         ItemStack lunardustStack = new ItemStack(lunardust);

         GameRegistry.addRecipe(new ItemStack(longfall), "x x", "xyx", 
                 'x', ironStack, 'y', lunardustStack);
         
         GameRegistry.addRecipe(new ItemStack(lunarrock), "xx", "xx", 
                 'x', lunardustStack);
	
GameRegistry.addSmelting(lunarrock.blockID, whitegooStack, 10F);


LanguageRegistry.addName(new ItemStack(gooball, par8, 0), "White goo ball");
LanguageRegistry.addName(new ItemStack(gooball, par8, 1), "Blue goo ball");
LanguageRegistry.addName(new ItemStack(gooball, par8, 2), "Orange goo ball");



GameRegistry.addShapelessRecipe(new ItemStack(bluegoo), blue, new ItemStack(whitegoo));
GameRegistry.addShapelessRecipe(new ItemStack(Orangegoo), orange, new ItemStack(whitegoo));

}
	
	
}
