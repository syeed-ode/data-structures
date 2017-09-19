package com.syeedode.datastructures.collection.maps.affinity.service;

import com.syeedode.datastructures.collection.maps.affinity.dto.Affinity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Data Structures
 * String Comparison, Permutations and Manipulations
 * <p>
 * Author: syeedode
 * Date: 9/17/17
 */
public class AffinityFileReaderService {
    public static final String FILE_NAME = "/Users/syeedode/java_projects/data-structures/src/main/resources/affinityFile";

    public List<Affinity> readFileAndConvertToMap() {
        List<Affinity>  affinityList = new ArrayList<>();
        File affinityFile = new File(FILE_NAME);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String sCurrentLine = null;
        try {
            fileReader = new FileReader(affinityFile);
            bufferedReader = new BufferedReader(fileReader);
            while(Objects.nonNull(sCurrentLine = bufferedReader.readLine())) {
                String [] fileEntry = sCurrentLine.split(",");
                String siteVisited = fileEntry[0].replaceAll(" ", "");
                String clientUserName = fileEntry[1].replaceAll(" ", "");
                affinityList.add(Affinity.getInstance(clientUserName, siteVisited));
            }
            return affinityList;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(Objects.nonNull(bufferedReader)) {
                    bufferedReader.close();
                }
                if(Objects.nonNull(fileReader)) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return affinityList;
    }
}