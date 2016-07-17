package com.a.amod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class CrudArmor extends ItemArmor {
	public float pitch = 15f;
	public EntityAINearestAttackableTarget.Sorter theNearestAttackableTargetSorter;
	public boolean isSentry=false;
	public boolean makeNoise=false;

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
					EntityThrowable throwable = new EntitySnowball(world,
							player);

					double d0 = next.posX - player.posX;
					/*
					 * double d1 = next.posY + (double) next.getEyeHeight() -
					 * 1.100000023841858D - entitysnowball.posY;
					 */
					double d1 = next.posY - player.posY;
					double d2 = next.posZ - player.posZ;
					// float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) *
					// 0.2F;
					float f1 = 0.f;
					throwable.setThrowableHeading(d0, d1 + (double) f1, d2,
							16F, 1.0F);
					// this.playSound("random.bow", 1.0F, 1.0F /
					// (this.getRNG().nextFloat() * 0.4F + 0.8F));
					world.spawnEntityInWorld(throwable);
				}
			}

		}
		if (itemStack.getItem() == ModArmor.crudPlate) {
			List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(
					player, player.boundingBox.expand(40, 40, 40));
			List<Entity> listLiving = new ArrayList<Entity>();
			ListIterator<Entity> iter = list.listIterator();

			theNearestAttackableTargetSorter = new EntityAINearestAttackableTarget.Sorter(player);

			while (iter.hasNext()) {
				Entity next = iter.next();
				if (next instanceof EntityLivingBase && !(next instanceof EntityPlayer)) {
					listLiving.add(next);
				}
			}
			Entity closest;
			Collections.sort(listLiving, this.theNearestAttackableTargetSorter);
			if (!listLiving.isEmpty()) {
				isSentry=true;
				closest = listLiving.get(0);
				double d0 = closest.posX - player.posX;
				/*
				 * double d1 = next.posY + (double) next.getEyeHeight() -
				 * 1.100000023841858D - entitysnowball.posY;
				 */
				double d1 = closest.posY - player.posY;
				double d2 = closest.posZ - player.posZ;
				 double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d2 * d2);
			        float f2 = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
			        float f3 = (float)(-(Math.atan2(d1, d3) * 180.0D / Math.PI));
			        player.rotationPitch = this.updateRotation(player.rotationPitch, f3, 10.f);
			        player.rotationYaw = this.updateRotation(player.rotationYaw, f2, 20.f);
			        EntityArrow arrow = new EntityArrow(world, player, 5F);
					//arrow.posZ += 1.0 * (Math.random() - 0.5f);
					//arrow.posX += 1.0 * (Math.random() - 0.5f);
					//arrow.posY += 1.0 * (Math.random() - 0.5f);
					world.spawnEntityInWorld(arrow);
					//world.playSoundAtEntity(player, "tile.piston.out", 1.0f, 1.0f);
			}
			else{
				isSentry=false;
			}
			if(makeNoise!=isSentry){
				makeNoise=isSentry;
				if(makeNoise){
					world.playSoundAtEntity(player, "mob.chicken.hurt", 1.0f, 1.0f);
				}
				else{
					//world.playSoundAtEntity(player, "mob.ghast.scream", 1.0f, 1.0f);
				}
			}
			
		}
		if (itemStack.getItem() == ModArmor.crudLegs) {
			List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(
					player, player.boundingBox.expand(10, 10, 10));
			ListIterator<Entity> iter = list.listIterator();
			while (iter.hasNext()) {
				Entity next = iter.next();
				if (next instanceof EntityLivingBase) {
					EntityArrow entityarrow = new EntityArrow(world, player, 4);

					// this.playSound("random.bow", 1.0F, 1.0F /
					// (this.getRNG().nextFloat() * 0.4F + 0.8F));
					double d0 = next.posX - player.posX;
					/*
					 * double d1 = next.posY + (double) next.getEyeHeight() -
					 * 1.100000023841858D - entitysnowball.posY;
					 */
					double d1 = next.posY - player.posY;
					double d2 = next.posZ - player.posZ;
					// float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) *
					// 0.2F;
					float f1 = 0.f;
					entityarrow.setThrowableHeading(d0, d1 + (double) f1, d2,
							16F, 1.F);
					world.spawnEntityInWorld(entityarrow);
				}
			}
		}
		if (itemStack.getItem() == ModArmor.crudBoots) {
			/*
			 * player.rotationYaw += 15;
			 * 
			 * if (player.rotationPitch <= -90) { pitch = 15.f; } if
			 * (player.rotationPitch >= 90) { pitch = -15.f; }
			 * player.rotationPitch += pitch;
			 */
			// System.out.println(player.rotationPitch);
			if (player.isSprinting()) {
				world.setWorldTime(world.getWorldTime() + 150);
			}
			player.stepHeight = 2;
			// player.capabilities.

			player.capabilities.allowFlying = true;
			//EntityHoming homing = new EntityHoming(world, player);
			//homing.posZ += 1.0 * (Math.random() - 0.5f);
			//homing.posX += 1.0 * (Math.random() - 0.5f);
			//homing.posY += 1.0 * (Math.random() - 0.5f);
			//world.spawnEntityInWorld(homing);

		}
		
	}
	private float updateRotation(float p_70663_1_, float p_70663_2_, float p_70663_3_)
    {
        float f3 = MathHelper.wrapAngleTo180_float(p_70663_2_ - p_70663_1_);

        if (f3 > p_70663_3_)
        {
            f3 = p_70663_3_;
        }

        if (f3 < -p_70663_3_)
        {
            f3 = -p_70663_3_;
        }

        return p_70663_1_ + f3;
    }
}
