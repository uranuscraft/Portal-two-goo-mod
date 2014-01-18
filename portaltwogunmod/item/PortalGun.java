package portaltwogunmod.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import portaltwogunmod.block.BluePortalBlock;
import portaltwogunmod.block.BluePortalTopBottom;
import portaltwogunmod.block.OrangePortalBlock;
import portaltwogunmod.block.OrangeTop;
import portaltwogunmod.block.OrangeTopBottom;
import portaltwogunmod.block.PortalTop;
import portaltwogunmod.core.BaseClass;
import portaltwogunmod.crafting.CraftingManger;
import portaltwogunmod.entity.BluePortal;
import portaltwogunmod.entity.GooBase;
import portaltwogunmod.entity.OrangePortal;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PortalGun extends Item {

	public PortalGun(int par1) {
		super(par1);
		
        maxStackSize = 1;
        setCreativeTab(CreativeTabs.tabTools);
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
	       
	       
	       if(PortalTop.onadded && BluePortalTopBottom.onadded)  {
	    	   BluePortalKill(world, bluextop, blueytop, blueztop, bluexbottom, blueybottom, bluezbottom);
	    	   PortalTop.onadded = false;
	    	   BluePortalTopBottom.onadded = false;
	       }
				     
				      
	        
	        
	        
	        world.spawnEntityInWorld(new BluePortal(world, player));
	
	        double reach = 100;
	        
	        int block = getBlockInfront(world, player,reach);
	      if(CraftingManger.blueportal.blockID != world.getBlockId(bluexbottom, blueybottom - 1, bluezbottom) && CraftingManger.blueportaltop.blockID != world.getBlockId(bluextop, blueytop - 1, blueztop) ) {
	        if(block == 1){
	        	
	        	double posX = player.posX;
	        	double posZ = player.posX;
	        	double posY = player.posY;
	        	if(z > posZ) {
        			
	        		if(world.isAirBlock(x, y + 1, z + 1)){
	        		
	        			
	        			
	        			world.setBlock((int)x, (int)y + 1, (int)z + 1, CraftingManger.blueportaltop.blockID);
	        			world.setBlock((int)x, (int)y + 1, (int)z, CraftingManger.blueportal.blockID);
	        		
	        			bluexbottom = x;
			        	blueybottom = y + 1;
			        	bluezbottom = z;
			        	bluextop = x;
			        	blueytop = y + 1;
			        	blueztop = z + 1;
	        		
	        		}
	        		}
	        	else if(x > posX){
	        	
	        	
	        	if(world.isAirBlock(x + 1, y + 1, z)){
	        		
	        		world.setBlock((int)x + 1, (int)y + 1, (int)z, CraftingManger.blueportaltop.blockID);
	        		
	        		world.setBlock((int)x, (int)y + 1, (int)z, CraftingManger.blueportal.blockID);
	        		bluexbottom = x;
		        	blueybottom = y + 1;
		        	bluezbottom = z;
		        	bluextop = x + 1;
		        	blueytop = y + 1;
		        	blueztop = z;
		        	bluepostiveX = true;
		        	
		        	
	        	}
	        	
	        	}
	        	else if(z < posZ) {
        			
	        		if(world.isAirBlock(x, y + 1, z - 1)){
	        			world.setBlock((int)x, (int)y + 1, (int)z, CraftingManger.blueportaltop.blockID);
	        			world.setBlock((int)x, (int)y + 1, (int)z - 1, CraftingManger.blueportal.blockID);
	        		
	        		
	        		
	        		
	        		bluexbottom = x;
		        	blueybottom = y + 1;
		        	bluezbottom = z - 1;
		        	bluextop = x;
		        	blueytop = y + 1;
		        	blueztop = z;
	        		}
	        		} 
	        	
	        	else if(x < posX){
	        		
		        	if(world.isAirBlock(x - 1, y + 1, z)){
		        	
		        	
		        	world.setBlock((int)x, (int)y + 1, (int)z, CraftingManger.blueportaltop.blockID);
		        	world.setBlock((int)x - 1, (int)y + 1, (int)z, CraftingManger.blueportal.blockID);
		        	bluexbottom = x - 1;
		        	blueybottom = y + 1;
		        	bluezbottom = z;
		        	bluextop = x;
		        	blueytop = y + 1;
		        	blueztop = z;
		        	bluenegx = true;
		        	}
		        	}
	        	
	        
	        	
	        }
	        
	       
	      }
	blueportal = true;
	}
	return itemstack;

	}
