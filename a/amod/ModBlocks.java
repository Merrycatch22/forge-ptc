package com.a.amod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class ModBlocks {
	public static Block myStone;
	public static Block daisy;
	public static Block furndeuce;
	public static Block boostairs;
	public static Block boostSlab;
	public static void blocks() {
		myStone=new BlockMyStone();
		GameRegistry.registerBlock(myStone, "MyStone");
		daisy=new Daisy();
		GameRegistry.registerBlock(daisy, "Daisy");
		furndeuce=new FurnDeuce(false);
		GameRegistry.registerBlock(furndeuce,"FurnDeuce");
		boostairs=new Boostairs(Blocks.diamond_block,0);
		GameRegistry.registerBlock(boostairs,"Boostairs");
		boostSlab=new BoostSlab(false,Material.tnt);
		GameRegistry.registerBlock(boostSlab,"BoostSlab");
	}
}
