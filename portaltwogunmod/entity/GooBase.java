package portaltwogunmod.entity;

import portaltwogunmod.crafting.CraftingManger;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class GooBase extends EntityThrowable {

	public GooBase(World par1World) {
		super(par1World);
		
	}
	public GooBase(World par1World, EntityPlayer player)
	   {
	       super(par1World, player);
	   
	  
	   
	   }
	   public GooBase(World par1World, double par2, double par4, double par6)
	   {
	       super(par1World, par2, par4, par6);
	   }
	
	   @Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
		  
		
		   if(blockID == CraftingManger.bluegoo.blockID) {
			   worldObj.setBlock((int)this.posX, (int)this.posY, (int)this.posZ, CraftingManger.bluegoo.blockID);//sets the block at x,y,z to blue goo
			   this.setDead();//kills this entity
		   }
		   
		   if(blockID == CraftingManger.Orangegoo.blockID) {
			   worldObj.setBlock((int)this.posX, (int)this.posY, (int)this.posZ, CraftingManger.Orangegoo.blockID);//sets the block at x,y,z to orange goo
			   this.setDead();//kills this entity
		   }
		   
		   if(blockID == CraftingManger.whitegoo.blockID) {
			   worldObj.setBlock((int)this.posX, (int)this.posY, (int)this.posZ, CraftingManger.whitegoo.blockID); //sets the block at x,y,z to white goo 
			   this.setDead();//kills this entity
		   }
		   
		   
		   
		  
	}
	   
	   public static int blockID;
	   /**sets the block id to change the impact block to
	    * 
	    * @param par1
	    */
	   public static void GooBlock(int par1) {
		   
		   blockID = par1;
	   }

}
