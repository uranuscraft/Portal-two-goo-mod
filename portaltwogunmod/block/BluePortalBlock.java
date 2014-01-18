package portaltwogunmod.block;

import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.Random;

import portaltwogunmod.crafting.CraftingManger;
import portaltwogunmod.item.PortalGun;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BluePortalBlock {

	
	 
	    
	    public static void onCollided(World world, int par2, int par3,int par4, Entity entity) {
	    	setBlueCoords(par2, par3, par4);
	    	
	    	int orangex = OrangePortalBlock.getOrangeX();
	    	int orangey = OrangePortalBlock.getOrangeY();
	    	int orangez = OrangePortalBlock.getOrangeZ();
	    	 double d0 = entity.prevPosX - entity.posX;
	            double d1 = entity.prevPosZ - entity.posZ;

	            
	            	
	            int teleportDirection = Direction.getMovementDirection(d0, d1);
	            
	            
	           
	    	float Yaw = entity.rotationYaw;
	    	float Pitch = entity.rotationPitch;
	    	 if(entity.isCollided && PortalGun.orangeportal != false && CraftingManger.blueportal.blockID == world.getBlockId((int)entity.posX, (int)entity.posY, (int)entity.posZ)) { {
	    		 
				   entity.setLocationAndAngles(orangex, orangey, orangez, entity.rotationYaw, 0.0F);
				   entity.setVelocity((double)d0, 0, (double)d1);
	    	 }
	    	 }
				   
			   }  
	    	
	    	   
	    	   

	    	    
	    	    
	    public static void setBlueCoords(int par1, int par2, int par3) {
	    	bluex = par1;
	    	bluey = par2;
	    	bluez = par3;
	    	
	    }
	    public static int bluex;
	    public static int bluey;
	    public static int bluez;
	    
	    public static int getBlueX() {
	    	
	    	return bluex;
	    }

	    public static int getBlueY() {
	    	
	    	return bluey;
	    }

	    public static int getBlueZ() {
	    	
	    	return bluez;
	    }
	   
	    public void onBlockAdded(World world,int par2, int par3, int par4) {
	    	setBlueCoords(par2, par3, par4);
	    	
	    }
	 
}
