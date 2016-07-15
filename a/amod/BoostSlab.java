package com.a.amod;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BoostSlab extends BlockSlab {

	public BoostSlab(boolean p_i45410_1_, Material p_i45410_2_) {
		super(p_i45410_1_, p_i45410_2_);
		this.slipperiness=2.f;
		setCreativeTab(CreativeTabs.tabFood);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String func_150002_b(int p_150002_1_) {
		// TODO Auto-generated method stub
		return "";
	}

}