public static boolean blueportal;
public static boolean orangeportal;


public static int bluexbottom;
public static int blueybottom;
public static int bluezbottom;
public static int bluextop;
public static int blueytop;
public static int blueztop;


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
	        entity = player;
	        world.spawnEntityInWorld(new OrangePortal(world, player));
	double reach = 4;
	       int block = getBlockInfront(world, player,reach);
	       
	orangeportal = true;
	}
	 return itemstack;
}

public static boolean bluepostiveX = false;
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




public static void Portalkill(World world) {
	
	
	int orangex = OrangePortalBlock.x;
	int orangey = OrangePortalBlock.y;
	int orangez = OrangePortalBlock.z;
	BluePortalKill(world, bluextop, blueytop, blueztop, bluexbottom, blueybottom, blueztop);
	
	world.setBlockToAir(orangex, orangey, orangez);
	
	
	
}
public static Entity entity;
/**
 * If [4] is -1 , there was no block within reach.
 * @return [0]= BlockId, [1]= BlockX, [2]= BlockY, [3]= BlockZ, [4]= SideHit, [5]= BlockMeta
 */
public static int getBlockInfront(World theWorld, EntityPlayer thePlayer, double reach)
{
	int side = 0;
	int[] blockInfo = { 0, 0, 0, 0, -1, 0 };

	MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(theWorld, thePlayer, true, reach);
	if (movingobjectposition != null) {
		if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {
			blockInfo[1] = movingobjectposition.blockX;
			blockInfo[2] = movingobjectposition.blockY;
			blockInfo[3] = movingobjectposition.blockZ;
			side = movingobjectposition.sideHit;
			blockInfo[5] = theWorld.getBlockMetadata(blockInfo[1], blockInfo[2], blockInfo[3]);
			blockInfo[0] = theWorld.getBlockId(blockInfo[1], blockInfo[2], blockInfo[3]);
		}
	}
	return side;
}

private static MovingObjectPosition getMovingObjectPositionFromPlayer(World world, EntityPlayer entityplayer, boolean flag, double reach)
{
	float f = 1.0F;
	float playerPitch = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f;
	float playerYaw = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f;
	double playerPosX = entityplayer.prevPosX + (entityplayer.posX - entityplayer.prevPosX) * f;
	double playerPosY = (entityplayer.prevPosY + (entityplayer.posY - entityplayer.prevPosY) * f + 1.6200000000000001D) - entityplayer.yOffset;
	double playerPosZ = entityplayer.prevPosZ + (entityplayer.posZ - entityplayer.prevPosZ) * f;
	Vec3 vecPlayer = Vec3.createVectorHelper(playerPosX, playerPosY, playerPosZ);
	float cosYaw = MathHelper.cos(-playerYaw * 0.01745329F - 3.141593F);
	float sinYaw = MathHelper.sin(-playerYaw * 0.01745329F - 3.141593F);
	float cosPitch = -MathHelper.cos(-playerPitch * 0.01745329F);
	float sinPitch = MathHelper.sin(-playerPitch * 0.01745329F);
	float pointX = sinYaw * cosPitch;
	float pointY = sinPitch;
	float pointZ = cosYaw * cosPitch;
	Vec3 vecPoint = vecPlayer.addVector(pointX * reach, pointY * reach, pointZ * reach);
	MovingObjectPosition movingobjectposition = world.rayTraceBlocks_do_do(vecPlayer, vecPoint, flag, !flag);
	return movingobjectposition;
}


public static void BluePortalKill(World world, int par1, int par2, int par3, int par4, int par5, int par6) {
	if(PortalTop.onadded = true){
	world.setBlockToAir(par1, par2, par3);
	
	PortalTop.onadded = false;
	}
if(BluePortalTopBottom.onadded) {
	world.setBlockToAir(par4, par5, par6);
	BluePortalTopBottom.onadded = false;
}

}
	public static void OrangePortalKill(World world, int par1, int par2, int par3, int par4, int par5, int par6) {
		if(OrangeTop.onadded){
		world.setBlockToAir(par1, par2, par3);
		
		OrangeTop.onadded = false;
		}
        if(OrangeTopBottom.onadded) {
        	world.setBlockToAir(par4, par5, par6);
        	OrangeTopBottom.onadded = false;
        }

}


public static boolean bluenegx = false;
}
