package com.a.amod;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.world.World;

public class DaisyPrimed extends EntityTNTPrimed {
	public DaisyPrimed(World arg0){
		super(arg0);
	}
	public DaisyPrimed(World arg0, double arg1, double arg2, double arg3, EntityLivingBase arg4){
		super(arg0, arg1, arg2, arg3, arg4);
	}
	
	@Override
	public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= 0.03999999910593033D;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863D;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= 0.9800000190734863D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
            this.motionY *= -0.5D;
        }

        if (this.fuse-- <= 0)
        {
            this.setDead();

            if (!this.worldObj.isRemote)
            {
            	float f = 40.0F;
            	for(int i=-39;i<=39;i+=13){
            		for(int j=-39;j<=39;j+=13){
            			 this.worldObj.createExplosion(this, this.posX+i, this.posY, this.posZ+j, f, true);
            		}
            	}
               
            
            }
        }
        else
        {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
        }
    }
}
