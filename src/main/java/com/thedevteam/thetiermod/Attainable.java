package com.thedevteam.thetiermod;

import org.spout.api.material.Material;

/**
 *
 *
 */
public class Attainable {
    private final Material material;
    private double value = 0;

    public Attainable(final Material material) {
        this.material = material;
    }
    
    public double getValue(){
        return value;
    }
    
    public void setValue(double value){
        this.value = value;
    }

    /**
     * @return the material
     */
    public Material getMaterial() {
        return material;
    }
    
    
}
