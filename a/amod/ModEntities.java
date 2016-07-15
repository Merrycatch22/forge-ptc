package com.a.amod;

import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;


public class ModEntities {
	//@SidedProxy(clientSide="com.a.amod.ClientProxy",serverSide="com.a.amod.CommonProxy")
	//public static CommonProxy proxy;
	public static void entities(AMod amod){
	//	proxy.registerRendering();
		//proxy.registerItemRenders();
		EntityRegistry.registerModEntity(EntityHoming.class, "homing", 0, amod, 80, 3, true);
		GameRegistry.registerTileEntity(TileEntityFurnDeuce.class, "tileEntityFurnDeuce");
	}
}
