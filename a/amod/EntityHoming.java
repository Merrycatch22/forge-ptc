package com.a.amod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.world.World;

public class EntityHoming extends EntitySnowball{
	public EntityAINearestAttackableTarget.Sorter theNearestAttackableTargetSorter;
	public EntityHoming(World world) {
		super(world);
		// TODO Auto-generated constructor stub
	}
	public EntityHoming(World world, EntityLivingBase entity){
		super(world,entity);
	}

	public float getGravityVelocity(){
		return 0.F;
	}
	public float func_70182_d(){
		return 0.6F;
	}
	public float func_70183_g(){
		return 0.F;
	}
	public void onUpdate(){
		
		List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(
				this.getThrower(), this.boundingBox.expand(10, 10, 10));
		List<Entity> listLiving = new ArrayList<Entity>();
		ListIterator<Entity> iter = list.listIterator();
		
		theNearestAttackableTargetSorter=new EntityAINearestAttackableTarget.Sorter(this);
		
		
		while (iter.hasNext()) {
				Entity next = iter.next();
			if (next instanceof EntityLivingBase && !(next instanceof EntityPlayer)) {
				listLiving.add(next);
			}
		}
		Entity closest;
		Collections.sort(listLiving, this.theNearestAttackableTargetSorter);
		if(!listLiving.isEmpty()){
			closest=listLiving.get(0);
			double d0 = closest.posX - this.posX;
			//double d1 = next.posY + (double) next.getEyeHeight()- 1.100000023841858D - entitysnowball.posY;
			double d1=closest.posY-this.posY;
			double d2 = closest.posZ - this.posZ;
			//float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.2F;
			float f1=0.f;
			this.setThrowableHeading(d0, d1 + (double) f1,
					d2, 0.6F, 0.0F);
		}
		super.onUpdate();
		
	}

}
