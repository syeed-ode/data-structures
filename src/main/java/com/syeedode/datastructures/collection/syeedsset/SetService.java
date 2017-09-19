package com.syeedode.datastructures.collection.syeedsset;

/**
 * Data Structures
 * Concurrent Set
 * <p>
 * Author: syeedode
 * Date: 9/16/17
 */
public class SetService {
    public static void executeSet() {
        SyeedsConcurrentSet<Integer> synchronizedSet = new SyeedsConcurrentSet<>();
        synchronizedSet.add(24);
        synchronizedSet.add(22);
        synchronizedSet.add(5);
        System.out.println(synchronizedSet);
        synchronizedSet.remove(3);
        synchronizedSet.remove(5);
        System.out.println(synchronizedSet);
        System.out.println("This set " + (synchronizedSet.contains(22) ? "contains: 22" : "doesn't contain 22"));
    }
}
