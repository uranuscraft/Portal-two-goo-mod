package portaltwogunmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import portaltwogunmod.core.BaseClass;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OrangeGoo extends Block {

	public OrangeGoo(int par1, Material par2Material) {
		super(par1, par2Material);
		setHardness(4.0F); //set the amount of hits to mine this block
        setStepSound(Block.soundSnowFootstep);//sets the sound played when walking on the block
        setUnlocalizedName("orangegoo");//sets the name for the texture
        setCreativeTab(CreativeTabs.tabBlock);//sets this block to the creative tab block
	
	}
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)//Registers the texture
    {
        this.blockIcon = par1IconRegister.registerIcon(BaseClass.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }
	@Override
    public void onEntityWalking (World world, int x, int y, int z, Entity entity)
    {
        double boost = 2.2D;//the boost amount
      
       

        double mX = Math.abs(entity.motionX);//gets the amount to zero on the number line
        double mZ = Math.abs(entity.motionZ);//gets the amount to zero on the number line
        if (mX < 0.5D)
        {
            entity.motionX *= boost;//sets entity motionX to entity.motionX times boost 
        }
        if (mZ < 0.5D)
        {
            entity.motionZ *= boost;//sets entity motionZ to entity.motionZ times boost 
        }
    }
	
}
