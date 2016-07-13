package com.a.amod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModArmor {
	public static Item crudHelmet;
	public static Item crudPlate;
	public static Item crudLegs;
	public static Item crudBoots;
	static ArmorMaterial crud=EnumHelper.addArmorMaterial("crud",0,new int[] {0,0,0,0},0);
	public static void armor(){
		crudHelmet=new CrudArmor(crud,0,"crudHelmet");
		crudPlate=new CrudArmor(crud,1,"crudPlate");
		crudLegs=new CrudArmor(crud,2,"crudLegs");
		crudBoots=new CrudArmor(crud,3,"crudBoots");
		GameRegistry.registerItem(crudHelmet, "Helmet");
		GameRegistry.registerItem(crudPlate, "Plate");
		GameRegistry.registerItem(crudLegs, "Legs");
		GameRegistry.registerItem(crudBoots, "Boots");
		
	}
}
