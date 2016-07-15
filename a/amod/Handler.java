package com.a.amod;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class Handler {
	
	@SubscribeEvent
	public void TickPlayer(TickEvent.PlayerTickEvent event){
		EntityPlayer player = event.player;
		
	}
}
