package com.a.amod;

import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.tileentity.TileEntityFurnace;

public class TileEntityFurnDeuce extends TileEntityFurnace {
	public void updateEntity()
    {
		this.furnaceCookTime+=39;
		if(this.furnaceCookTime>=200){
			this.furnaceCookTime=199;
		}
		super.updateEntity();
		EntityArrow[] arrows=new EntityArrow[12];
		for(int i=0;i<arrows.length;i++){
			arrows[i]=new EntityArrow(worldObj, this.xCoord, this.yCoord+2, this.zCoord);
			//arrows[i].setThrowableHeading(p_70186_1_, p_70186_3_, p_70186_5_, p_70186_7_, p_70186_8_);
		}
		
		//System.out.println(this.furnaceCookTime);
		
    }
}
