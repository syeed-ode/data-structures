package com.syeedode.datastructures.collection.maps.affinity.service;

import java.util.List;
import java.util.Map;

/**
 * Data Structures
 * String Comparison, Permutations and Manipulations
 * <p>
 * Author: syeedode
 * Date: 9/17/17
 */
public class AffinityExecutionService {


    public static void executeAffinity() {
        AffinityCalculationService service = new AffinityCalculationService();
        Map<List<List<String>>, Integer> stringListMap = service.calculateAffinities();
//        for(List<String> site : stringListMap.keySet()){
//            System.out.println("Site(s): " + StringUtils.join(site,",")
//                    + " - infinity: " + stringListMap.get(site));
//        }
    }
}
