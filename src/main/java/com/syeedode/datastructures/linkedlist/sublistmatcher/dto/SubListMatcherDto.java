package com.syeedode.datastructures.linkedlist.sublistmatcher.dto;

import com.syeedode.datastructures.linkedlist.LinkedList;

/**
 * Data Structures
 * LinkedList - See if there is a match between sublist and main list
 * <p>
 * Author: syeedode
 * Date: 9/18/17
 */
public class SubListMatcherDto {
    private final LinkedList mainList;
    private final LinkedList subList;
    private final LinkedList initialSubList;
    private final boolean listStarted;
    private final boolean foundMatch;
    private final int numberOfNodesToMatch;
    private final int numberOfMatchingNodes;
    private final int currentPostionCounter;

    /** * Constructor */
    protected SubListMatcherDto(SubListMatcherBuilder builder) {
        this.mainList = builder.getMainList();
        this.subList = builder.getSubList();
        this.initialSubList = builder.getInitialSubList();
        this.listStarted = builder.isListStarted();
        this.foundMatch = builder.isFoundMatch();
        this.numberOfNodesToMatch = builder.getNumberOfNnodesInSubListToMatch();
        this.numberOfMatchingNodes = builder.getNumberOfMatchingNodes();
        this.currentPostionCounter = builder.getCurrentPostionCounter();
    }

    /** * Getters */
    public LinkedList getMainList() {
        return mainList;
    }

    public LinkedList getSubList() {
        return subList;
    }

    public boolean isListStarted() {
        return listStarted;
    }

    public int getNumberOfNodesToMatch() {
        return numberOfNodesToMatch;
    }

    public LinkedList getInitialSubList() {
        return initialSubList;
    }

    public boolean foundMatch() {
        return foundMatch;
    }

    public int getNumberOfMatchingNodes() {
        return numberOfMatchingNodes;
    }

    public int getCurrentPostionCounter() {
        return currentPostionCounter;
    }
}
