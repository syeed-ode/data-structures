package com.syeedode.datastructures.arrays.uniqstring;

import org.springframework.util.StringUtils;

/**
 * Data Structures
 * Array Manipulations
 * <p>
 * Author: syeedode
 * Date: 9/16/17
 */
public class UniqArrayCharactersService {


    public static UniqArrayCharactersService getInstance() {
        return new UniqArrayCharactersService();
    }

    private UniqArrayCharactersService(){

    }

    public static void hasUniqChars(String testString) {
        UniqArrayCharactersService service = getInstance();
        boolean uniq = service.characterArrayHasOnlyUniqCharacters(testString);
        System.out.println("\"" + testString + "\"" + (uniq ? " has " : " does not have ") + "all uniq characters");
    }

    private boolean characterArrayHasOnlyUniqCharacters(String str) {
        if(StringUtils.isEmpty(str)) return true;

        char [] characterArray = str.toCharArray();

        boolean [] charHasBeenSeen = new boolean[128];

        for(int i = 0; i < characterArray.length; i++) {
            char charUnderEvaluation = characterArray[i];
            if(charHasBeenSeen[charUnderEvaluation]) {
                return false;
            }
            charHasBeenSeen[charUnderEvaluation] = true;
        }
        return true;
    }
}
