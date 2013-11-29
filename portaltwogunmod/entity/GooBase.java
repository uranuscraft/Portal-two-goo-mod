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
			   worldObj.setBlock((int)this.posX, (int)this.posY, (int)this.posZ, CraftingManger.bluegoo.blockID);
			   this.setDead();
		   }
		   
		   if(blockID == CraftingManger.Orangegoo.blockID) {
			   worldObj.setBlock((int)this.posX, (int)this.posY, (int)this.posZ, CraftingManger.Orangegoo.blockID);
			   this.setDead();
		   }
		   
		   if(blockID == CraftingManger.whitegoo.blockID) {
			   worldObj.setBlock((int)this.posX, (int)this.posY, (int)this.posZ, CraftingManger.whitegoo.blockID);
			   this.setDead();
		   }
		   
		   
		   
		  
	}
	   
	   public static int blockID;
	   
	   public static void GooBlock(int par1) {
		   
		   blockID = par1;
	   }

}
