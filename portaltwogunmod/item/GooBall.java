package portaltwogunmod.item;

import java.util.List;

import portaltwogunmod.core.BaseClass;
import portaltwogunmod.crafting.CraftingManger;
import portaltwogunmod.entity.GooBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class GooBall extends Item {

	public GooBall(int par1) {
		super(par1);
		maxStackSize = 64;//sets the max items per a stack
        setCreativeTab(CreativeTabs.tabMisc);//sets the item creative tab
        setUnlocalizedName("gooball");//sets texture name
        setHasSubtypes(true);//is multiple items
	
	}

	
	  @SideOnly(Side.CLIENT)
      private Icon[] icons;
     
      @SideOnly(Side.CLIENT)
      public void registerIcons(IconRegister par1IconRegister)//Registers textures
      {
             icons = new Icon[3];
            
             for(int i = 0; i < icons.length; i++)
             {
                    icons[i] = par1IconRegister.registerIcon(BaseClass.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
             }
      }
     
      public static final String[] names = new String[] {"white", "blue","orange"};
     
      public String getUnlocalizedName(ItemStack par1ItemStack)//gets the texture name
   {
       int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
       return super.getUnlocalizedName() + "." + names[i];
   }
     
      public Icon getIconFromDamage(int par1)//gets texture from damage
   {
      return icons[par1];
   }
   @SideOnly(Side.CLIENT)
   public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
   {
      for (int x = 0; x < 3; x++)//sets the amount of metadata items
       {
           par3List.add(new ItemStack(this, 1, x));
       }
   }


@Override
 public boolean onItemUse(ItemStack itemStack,EntityPlayer player, World world, int par1, int par2, int par3, int par4, float par5, float par6, float par7 ){

	if(itemStack.getItemDamage() == 0) {//sees if the item is a white gooball
		if(player.capabilities.isCreativeMode||player.inventory.consumeInventoryItem(CraftingManger.gooball.itemID)) {
	
		
		GooBase.GooBlock(CraftingManger.whitegoo.blockID);
		world.spawnEntityInWorld(new GooBase(world, player));
		return true;
		}
		}
	
if(itemStack.getItemDamage() == 1) {//sees if the item is a blue gooball
	if (player.capabilities.isCreativeMode||player.inventory.consumeInventoryItem(CraftingManger.gooball.itemID)) {

		
		GooBase.GooBlock(CraftingManger.bluegoo.blockID);
		world.spawnEntityInWorld(new GooBase(world, player));
		return true;
}	
}


if(itemStack.getItemDamage() == 2) {//sees if the item is a orange gooball
	if (player.capabilities.isCreativeMode||player.inventory.consumeInventoryItem(CraftingManger.gooball.itemID)) {
	
	GooBase.GooBlock(CraftingManger.Orangegoo.blockID);
	world.spawnEntityInWorld(new GooBase(world, player));
	return true;
	}
	}

else {
	return false;
}
return false;

}
}




