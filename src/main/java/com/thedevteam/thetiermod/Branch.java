package com.thedevteam.thetiermod;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 */
public class Branch {
    private static final long serialVersionID = 213423L;
    public final String name;
    private Set<Branch> parents = new HashSet<Branch>();
    private Set<Branch> children = new HashSet<Branch>();
    private Set<Technology> tech = new HashSet<Technology>();
    private double experience;

    public Branch(String name, String... parents) {
        this.name = name;
        for(String parent : parents){
            this.parents.add(TierManager.getBranch(parent));
        }
    }

    /**
     * @return the parents
     */
    public Set<Branch> getParents() {
        return parents;
    }

    /**
     * @return the children
     */
    public Set<Branch> getChildren() {
        return children;
    }

    /**
     * @return the tech
     */
    public Set<Technology> getTech() {
        return tech;
    }

    public double getExp() {
        return experience;
    }
    
    public void addExp(double toAdd){
        experience += toAdd;
    }
    
    
    
}
