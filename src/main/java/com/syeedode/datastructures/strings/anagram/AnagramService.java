package com.syeedode.datastructures.strings.anagram;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Data Structures
 * String Comparison, Permutations and Manipulations
 * <p>
 * Author: syeedode
 * Date: 9/16/17
 */
public class AnagramService {

    public AnagramService getInstance() {
        return new AnagramService();
    }

    private AnagramService() {

    }

    public static void findAnagram() {
        AnagramService service = new AnagramService();
        for(Integer i : service.calculateAnagramPosition("bcdaghbabcdaij","bcda")){
            System.out.println(i);
        }

    }

    public List<Integer> calculateAnagramPosition(String longString, String shortString) {
        List<Integer> anagramPositions = new ArrayList<>();
        boolean finished = false;
        if(StringUtils.isEmpty(longString) || StringUtils.isEmpty(shortString)) {
            return anagramPositions;
        }
        if(longString.length() < shortString.length()) {
            String string = shortString;
            shortString = longString;
            longString  = string;
        }
        int i = 0;
        while(!finished) {
            i = longString.indexOf(shortString, i);
            if(i > -1) {
                anagramPositions.add(i);
                i++;
            } else {
                finished = true;
            }
        }

        return anagramPositions;
    }
}
