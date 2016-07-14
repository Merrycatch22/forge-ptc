package com.a.amod;

import java.util.List;
import java.util.ListIterator;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget.Sorter;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
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
			
			List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(
					player, player.boundingBox.expand(40, 40, 40));
			ListIterator<Entity> iter = list.listIterator();
			while (iter.hasNext()) {
				Entity next = iter.next();
				if (next instanceof EntityLivingBase) {
					EntitySnowball entitysnowball = new EntitySnowball(world, player);

					double d0 = next.posX - player.posX;
					double d1 = next.posY + (double) next.getEyeHeight()
							- 1.100000023841858D - entitysnowball.posY;
					double d2 = next.posZ - player.posZ;
					float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.2F;
					entitysnowball.setThrowableHeading(d0, d1 + (double) f1,
							d2, 1.6F, 12.0F);
					// this.playSound("random.bow", 1.0F, 1.0F /
					// (this.getRNG().nextFloat() * 0.4F + 0.8F));
					world.spawnEntityInWorld(entitysnowball);
				}
			}

		}
		if (itemStack.getItem() == ModArmor.crudPlate) {
			EntityArrow arrow = new EntityArrow(world, player, 5F);
			arrow.posZ += 1.0 * (Math.random() - 0.5f);
			arrow.posX += 1.0 * (Math.random() - 0.5f);
			arrow.posY += 1.0 * (Math.random() - 0.5f);
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
				pitch = 15.f;
			}
			if (player.rotationPitch >= 90) {
				pitch = -15.f;
			}
			player.rotationPitch += pitch;
			System.out.println(player.rotationPitch);
		}
	}
}
