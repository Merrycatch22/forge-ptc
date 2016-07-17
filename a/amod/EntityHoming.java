package com.a.amod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityHoming extends EntitySnowball {
	public EntityAINearestAttackableTarget.Sorter theNearestAttackableTargetSorter;
	public double knockbackStrength;

	public EntityHoming(World world) {
		super(world);
		// TODO Auto-generated constructor stub
	}

	public EntityHoming(World world, EntityLivingBase entity) {
		super(world, entity);
	}

	public float getGravityVelocity() {
		return 0.F;
	}

	public float func_70182_d() {
		return 0.6F;
	}

	public float func_70183_g() {
		return 0.F;
	}

	public void onUpdate() {

		List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this.getThrower(),
				this.boundingBox.expand(20, 20, 20));
		List<Entity> listLiving = new ArrayList<Entity>();
		ListIterator<Entity> iter = list.listIterator();

		theNearestAttackableTargetSorter = new EntityAINearestAttackableTarget.Sorter(this);

		while (iter.hasNext()) {
			Entity next = iter.next();
			if (next instanceof EntityLivingBase && !(next instanceof EntityPlayer)) {
				listLiving.add(next);
			}
		}
		Entity closest;
		Collections.sort(listLiving, this.theNearestAttackableTargetSorter);
		if (!listLiving.isEmpty()) {
			closest = listLiving.get(0);
			double d0 = closest.posX - this.posX;
			double d1 = closest.posY - this.posY;
			double d2 = closest.posZ - this.posZ;
			double mag = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
			double dividePower = 5;
			d0 /= mag * dividePower;
			d1 /= mag * dividePower;
			d2 /= mag * dividePower;
			double prev0 = this.motionX;
			double prev1 = this.motionY;
			double prev2 = this.motionZ;
			double prevMag = Math.sqrt(prev0 * prev0 + prev1 * prev1 + prev2 * prev2);
			prev0 /= prevMag;
			prev1 /= prevMag;
			prev2 /= prevMag;
			this.setThrowableHeading(d0 + prev0, d1 + prev1, d2 + prev2, 1.5F, 0.0F);
		}
		super.onUpdate();

	}

	public void onImpact(MovingObjectPosition p_70184_1_) {
		if (p_70184_1_.entityHit != null) {
			byte b0 = 0;

			if (p_70184_1_.entityHit instanceof EntityBlaze) {
				b0 = 3;
			}

			p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float) b0);
			float f4 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);

			if (f4 > 0.0F) {
				this.knockbackStrength = 0.5;
				double plusX = this.motionX * (double) this.knockbackStrength * 0.6000000238418579D / (double) f4;
				double plusZ = this.motionZ * (double) this.knockbackStrength * 0.6000000238418579D / (double) f4;

				p_70184_1_.entityHit.addVelocity(plusX, 0.1D*(1+(double) this.knockbackStrength), plusZ);
			}
		}

		for (int i = 0; i < 8; ++i) {
			this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
			
		}

		if (!this.worldObj.isRemote) {
			this.setDead();
		}
	}

}
