package com.a.amod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
	public static Item shotbow;
	public static Item homing;
	public static void items(){
		shotbow=new ShotBow();
		GameRegistry.registerItem(shotbow, "shotbow");
		homing=new ItemHoming("homing");
		GameRegistry.registerItem(homing, "homing");
	}
}
