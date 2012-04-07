package com.thedevteam.thetiermod.web;

import com.thedevteam.thetiermod.event.BlockPlaceFailEvent;
import com.thedevteam.thetiermod.event.CraftFailEvent;
import org.spout.api.Spout;
import org.spout.api.event.EventHandler;
import org.spout.api.event.Listener;
import org.spout.api.event.Order;
import org.spout.api.event.block.BlockChangeEvent;
import org.spout.api.event.inventory.PlayerInventoryCraftEvent;

/**
 *
 *
 */
public class WebTierListener implements Listener{

    @EventHandler(order = Order.LATEST)
    public void onCraftEvent(PlayerInventoryCraftEvent event){
        double lack = 1 - WebTier.getValue(event.getResult().getMaterial());
        if(Math.random() < lack){
            event.setCancelled(true);
            Spout.getEventManager().callEvent(new CraftFailEvent(event));
        }
    }
    
    @EventHandler(order = Order.LATEST)
    public void onBlockPlace(BlockChangeEvent event){
        double lack = 1 - WebTier.getValue(event.getSnapshot().getMaterial());
        if(Math.random() < lack){
            event.setCancelled(true);
            Spout.getEventManager().callEvent(new BlockPlaceFailEvent(event));
        }
    }
}
