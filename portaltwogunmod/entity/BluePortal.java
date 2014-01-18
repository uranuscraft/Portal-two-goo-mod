package portaltwogunmod.entity;

import portaltwogunmod.crafting.CraftingManger;
import portaltwogunmod.item.PortalGun;
import net.minecraft.entity.Entity;
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
			int par1 = 0;
			int par2 = 0;
			int par3 = 0;
			PortalGun.getLookXYZ(par1, par2, par3);
			if(firstcheck = true) {
			check = true;
			firstcheck = false;
				if(this.posX == par1 && this.posY == par2 && this.posZ == par3){
			
				double x = this.posX;
				double y = this.posY;
				double z = this.posZ;
				
				Entity entity = PortalGun.entity;
				ChoordChecker(worldObj,entity, x,y,z, entity.posX,entity.posY, entity.posZ);
				
			   this.isDead = true;
			
			
			}
		}
		}
	   if(firstcheck = false){
		   check = false;
		   LookChecker(worldObj, movingobjectposition, lookx, looky, lookz);
	   firstcheck = true;
	   }
	   
	   }
public static boolean firstcheck = false;
public static boolean check = false;
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

public static void ChoordChecker(World worldObj, Entity entity, double x, double y, double z, double entityx, double entityy, double entityz) {
	boolean xanswer = false;
	boolean yanswer = false;
	boolean zanswer = false;

	if(x > 0){
		if(entityx > 0){
		if(x > entityx) {
			x = x - entity.posX;
		xanswer = true;
		}
		if(x < entityx) {
			x = entity.posX - x;
			xanswer = true;
		}
		
		
		}
	if(entityx < 0){
		if(x > entityx) {
			x = x + entity.posX;
			xanswer = true;
		}
		if(x < entityx) {
			x = entity.posX + x;
			xanswer = true;
		}
	}
	
	}
	if(x < 0 && xanswer != true) {
		if(x > entityx) {
			x = x + entity.posX;
			xanswer = true;
		}
		if(x < entityx) {
			x = entity.posX + x;
			xanswer = true;
		}
	
	}
if(y > 0 && xanswer != false) {
	if(y > entityy) {
		y = y - entity.posY;
		yanswer = true;
	}
if(y < entityy) {
	y = entity.posY - y;
	yanswer = true;
}

}

if(z > 0 && yanswer != false){
	if(entityz > 0){
	if(z > entityz) {
		z = z - entity.posZ;
		zanswer = true;
	}
	if(z < entityz) {
		z = entity.posZ - z;
		zanswer = true;
	}
	
	
	}
if(entityx < 0){
	if(z > entityz) {
		z = z + entity.posZ;
		zanswer = true;
	}
	if(z < entityz) {
		z = entity.posZ + z;
		zanswer = true;
	}
}

}
if(z < 0 && zanswer != true) {
	if(z > entityz) {
		z = z + entity.posZ;
		zanswer = true;
	}
	if(z < entityz) {
		z = entity.posZ + z;
		zanswer = true;
	}

}
worldObj.setBlock((int)x,(int)y,(int)z, CraftingManger.blueportal.blockID);	
}







}
