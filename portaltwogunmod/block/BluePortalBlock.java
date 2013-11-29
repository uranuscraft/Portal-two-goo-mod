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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BluePortalBlock extends Block {

	public BluePortalBlock(int par1, Material par2Material) {
		super(par1, par2Material);
	setResistance(4.0f);
	setBlockUnbreakable();
	setCreativeTab(CreativeTabs.tabBlock);
	
	}
	 
	    @Override
	    public void onEntityCollidedWithBlock(World world, int par2, int par3,int par4, Entity entity) {
	    	setBlueCoords(par2, par3, par4);
	    	
	    	int orangex = OrangePortalBlock.getOrangeX();
	    	int orangey = OrangePortalBlock.getOrangeY();
	    	int orangez = OrangePortalBlock.getOrangeZ();
	    	
	    	float Yaw = entity.rotationYaw;
	    	float Pitch = entity.rotationPitch;
	    	 if(entity.isCollided && PortalGun.orangeportal != false && CraftingManger.blueportal.blockID == world.getBlockId((int)entity.posX, (int)entity.posY, (int)entity.posZ)) { {
				   
				   entity.setLocationAndAngles(orangex, orangey, orangez, entity.rotationYaw, 0.0F);
	    	 }
	    	 }
				   
			   }  
	    	
	    	   
	    	   

	    	    @SideOnly(Side.CLIENT)

	    	    /**
	    	     * Returns the bounding box of the wired rectangular prism to render.
	    	     */
	    	    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	    	    {
	    	        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
	    	        return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
	    	    }

	    	    /**
	    	     * Updates the blocks bounds based on its current state. Args: world, x, y, z
	    	     */
	    	    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	    	    {
	    	        this.updateLadderBounds(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
	    	    }


	    	    /**
	    	     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
	    	     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	    	     */
	    	    public boolean isOpaqueCube()
	    	    {
	    	        return false;
	    	    }

	    	   

	    	    /**
	    	     * The type of render function that is called for this block
	    	     */
	    	    public int getRenderType()
	    	    {
	    	        return 8;
	    	    }

	    	    /**
	    	     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	    	     */
	    	    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	    	    {
	    	        return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST ) ||
	    	               par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST ) ||
	    	               par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH) ||
	    	               par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH);
	    	    }

	    	    /**
	    	     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
	    	     */
	    	    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
	    	    {
	    	        int j1 = par9;

	    	        if ((j1 == 0 || par5 == 2) && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH))
	    	        {
	    	            j1 = 2;
	    	        }

	    	        if ((j1 == 0 || par5 == 3) && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH))
	    	        {
	    	            j1 = 3;
	    	        }

	    	        if ((j1 == 0 || par5 == 4) && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST))
	    	        {
	    	            j1 = 4;
	    	        }

	    	        if ((j1 == 0 || par5 == 5) && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST))
	    	        {
	    	            j1 = 5;
	    	        }

	    	        return j1;
	    	    }
	    	    public void updateLadderBounds(int par1)
	    	    {
	    	        float f = 0.125F;

	    	        
	    	            this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 0.0F, .0F);
	    	        
	    	    }

	            /**
	             * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	             */
	            @Override
	            public boolean renderAsNormalBlock()
	            {
	                    return false;
	            }

	            /**
	             * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
	             * cleared to be reused)
	             */
	            @Override
	            public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	            {
	                    int metadata = par1World.getBlockMetadata(par2, par3, par4);

	                    if (metadata == 0)
	                            return null;
	                    else
	                            return AxisAlignedBB.getBoundingBox(par2 + minX, par3 + minY, par4 + minZ, par2 + maxX, par3 + maxY, par4 + maxZ);
	            }

	            @Override
	            public void onNeighborBlockChange(World world, int i, int j, int k, int l)
	            {
	                    if (l > 0 && Block.blocksList[l].canProvidePower())
	                    {
	                            world.scheduleBlockUpdate(i, j, k, blockID, 0);
	                    }
	            }

	            @Override
	            public void updateTick(World world, int i, int j, int k, Random random)
	            {
	                    boolean flag = !world.isRemote && (world.isBlockIndirectlyGettingPowered(i, j, k) || world.isBlockIndirectlyGettingPowered(i, j + 1, k));

	                    if (flag)
	                    {
	                            world.setBlockMetadataWithNotify(i, j, k, 1, 4);
	                    }
	                    else
	                    {
	                            world.setBlockMetadataWithNotify(i, j, k, 0, 4);
	                    }
	            }
	    	    /**
	    	     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	    	     * their own) Args: x, y, z, neighbor blockID
	    	     */
	    	    
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

	    @Override
	    public void onBlockAdded(World world,int par2, int par3, int par4) {
	    	setBlueCoords(par2, par3, par4);
	    	
	    }
	 
}
