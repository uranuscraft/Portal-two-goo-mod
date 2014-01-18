package portaltwogunmod.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import portaltwogunmod.core.CommonProxy;
import portaltwogunmod.entity.Bullets;
import portaltwogunmod.entity.GooBase;
import portaltwogunmod.render.RenderBullets;
import portaltwogunmod.render.RenderGooBase;

public class ClientProxy extends CommonProxy{
	@Override
    public void registerRenderers() {
         //Registers Entities
		 EntityRegistry.registerGlobalEntityID(Bullets.class, "bullets", EntityRegistry.findGlobalUniqueEntityId());
		 RenderingRegistry.registerEntityRenderingHandler(Bullets.class, new RenderBullets());
		 
		 EntityRegistry.registerGlobalEntityID(GooBase.class, "goo", EntityRegistry.findGlobalUniqueEntityId());
		 RenderingRegistry.registerEntityRenderingHandler(GooBase.class, new RenderGooBase());
	
	
	
	}
}
