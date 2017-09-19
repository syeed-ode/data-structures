package com.syeedode.datastructures.arrays.arrayobjectmanipulation;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Data Structures
 * String Comparison, Permutations and Manipulations
 * <p>
 * Author: syeedode
 * Date: 9/17/17
 */
public class ObjectArrayConverter {

    public void convertSetToObjectArray() {
        Set<Integer> integerSet = new HashSet<>();
        List<Integer> integerList = arrayToList(integerSet.toArray());
    }

    public static List arrayToList(Object source) {
        return Arrays.asList(toObjectArray(source));
    }

    public static Object[] toObjectArray(Object source) {
        if (source instanceof Object[]) {
            return (Object[]) source;
        }
        if (source == null) {
            return new Object[0];
        }
        if (!source.getClass().isArray()) {
            throw new IllegalArgumentException("Source is not an array: " + source);
        }
        int length = Array.getLength(source);
        if (length == 0) {
            return new Object[0];
        }
        Class<?> wrapperType = Array.get(source, 0).getClass();
        Object[] newArray = (Object[]) Array.newInstance(wrapperType, length);
        for (int i = 0; i < length; i++) {
            newArray[i] = Array.get(source, i);
        }
        return newArray;
    }
}
