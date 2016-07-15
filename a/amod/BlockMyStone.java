package com.a.amod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMyStone extends Block{
	public BlockMyStone(){
		super(Material.rock);
		setBlockName("block1");
		setBlockTextureName("images:"+"MyStone");
		setCreativeTab(CreativeTabs.tabBlock);
		
		setHardness(1F);
		setResistance(5f);
		setHarvestLevel("pickaxe",0);
		setStepSound(soundTypeStone);
		this.slipperiness=2.f;
	}
}
