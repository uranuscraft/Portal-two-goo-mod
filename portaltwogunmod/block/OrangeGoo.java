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
		setHardness(4.0F); 
        setStepSound(Block.soundSnowFootstep);
        setUnlocalizedName("orangegoo");
        setCreativeTab(CreativeTabs.tabBlock);
	
	}
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(BaseClass.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }
	@Override
    public void onEntityWalking (World world, int x, int y, int z, Entity entity)
    {
        double boost = 2.2D;
      
       

        double mX = Math.abs(entity.motionX);
        double mZ = Math.abs(entity.motionZ);
        if (mX < 0.5D)
        {
            entity.motionX *= boost;
        }
        if (mZ < 0.5D)
        {
            entity.motionZ *= boost;
        }
    }
	
}
