package portaltwogunmod.item;

import portaltwogunmod.crafting.CraftingManger;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

public class LongFallBoots extends ItemArmor implements ISpecialArmor {

	public LongFallBoots(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, 0, par3);
	
		
		
	}

	

	 @Override
	    public void registerIcons (IconRegister par1IconRegister)//Registers texture
	    {
	        this.itemIcon = par1IconRegister.registerIcon("uranuscraft_portaltwogunmod:armor/" + textureName + "_"
	                + (this.armorType == 0 ? "helmet" : this.armorType == 1 ? "chestplate" : this.armorType == 2 ? "leggings" : this.armorType == 3 ? "boots" : "helmet"));
	    }

	    @Override
	    public String getArmorTexture (ItemStack stack, Entity entity, int slot, int layer)//Registers the model texture
	    {
	    	
	    	return "uranuscraft_portaltwogunmod:textures/armor/longfall_1.png";
	    	}
	    	
	   @Override
	    public void onArmorTickUpdate(World world,EntityPlayer player,ItemStack itemStack) {
		
		   double prey = player.prevPosY;
			 
			 double x = player.posX;
			  double z = player.posZ;
			   
			   int y = world.getTopSolidOrLiquidBlock((int)x,(int)z);
			   double playery = player.posY;
				double ycheck = prey - playery;
			  
				  if(player.motionY < 0 && player.motionY < -2 && ycheck > 0) {
					  int d = (int) (playery - y);
						
					  double g = 9.8; //the meters per a second
					  double firstequation = g * 2; 
					  double secondequation = firstequation * d;
					  double v = Math.sqrt(secondequation);
					  double answer = v * -1; //the calculation for the velocity of the given
					  int o = 0;
					  do {
						  player.motionY = o;
						  o++;
						  
					 
					  } while(o < answer + 1);
					  
					  
					  
							
					  		
			  
				  
			  } 
	   	
	    }
	   
	   public String textureName = "longfall";
	@Override
	public ArmorProperties getProperties(EntityLivingBase player,
			ItemStack armor, DamageSource source, double damage, int slot) {
		// TODO Auto-generated method stub
		if (source.getDamageType().equals("fall")) 
		{
			return new ArmorProperties(0, 1.00, Integer.MAX_VALUE); 
		} 
		else 
		{
			
		return new ArmorProperties(0, 0.08, Integer.MAX_VALUE);
		
		}
	}



	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack,
			DamageSource source, int damage, int slot) {
		// TODO Auto-generated method stub
		
	}


@Override
public void onUpdate(ItemStack stack,World world,Entity entity, int par4, boolean par5) {
	 EntityPlayer player = (EntityPlayer) entity;
	   
}


}
