package com.syeedode.datastructures.collection.maps.affinity.service;

import com.syeedode.datastructures.annotations.ThreadSafe;
import com.syeedode.datastructures.collection.maps.affinity.dto.Affinity;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Data Structures
 * String Comparison, Permutations and Manipulations
 * <p>
 * Author: syeedode
 * Date: 9/17/17
 */
@ThreadSafe
public class AffinityCalculationService {
    private final AffinityFileReaderService readerService = new AffinityFileReaderService();

    public Map<List<List<String>>, Integer> calculateAffinities() {
        List<Affinity> affinityList =  readerService.readFileAndConvertToMap();
        Map<String, List<String>> userSiteListMap = getUserSiteListMap(affinityList);
        Map<String, List<List<String>>> userSiteComboMap = getUserSiteCombinationMap(userSiteListMap);
        return getAffinityForEachSiteCombo(userSiteComboMap, userSiteListMap);
    }

    private Map<List<List<String>>, Integer> getAffinityForEachSiteCombo(Map<String, List<List<String>>> primaryUser, Map<String, List<String>> compareToUser) {
        List<String> userProcessedList = new ArrayList<>();
        Map<List<List<String>>, Integer> affinityMap = new HashMap<>();
        for(String primary : primaryUser.keySet()) {
            for(String comparingUser : compareToUser.keySet()) {
                if(!userProcessedList.contains(comparingUser)) {
                    List<List<String>> primaryUserSiteList = primaryUser.get(primary);
                    if(primaryUserSiteList.contains(compareToUser.get(comparingUser))){
                        if(affinityMap.containsKey(primaryUserSiteList)){
                            Integer i = affinityMap.get(primaryUserSiteList);
                            i++;
                            affinityMap.put(primaryUserSiteList, i);
                        } else {
                            affinityMap.put(primaryUserSiteList, 1);
                        }
                    }
                }
            }
        }
        return affinityMap;
    }

    private Map<String, List<String>> getUserSiteListMap(List<Affinity> affinityList) {
        Map<String, List<String>> userSiteList = new HashMap<>();
        for(Affinity affinity : affinityList) {
            List<String> siteListVisited = userSiteList.get(affinity.getUser());
            if(Objects.isNull(siteListVisited)) {
                siteListVisited = new ArrayList<>();
            }
            siteListVisited.add(affinity.getSite());
            userSiteList.put(affinity.getUser(), siteListVisited);
        }
        return userSiteList;
    }

    private Map<String, List<List<String>>> getUserSiteCombinationMap(Map<String, List<String>> userSiteVisitedMap) {
        Map<String, List<List<String>>> userCombo = new HashMap<>();
        for(String user : userSiteVisitedMap.keySet()) {
            List<List<String>> siteCombinationList    = new ArrayList<>();
            List<String> allSites = userSiteVisitedMap.get(user);
            siteCombinationList.add(allSites);
            siteCombinationList.addAll(getCombinationSiteListForEachUser(allSites));
            userCombo.put(user, siteCombinationList);
        }
        return userCombo;
    }

    private List<List<String>> getCombinationSiteListForEachUser(List<String> allSites) {
        List<List<String>> siteComboList = new ArrayList<>();
        for(int i = 0; i < allSites.size(); i++) {
            List<String> intermediateList = new ArrayList<>();
            if(allSites.size() > 2) {
                siteComboList.add(Arrays.asList(allSites.get(i)));
            }
            for(int j = 0; j < allSites.size(); j++) {
                if(i != j) {
                    intermediateList.add(allSites.get(j));
                    intermediateList.add(allSites.get(i));
                }
            }
            siteComboList.add(intermediateList);
        }
        return siteComboList;
    }

    private Map<List<String>, Integer> calculatedAffinity(List<List<String>> primaryUserSites
            , List<List<String>> comparingUserSites) {
        Map<List<String>, Integer> affintyMap = new HashMap<>();
        for(List<String> primarySites : primaryUserSites) {
            for(List<String> comparingSites : comparingUserSites) {
                if(primarySites.contains(comparingSites)) {
                    if(affintyMap.containsKey(primarySites)){
                        Integer i = affintyMap.get(primarySites);
                        i++;
                        affintyMap.put(primarySites, i);
                    } else {
                        affintyMap.put(primarySites, 1);
                    }
                }
            }
        }
        return affintyMap;
    }

    private List<List<String>> buildSiteListCombinations(List<String> initalSiteList) {
        List<List<String>> allSiteComboList = new ArrayList<>();
        allSiteComboList.add(initalSiteList);
        int totalNumberOfSites = initalSiteList.size();
        for(int i = 0; i < totalNumberOfSites; i++) {
            allSiteComboList.add(Arrays.asList(initalSiteList.get(i)));
            List<String> intemediateSiteComboList = new ArrayList<>();
            for(int j = totalNumberOfSites - 1; j >= 0; j--) {
                if(i != j) {
                    intemediateSiteComboList.add(initalSiteList.get(j));
                }
            }
            if(!CollectionUtils.isEmpty(intemediateSiteComboList)) {
                allSiteComboList.add(intemediateSiteComboList);
            }
        }
        return allSiteComboList;
    }

//    private Map<List<String>, Integer> buildAffinityList(List<String> compareToList, List<List<String>> siteCombinationList) {
//        boolean allSitesFound = false;
//        for(List<String> siteList : siteCombinationList) {
//            for(String site : compareToList) {
//                if(siteList.contains(site)) {
//                    allSitesFound = true;
//                } else {
//                    allSitesFound = false;
//                    break;
//                }
//            }
//            if(allSitesFound) {
//                if(affinityMap.containsKey(siteList)) {
//                    Integer i = affinityMap.get(siteList);
//                    i++;
//                    affinityMap.put(siteList, i);
//                } else {
//                    affinityMap.put(siteList, 1);
//                }
//            }
//        }
//        return affinityMap;
//    }
}
