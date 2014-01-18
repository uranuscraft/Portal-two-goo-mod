package portaltwogunmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import portaltwogunmod.core.BaseClass;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WhiteGoo extends Block {
	public WhiteGoo(int par1, Material par2Material) {
		super(par1, par2Material);
		setHardness(4.0F);//sets the amount of hits required to break this block
        setStepSound(Block.soundSnowFootstep);//sets the sound to play when walked on
        setUnlocalizedName("whitegoo");//sets the texture name
        setCreativeTab(CreativeTabs.tabBlock);//sets Creative tab of this block
	
	}
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)//Registers the texture
    {
        this.blockIcon = par1IconRegister.registerIcon(BaseClass.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }

}
