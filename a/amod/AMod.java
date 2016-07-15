package com.a.amod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = AMod.MODID, version = AMod.VERSION)
public class AMod
{
    public static final String MODID = "amod";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ModBlocks.blocks();
    	ModItems.items();
    	ModArmor.armor();
    	ModEntities.entities(this);
		// some example code
       // System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
}
