package com.syeedode.datastructures.arrays.lunchorder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Data Structures
 * Array Manipulations
 * <p>
 * Author: syeedode
 * Date: 9/16/17
 */
public class LunchMenuHashService {
    public static void coordinateLunchOptionsWithHash() {
        String [][] lunchMealTypeHash = {
                {  "Pizza", "Italian"}
                , {  "Curry", "Indian"}
                , {"Marsala", "Indian"}
        };
        String [][] userLunchOptionHash = {
                {"Jose", "Italian"}
                , {"John", "Indian"}
                , {"Sarah", "*"}
        };
        LunchMenuHashService lunchMenuService = new LunchMenuHashService();
        String [][] output = lunchMenuService.matchLunche(lunchMealTypeHash,userLunchOptionHash);
        for(int i = 0; i < output.length; i++) {
            System.out.println(output[i][0] + " is able to have " + output[i][1] + " for lunch");
        }
    }

    public String[][] matchLunche(String[][] lunchMenuPairs,
                                  String[][] teamCuisinePreference) {
        String [] [] pairings;
        Map<String, String> entreeCuisineHash = convertFromArrayToMap(lunchMenuPairs);
        Map<String, String> employeeCuisineHash = convertFromArrayToMap(teamCuisinePreference);
        Map<String, String> employeeEntryHash = findCuisineCorrelation(entreeCuisineHash,employeeCuisineHash);
        pairings = convertFromHashToArray(employeeEntryHash);
        return pairings;
    }

    private String[][] convertFromHashToArray(Map<String, String> employeeEntreeHash) {
        Set<String> employees = employeeEntreeHash.keySet();
        String[][] finalArrayList = new String[employees.size()][2];
        int employeeId = 0;
        for(String employee : employees){
            finalArrayList[employeeId][0] = employee;
            finalArrayList[employeeId][1] = employeeEntreeHash.get(employee);
            employeeId++;
        }
        return finalArrayList;
    }

    private Map<String, String> convertFromArrayToMap(String[][] matrix) {
        Map<String, String> hashMap = new HashMap<>();
        for(int row = 0; row < matrix.length; row++) {
            int length = matrix[row].length;
            hashMap.put(matrix[row][0],matrix[row][length-1]);
        }
        return hashMap;
    }

    private Map<String, String> findCuisineCorrelation(Map<String, String> entryCusines,  Map<String, String> emplyeeCusinePref) {
        Map<String, String> correlationResult = new HashMap<>();
        for(String employee : emplyeeCusinePref.keySet()) {
            StringBuffer cusineList = new StringBuffer();
            String employeeRequestedCuisine = emplyeeCusinePref.get(employee);

            if (Objects.nonNull(employeeRequestedCuisine)) {
                for (String entree : entryCusines.keySet()) {
                    if (employeeRequestedCuisine.equals("*") || employeeRequestedCuisine.equals(entryCusines.get(entree))) {
                        cusineList.append(entree+",");
                    }
                }
                correlationResult.put(employee,cusineList.deleteCharAt(cusineList.length()-1).toString());
            }
        }
        return correlationResult;
    }
}
