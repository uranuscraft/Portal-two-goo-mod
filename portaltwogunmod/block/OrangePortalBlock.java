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

public class OrangePortalBlock {

	 

	
     
     public static void onCollided(World world, int par2, int par3,int par4, Entity entity) {
     	setOrangeCoords(par2, par3, par4);
     	
     	int bluex = BluePortalBlock.getBlueX();
     	int bluey = BluePortalBlock.getBlueY();
     	int bluez = BluePortalBlock.getBlueZ();
     	double d0 = entity.prevPosX - entity.posX;
         double d1 = entity.prevPosZ - entity.posZ;

         
         	
         int teleportDirection = Direction.getMovementDirection(d0, d1);
     	float Yaw = entity.rotationYaw;
     	float Pitch = entity.rotationPitch;
     	 if(entity.isCollided && PortalGun.blueportal != false && CraftingManger.orangeportal.blockID == world.getBlockId((int)entity.posX, (int)entity.posY, (int)entity.posZ)) {
     		 entity.setLocationAndAngles(bluex, bluey, bluez, entity.rotationYaw, 0.0F);
     		 entity.setVelocity((double)d0, 0, (double)d1);
     	 
     	 }  
     	
     	
     
     }
 public static void setOrangeCoords(int par1, int par2, int par3) {
 x = par1;
 y = par2;
 z = par3;

 }
 public static int x;
 public static int y;
 public static int z;
 public static int getOrangeX() {

 return x;
 }

 public static int getOrangeY() {

 return y;
 }

 public static int getOrangeZ() {

 return z;
 }
 
 
}
