package com.syeedode.datastructures.collection.maps.affinity.dto;

/**
 * Data Structures
 * String Comparison, Permutations and Manipulations
 * <p>
 * Author: syeedode
 * Date: 9/17/17
 */
public class Affinity {
    private final String user;
    private final String site;

    public static Affinity getInstance(String u, String s){
        return new Affinity(u, s);
    }

    private Affinity(String user, String site) {
        this.user = user;
        this.site = site;
    }

    public String getUser() {
        return user;
    }

    public String getSite() {
        return site;
    }
}
