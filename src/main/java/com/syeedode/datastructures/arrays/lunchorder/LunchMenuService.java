package com.syeedode.datastructures.arrays.lunchorder;

/**
 * Data Structures
 * Array Manipulations
 * <p>
 * Author: syeedode
 * Date: 9/16/17
 */
public class LunchMenuService {
    public static void coordinateLunchOptions() {
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
        LunchMenuService lunchMenuService = new LunchMenuService();
        String [][] output = lunchMenuService.pairUserWithMeal(lunchMealTypeHash,userLunchOptionHash);
        for(int i = 0; i < output.length; i++) {
            System.out.println(output[i][0] + " is able to have " + output[i][1] + "for lunch");
        }
    }

    private String [][] pairUserWithMeal(String[][] mealOptionWithType, String[][] userMealTypePreference){
        String [][] userWithMealOutput = new String[userMealTypePreference.length][mealOptionWithType.length];
        for(int user = 0; user < userWithMealOutput.length; user++) {
            StringBuffer stringBuffer = new StringBuffer();
            for(int mealType = 0; mealType < mealOptionWithType.length; mealType++) {
                String typeOfMeal = mealOptionWithType[mealType][1];
                if(userMealTypePreference[user][1].equals(typeOfMeal) || userMealTypePreference[user][1].equals("*")){
                    String mealItself = mealOptionWithType[mealType][0];
                    stringBuffer.append(mealItself + ", ");
                }
            }
            userWithMealOutput[user][0] = userMealTypePreference[user][0];
            userWithMealOutput[user][1] = stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length() -1).toString();
        }
        return userWithMealOutput;
    }
}
