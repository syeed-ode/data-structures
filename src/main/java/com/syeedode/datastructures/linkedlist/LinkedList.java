package com.syeedode.datastructures.linkedlist;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Data Structures
 * LinkedList
 * <p>
 * Author: syeedode
 * Date: 9/18/17
 */
public class LinkedList {
    public static final Integer MINIMUM_NODES = 2;

    private String val;
    private LinkedList next;
    private AtomicInteger length;


    /** * Constructors */
    public LinkedList(String node_value, int i) {
        val = node_value;
        next = null;
        length = new AtomicInteger(i);
    }


    /** * Getters */
    public String getVal() {
        return val;
    }

    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }

    public void setLength(int i) {
        this.length.set(i);
    }

    public int getLength() {
        return length.get();
    }


    /** * Methods */
    @Override
    public boolean equals(Object o) {
        LinkedList that = (LinkedList) o;

        if(Objects.isNull(that)) return false;

        if(this == that) return true;

        if(Objects.nonNull(val) && this.val.equals(that.val)){
            return true;
        }

        return false;
    }

}
