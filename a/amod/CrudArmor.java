package com.a.amod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CrudArmor extends ItemArmor {
	public float pitch = 15f;

	public CrudArmor(ArmorMaterial material, int armorType, String name) {
		super(material, 0, armorType);
		setUnlocalizedName(AMod.MODID + "_" + name);
		setTextureName("images:" + name);
		setCreativeTab(CreativeTabs.tabCombat);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player,
			ItemStack itemStack) {
		if (itemStack.getItem() == ModArmor.crudHelmet) {
			EntityArrow arrow = new EntityArrow(world, player.posX + 10.0
					* Math.random() - 5.0, player.posY + 5 + 5.0
					* Math.random(), player.posZ + 10.0 * Math.random() - 5.0);
			if (!world.isRemote) {
				world.spawnEntityInWorld(arrow);
			}
		}
		if (itemStack.getItem() == ModArmor.crudPlate) {
			EntityArrow arrow=new EntityArrow(world, player, 5F);
			arrow.posZ+=1.0*(Math.random()-0.5f);
    		arrow.posX+=1.0*(Math.random()-0.5f);
    		arrow.posY+=1.0*(Math.random()-0.5f);
			world.spawnEntityInWorld(arrow);
		}
		if (itemStack.getItem() == ModArmor.crudLegs) {
			EntityOcelot oc = new EntityOcelot(world);
			oc.setPosition(player.posX + 10.0 * Math.random() - 5.0,
					player.posY + 30 + 30.0 * Math.random(), player.posZ + 10.0
							* Math.random() - 5.0);
			oc.setTamed(true);
			world.spawnEntityInWorld(oc);
			EntityWolf w = new EntityWolf(world);
			w.setPosition(player.posX + 10.0 * Math.random() - 5.0, player.posY
					+ 30 + 30.0 * Math.random(),
					player.posZ + 10.0 * Math.random() - 5.0);
			w.setTamed(true);
			world.spawnEntityInWorld(w);
		}
		if (itemStack.getItem() == ModArmor.crudBoots) {
			player.rotationYaw += 15;

			if (player.rotationPitch <= -90) {
				pitch=15.f;
			}
			if (player.rotationPitch >= 90) {
				pitch=-15.f;
			}
			player.rotationPitch+=pitch;
			System.out.println(player.rotationPitch);
		}
	}
}
