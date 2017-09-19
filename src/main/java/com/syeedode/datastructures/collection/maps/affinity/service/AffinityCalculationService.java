package com.syeedode.datastructures.collection.maps.affinity.service;

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
public class AffinityCalculationService {
    AffinityFileReaderService readerService = new AffinityFileReaderService();
    private final List<String> userProcessedList = new ArrayList<>();
    private final Map<List<String>, Integer> affinityMap = new HashMap<>();

    public Map<List<String>, Integer> calculateAffinities() {
        List<Affinity> affinityList =  readerService.readFileAndConvertToMap();
        Map<String, List<String>> userSiteVisitedMap = determineAllSitsUserVisited(affinityList);
        calculateAffinityBetweenUserAndSite(userSiteVisitedMap);
        return affinityMap;
    }

    private Map<String, List<String>> determineAllSitsUserVisited(List<Affinity> affinityList) {
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

    private void calculateAffinityBetweenUserAndSite(Map<String, List<String>> userSiteVisitedMap) {
        for(String initialUser : userSiteVisitedMap.keySet()) {
            for(String compareToUser : userSiteVisitedMap.keySet()) {
                if(userHasNotBeenProcessed(compareToUser)) {
                    List<String> initalSiteList = userSiteVisitedMap.get(initialUser);
                    List<String> compareToList  = userSiteVisitedMap.get(compareToUser);
                    List<List<String>> siteCombinationList = buildSiteListCombinations(initalSiteList);
                    buildAffinityList(compareToList, siteCombinationList);
                }
            }
            userProcessedList.add(initialUser);
        }
    }

    private boolean userHasNotBeenProcessed(String user) {
        return ! userProcessedList.contains(user);
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

    private Map<List<String>, Integer> buildAffinityList(List<String> compareToList, List<List<String>> siteCombinationList) {
        boolean allSitesFound = false;
        for(List<String> siteList : siteCombinationList) {
            for(String site : compareToList) {
                if(siteList.contains(site)) {
                    allSitesFound = true;
                } else {
                    allSitesFound = false;
                    break;
                }
            }
            if(allSitesFound) {
                if(affinityMap.containsKey(siteList)) {
                    Integer i = affinityMap.get(siteList);
                    i++;
                    affinityMap.put(siteList, i);
                } else {
                    affinityMap.put(siteList, 1);
                }
            }
        }
        return affinityMap;
    }
}
