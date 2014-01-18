package portaltwogunmod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import portaltwogunmod.core.BaseClass;
import portaltwogunmod.crafting.CraftingManger;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlueGoo extends Block {
	public BlueGoo(int par1, Material par2Material) {
		super(par1, par2Material);
		setHardness(4.0F);//set the amount of hits to mine this block
        setStepSound(Block.soundSnowFootstep);//sets the sound played when walking on the block
        setUnlocalizedName("bluegoo");//sets the name for the texture
        setCreativeTab(CreativeTabs.tabBlock);//sets this block to the creative tab block
	
	}
	@SideOnly(Side.CLIENT)
	
	public void registerIcons(IconRegister par1IconRegister)//Registers the texture
    {
        this.blockIcon = par1IconRegister.registerIcon(BaseClass.modid + ":" + (this.getUnlocalizedName().substring(5)));
    }

@Override
	public void onFallenUpon(World world,int par2,int par3,int par4, Entity entity, float par6) {
	
	
	double mY = entity.motionY;//gets the amount to zero on the number line
	double preposY = entity.posY; //gets the entity's previous Y position 
	double jump = mY * -0.5; //times the negative motion by 1 and divides by 2 but the easier version is to time by -0.5
	double x = entity.motionX;//gets the entity's x motion
	double z = entity.motionZ;//gets the entity's z motion
	
	
	
	double preposX = entity.posX;//gets the entity's X position 
	double preposZ = entity.posZ;//gets the entity's Z position 
	
	
		
		if (mY < 0.5D)
        {
            entity.setLocationAndAngles(preposX + x, preposY + jump, preposZ + z, entity.rotationYaw, 0.0F);//sets entity motionY to the double jump 
        }
     
}


	
public static int[] getMaser(int fre) {
	
	if(fre == Location[4]) {
	return Location;
	}
	else {
		return null;
	}
}
public static void setMaser(World world, int par1, int par2, int par3, int fre) {

	
	Location[0] = world.provider.dimensionId;
	Location[1] = par1;
	Location[2] = par2;
	Location[3] = par3;
	Location[4] = fre;	
}
public static int[] Location = new int[5];
}


