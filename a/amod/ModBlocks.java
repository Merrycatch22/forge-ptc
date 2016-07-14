package com.a.amod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks {
	public static Block myStone;
	public static Block daisy;
	public static Block furndeuce;
	public static void blocks() {
		myStone=new BlockMyStone();
		GameRegistry.registerBlock(myStone, "MyStone");
		daisy=new Daisy();
		GameRegistry.registerBlock(daisy, "Daisy");
		furndeuce=new FurnDeuce(true);
		GameRegistry.registerBlock(furndeuce,"FurnDeuce");
	}
}
