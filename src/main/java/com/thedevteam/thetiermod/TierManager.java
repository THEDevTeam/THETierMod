package com.thedevteam.thetiermod;

import java.util.HashMap;
import java.util.Map;
import org.spout.api.material.Material;

/**
 *
 *
 */
public class TierManager {
    private static Map<String, Branch> branches = new HashMap<String, Branch>();
    private static Map<Material, Branch> materials = new HashMap<Material, Branch>();

    private TierManager() {
    }
    
    public static Branch getBranch(String name) {
        return branches.get(name);
    }
    
    public static void addBranch(Branch branch){
        if(branches.containsKey(branch.name)){
            throw new IllegalArgumentException("Can't overwrite existing branch"); //TODO got to be a better way to do this
        }
        branches.put(branch.name, branch);
        for(Technology tech : branch.getTech()){
            if(!materials.containsKey(tech.material)){
                materials.put(tech.material, branch);
                continue;
            }
        }
    }
    
    public static double calcSpecificValue(Branch branch){
        return recursiveSpecific(branch, 0);
    }
    
    public static double calcParentValue(Branch branch){
        double toRet = 0;
        for(Branch b : branch.getParents()){
            toRet += b.getExp();
        }
        return toRet;
    }
    
    public static double calcGeneralValue(){
        double toRet = 0;
        for(Map.Entry<String, Branch> e : branches.entrySet()){
            toRet += e.getValue().getExp();
        }
        return toRet;
    }
    
    private static double recursiveSpecific(Branch branch, int level){
        if(levelPercent(level) == 0) return 0;
        double toRet = branch.getExp() * levelPercent(level);
        for(Branch b : branch.getChildren()){//TODO could be a loop
            toRet += recursiveSpecific(b, level + 1) ;
        }
        return toRet;
    }

    private static double levelPercent(int level) {
        if(level == 0) return 1;
        return (1 - (2 * (1/(Math.sqrt(100 * level))))) + .1;
    }
    
}
