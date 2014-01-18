package portaltwogunmod.item;


import portaltwogunmod.core.BaseClass;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Lunardust extends Item {

	public Lunardust(int par1) {
		super(par1);
		
        maxStackSize = 64;//sets the max items per a stack
        setCreativeTab(CreativeTabs.tabMisc);//sets the item creative tab
        setUnlocalizedName("lunardust");//sets texture name
	}
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)//Registers textures
    {
        this.itemIcon = par1IconRegister.registerIcon(BaseClass.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }

}
