package portaltwogunmod.block;

import java.util.List;

import portaltwogunmod.core.BaseClass;
import portaltwogunmod.crafting.CraftingManger;
import portaltwogunmod.item.PortalGun;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class OrangeTop extends Block {
	
	
	    public OrangeTop(int par1, Material par2Material) {
		super(par1, par2Material);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F);
		setResistance(4.0f);
		setBlockUnbreakable();
		setCreativeTab(CreativeTabs.tabBlock);
		setLightOpacity(0);
		setUnlocalizedName("otop");
	    }

	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return super.canPlaceBlockAt(par1World, par2, par3, par4) && this.canBlockStay(par1World, par2, par3, par4);
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        this.func_111046_k(par1World, par2, par3, par4);
    }

    private boolean func_111046_k(World par1World, int par2, int par3, int par4)
    {
        if (!this.canBlockStay(par1World, par2, par3, par4))
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockToAir(par2, par3, par4);
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        return !par1World.isAirBlock(par2, par3 - 1, par4);
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return par5 == 1 ? true : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }






    @Override
    public void onFallenUpon(World world, int par2, int par3, int par4, Entity entity, float par6){
    	OrangePortalBlock.onCollided(world, par2, par3, par4, entity);
    	
    	
    
    }
    public static boolean onadded = false;
@Override
public void onBlockAdded(World world,int par2, int par3, int par4) {
OrangePortalBlock.setOrangeCoords(par2, par3, par4);
onadded = true;
}


@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister par1IconRegister)
{
 this.blockIcon = par1IconRegister.registerIcon(BaseClass.modid + ":" + (this.getUnlocalizedName().substring(5)));
}
@Override
public boolean isOpaqueCube()
{
    return false;
}

}
