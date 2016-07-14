package com.a.amod;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

public class ShotBow extends ItemBow {
	public ShotBow(){
		super();
	}
	@Override
	
	public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 7200;
    }
	
	
	@Override
	public void onPlayerStoppedUsing(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_)
    {
        int j = this.getMaxItemUseDuration(p_77615_1_) - p_77615_4_;

        ArrowLooseEvent event = new ArrowLooseEvent(p_77615_3_, p_77615_1_, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        j = event.charge;

        boolean flag = p_77615_3_.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, p_77615_1_) > 0;

        if (flag || p_77615_3_.inventory.hasItem(Items.arrow))
        {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            /*if ((double)f < 0.1D)
            {
                return;
            }*/

            if (f > 0.1F)
            {
                f = 0.1F;
            }

            //EntityArrow entityarrow = new EntityArrow(p_77615_2_, p_77615_3_, f * 40.0F);
            EntityArrow[] eas=new EntityArrow[25];
            for(int a=0;a<eas.length;a++){
            	
            		eas[a]=new EntityArrow(p_77615_2_, p_77615_3_, f * 40.0F);
            		eas[a].posZ+=5.0*(Math.random()-0.5f);
            		eas[a].posX+=5.0*(Math.random()-0.5f);
            		eas[a].posY+=5.0*(Math.random()-0.5f);
            	
            }
            
            if (f == 0.1F)
            {
                //entityarrow.setIsCritical(true);
                for(int a=0;a<eas.length;a++){
                	
                		eas[a].setIsCritical(true);
                	
                }
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, p_77615_1_);

            if (k > 0)
            {
                //entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, p_77615_1_);

            if (l > 0)
            {
                //entityarrow.setKnockbackStrength(l);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, p_77615_1_) > 0)
            {
                //entityarrow.setFire(100);
            }

            p_77615_1_.damageItem(1, p_77615_3_);
            p_77615_2_.playSoundAtEntity(p_77615_3_, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (flag)
            {
                //entityarrow.canBePickedUp = 2;
            	 for(int a=0;a<eas.length;a++){
                 	
                 		eas[a].canBePickedUp = 2;
                 	
                 }
            	
            }
            else
            {
                
                for(int a=0;a<eas.length;a++){
                 	
                 		p_77615_3_.inventory.consumeInventoryItem(Items.arrow);
                 	
                 }
            }

            if (!p_77615_2_.isRemote)
            {
                //p_77615_2_.spawnEntityInWorld(entityarrow);
                for(int a=0;a<eas.length;a++){
                 	
                 		p_77615_2_.spawnEntityInWorld(eas[a]);
                 	
                 }
            }
        }
    }
}
