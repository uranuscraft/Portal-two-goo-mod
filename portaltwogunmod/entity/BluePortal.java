package portaltwogunmod.entity;

import portaltwogunmod.crafting.CraftingManger;
import portaltwogunmod.item.PortalGun;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BluePortal extends EntityThrowable {

	public BluePortal(World par1World) {
		super(par1World);
		
	}
	public BluePortal(World par1World, EntityPlayer player)
	   {
	       super(par1World, player);
	   
	  
	   
	   }
	   public BluePortal(World par1World, double par2, double par4, double par6)
	   {
	       super(par1World, par2, par4, par6);
	   }
	
	   @Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
	   int lookx = 0;
	   int looky = 0;
	   int lookz = 0;
		if(firstcheck = true) {
			worldObj.setBlock((int)this.posX, (int)this.posY, (int)this.posZ, CraftingManger.blueportal.blockID);	
		
		}
	   if(firstcheck = false){
		LookChecker(worldObj, movingobjectposition, lookx, looky, lookz);
	   firstcheck = true;
	   }
	   
	   }
public static boolean firstcheck = false;

	   @Override
	   protected float getGravityVelocity() 
	   {
	   return 0;
	   }

	   public void setDeadBlue() {
		   this.isDead = true;
	   }
public static void LookChecker(World worldObj, MovingObjectPosition movingobjectposition, int par1, int par2, int par3) {
	PortalGun.getLookXYZ(par1, par2, par3);   
	  movingobjectposition.blockX = par1;
	  movingobjectposition.blockY = par2;
	  movingobjectposition.blockZ = par3;
	  
	  
}
}
