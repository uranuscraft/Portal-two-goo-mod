package portaltwogunmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class Bullets extends EntityThrowable {

	public Bullets(World par1World) {
		super(par1World);
		// TODO Auto-generated constructor stub
	}
	public Bullets(World par1World, EntityPlayer player)
	   {
	       super(par1World, player);
	   
	  
	   
	   }
	   public Bullets(World par1World, double par2, double par4, double par6)
	   {
	       super(par1World, par2, par4, par6);
	   }
	   public Bullets(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5)
	    {
		   super(par1World);  
	    }
	   @Override
	protected void onImpact(MovingObjectPosition movingobjectposition) {
		// TODO Auto-generated method stub
		
		   DamageSource damagesource = null;
		   
		   if (this.shootingEntity == null)
           {
               damagesource = causeArrowDamage(this, this);
           }
           else
           {
               damagesource = causeArrowDamage(this, this.shootingEntity);
           }
	}
	   public static DamageSource causeArrowDamage(Bullets bullet, Entity par1Entity)
	    {
	        return (new EntityDamageSourceIndirect("bullet", bullet, par1Entity)).setProjectile();
	    }


	   @Override
	   public void onUpdate() {
		   Vec3 vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
           Vec3 vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
		   MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks_do_do(vec3, vec31, false, true);
		   vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
           vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
           Entity entity = null;
           movingobjectposition = new MovingObjectPosition(entity);
		   
		   if (this.shootingEntity != null && movingobjectposition.entityHit != this.shootingEntity && movingobjectposition.entityHit instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP)
           {
               ((EntityPlayerMP)this.shootingEntity).playerNetServerHandler.sendPacketToPlayer(new Packet70GameEvent(6, 0));
           }
	   }
	   public Entity shootingEntity;
	private double damage;
	   
	   
	   @Override
	   protected float getGravityVelocity() 
	   {
		return 0;
	   }
	   public void setDamage(double par1)
	    {
	        this.damage = par1;
	    }
	   public double getDamage()
	    {
	        return this.damage;
	    }
}
