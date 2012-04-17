package com.thedevteam.thetiermod;

import java.util.logging.Level;

import org.spout.api.plugin.CommonPlugin;


public class THETierMod extends CommonPlugin{
    
    @Override
    public void onDisable() {
            // TODO Auto-generated method stub

    }

    @Override
    public void onEnable() {
            getLogger().log(Level.INFO, "THETierMod has been enabled");
    }

    public void log(Level warning, Object string) {
            // TODO Auto-generated method stub

    }

}
