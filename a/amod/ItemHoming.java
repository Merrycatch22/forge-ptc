package com.a.amod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHoming extends Item {
	public ItemHoming(String name){
		setUnlocalizedName(AMod.MODID+"_"+name);
		setTextureName("images:"+name);
		setCreativeTab(CreativeTabs.tabMisc);
		
	}
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		if(!world.isRemote){
			world.spawnEntityInWorld(new EntityHoming(world,player));
		}
		return stack;
	}
}
