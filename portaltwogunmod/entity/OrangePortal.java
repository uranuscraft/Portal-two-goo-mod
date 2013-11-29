package portaltwogunmod.entity;

import portaltwogunmod.crafting.CraftingManger;
import portaltwogunmod.item.PortalGun;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class OrangePortal extends EntityThrowable {

	public OrangePortal(World par1World) {
		super(par1World);
		
	}
	public OrangePortal(World par1World, EntityPlayer player)
	   {
	       super(par1World, player);
	   
	  
	   
	   }
	   public OrangePortal(World par1World, double par2, double par4, double par6)
	   {
	       super(par1World, par2, par4, par6);
	   }
	
	   @Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
		   int lookx = 0;
		   int looky = 0;
		   int lookz = 0;
			   PortalGun.getLookXYZ(lookx, looky, lookz);
		  movingobjectposition.blockX = lookx;
		  movingobjectposition.blockY = looky;
		  movingobjectposition.blockZ = lookz;
	  
		  worldObj.setBlock(lookx, looky, lookz, CraftingManger.orangeportal.blockID);
	   }


	   @Override
	   protected float getGravityVelocity() 
	   {
	   return 0;
	   }
	   public void setDeadOrange() {
		   this.isDead = true;
	   }
}
