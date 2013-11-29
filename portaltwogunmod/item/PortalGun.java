package portaltwogunmod.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import portaltwogunmod.core.BaseClass;
import portaltwogunmod.entity.BluePortal;
import portaltwogunmod.entity.GooBase;

import portaltwogunmod.entity.OrangePortal;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PortalGun extends Item {

	public PortalGun(int par1) {
		super(par1);
		
        maxStackSize = 1;
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("portalgun");
	
	
	
	}
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(BaseClass.modid + ":" + (this.getUnlocalizedName().substring(5)));
    } 
@Override
public ItemStack onItemRightClick(ItemStack itemstack, World world,EntityPlayer player) {
	float f = 1.0F;
	float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
	float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
	double d = player.prevPosX + (player.posX - player.prevPosX) * (double)f;
	double d1 = (player.prevPosY + (player.posY - player.prevPosY) * (double)f + 1.6200000000000001D) - (double)player.yOffset;
	double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double)f;
	Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
	float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
	float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
	float f5 = -MathHelper.cos(-f1 * 0.01745329F);
	float f6 = MathHelper.sin(-f1 * 0.01745329F);
	float f7 = f4 * f5;
	float f8 = f6;
	float f9 = f3 * f5;
	double d3 = 5000D;
	Vec3 vec3d1 = vec3d.addVector((double)f7 * d3, (double)f8 * d3, (double)f9 * d3);
	MovingObjectPosition movingobjectposition = world.rayTraceBlocks_do_do(vec3d, vec3d1, false, true);
	if (movingobjectposition == null)
	{
	 return itemstack;
	}
	 if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
	{
	 int i = movingobjectposition.blockX;
	        int j = movingobjectposition.blockY;
	        int k = movingobjectposition.blockZ;
	        setLookXYZ(i,j,k);
	        
	        world.spawnParticle("dripWater", i, k, j, 5, 5, 5);
	        world.spawnEntityInWorld(new BluePortal(world, player));
	
	
	blueportal = true;
	}
	return itemstack;

	}
public static boolean blueportal;
public static boolean orangeportal;
public static ItemStack spawnOrange(ItemStack itemstack, World world,EntityPlayer player){
	float f = 1.0F;
	float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
	float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
	double d = player.prevPosX + (player.posX - player.prevPosX) * (double)f;
	double d1 = (player.prevPosY + (player.posY - player.prevPosY) * (double)f + 1.6200000000000001D) - (double)player.yOffset;
	double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double)f;
	Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
	float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
	float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
	float f5 = -MathHelper.cos(-f1 * 0.01745329F);
	float f6 = MathHelper.sin(-f1 * 0.01745329F);
	float f7 = f4 * f5;
	float f8 = f6;
	float f9 = f3 * f5;
	double d3 = 5000D;
	Vec3 vec3d1 = vec3d.addVector((double)f7 * d3, (double)f8 * d3, (double)f9 * d3);
	MovingObjectPosition movingobjectposition = world.rayTraceBlocks_do_do(vec3d, vec3d1, false, true);
	if (movingobjectposition == null)
	{
	 return itemstack;
	}
	 if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
	{
	 int i = movingobjectposition.blockX;
	        int j = movingobjectposition.blockY;
	        int k = movingobjectposition.blockZ;
	        setLookXYZ(i,j,k);
	        
	        world.spawnEntityInWorld(new OrangePortal(world, player));
	
	        
	orangeportal = true;
	}
	 return itemstack;
}


public static int x;
public static int y;
public static int z;
public static void setLookXYZ(int par1, int par2, int par3) {
	x = par1;
	y = par2;
	z = par3;
}


public static int[] getLookXYZ(int par1, int par2, int par3) {
	par1 = x;
	par2 = y;
	par3 = z;
	return new int[]{par1, par2, par3};
}
}
