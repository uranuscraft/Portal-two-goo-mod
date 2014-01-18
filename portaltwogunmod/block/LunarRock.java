package portaltwogunmod.block;

import java.util.Random;

import portaltwogunmod.core.BaseClass;
import portaltwogunmod.crafting.CraftingManger;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class LunarRock extends Block {

	public LunarRock(int par1, Material par2Material) {
		super(par1, par2Material);
		setHardness(4.0F); //sets the amount of hits before it breaks
        setStepSound(Block.soundStoneFootstep);//sets the sound played when walked on 
        setUnlocalizedName("lunarrock");//sets the texture name 
        setCreativeTab(CreativeTabs.tabBlock);//sets the creative tab to block
	}
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)//Registers the textures
    {
        this.blockIcon = par1IconRegister.registerIcon(BaseClass.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }
	public int idDropped(int par1, Random random, int par2) {//sets the id of the item dropped
        return CraftingManger.lunardust.itemID;
        
        
}
	public int quantityDropped(Random par1Random)//sets the amount of items dropped
    {
        return 4;
    }

}
