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
		
        maxStackSize = 64;
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("lunardust");
	}
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(BaseClass.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }

}
