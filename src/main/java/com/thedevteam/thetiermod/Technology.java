package com.thedevteam.thetiermod;

import org.spout.api.material.Material;

/**
 *
 *
 */
public class Technology {
    public final Material material;
    private double specificValueNeeded = 0;
    private double parentValueNeeded = 0;
    private double generalValueNeeded = 0;

    public Technology(final Material material, double specificValue, double parentValue, double generalValue) {
        this.material = material;
        this.generalValueNeeded = generalValue;
        this.parentValueNeeded = parentValue;
        this.generalValueNeeded = generalValue;
    }

    /**
     * @return the specificValueNeeded
     */
    public double getSpecificValueNeeded() {
        return specificValueNeeded;
    }

    /**
     * @return the parentValueNeeded
     */
    public double getParentValueNeeded() {
        return parentValueNeeded;
    }

    /**
     * @return the generalValueNeeded
     */
    public double getGeneralValueNeeded() {
        return generalValueNeeded;
    }
}
