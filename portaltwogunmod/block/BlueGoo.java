package portaltwogunmod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import portaltwogunmod.core.BaseClass;
import portaltwogunmod.crafting.CraftingManger;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlueGoo extends Block {
	public BlueGoo(int par1, Material par2Material) {
		super(par1, par2Material);
		setHardness(4.0F); 
        setStepSound(Block.soundSnowFootstep);
        setUnlocalizedName("bluegoo");
        setCreativeTab(CreativeTabs.tabBlock);
	
	}
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(BaseClass.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }

@Override
	public void onFallenUpon(World world,int par2,int par3,int par4, Entity entity, float par6) {
	double lastmotionY = entity.motionY;
	
	double lastposY = entity.posY;
	double jump = lastmotionY * -2.5;
	double x = entity.motionX;
	double z = entity.motionZ;
	
	
	
	double posx = entity.posX;
	double posz = entity.posZ;
	
	
		entity.setLocationAndAngles(posx + x, lastposY + jump, posz + z, entity.rotationYaw, 0.0F);

}


	



}


