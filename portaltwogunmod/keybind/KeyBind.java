package portaltwogunmod.keybind;
import java.util.EnumSet;
import java.util.Iterator;

import org.lwjgl.input.Keyboard;
import net.minecraft.item.ItemStack;

import portaltwogunmod.entity.BluePortal;
import portaltwogunmod.entity.OrangePortal;
import portaltwogunmod.item.PortalGun;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;
public class KeyBind extends KeyHandler
{
    private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);
   
    public KeyBind(KeyBinding[] keyBindings, boolean[] repeatings)
    {
            super(keyBindings, repeatings);
    }
    @Override
    public String getLabel()
    {
            return "BindKey";
    }
    public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
    {
    keyPressed = true;
    if(kb.equals(Keyboard.KEY_R)) {
    	r = true;
    	
    }
    
    if(kb.equals(1)) {
    	left = true;
    	
    }
    
    }
    @Override
    public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd)
    {
    if (keyPressed) {
    keyPressed = false;
    keyPressed = true; }
    }
    @Override
    public EnumSet<TickType> ticks()
    {
            return tickTypes;
    }
public static boolean r = false;
public static boolean left = false;

    public static boolean keyPressed = false;
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
    {
    EntityPlayer player = (EntityPlayer)par3Entity;

    if(KeyBind.keyPressed)
    {
    if(left = true) {
    	PortalGun.spawnOrange(par1ItemStack, par2World, player);
    
    	PortalGun.orangeportal = false;
    	left = false;
    }
    if(r= true) {
    	
    	PortalGun.orangeportal = false;
    	PortalGun.blueportal = false;
    	blue.setDeadBlue();
    	orange.setDeadOrange();
    	r = false;
    }
    
    }

}
public static BluePortal blue;

public static OrangePortal orange;
}
