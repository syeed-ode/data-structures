package com.syeedode.datastructures.linkedlist.sublistmatcher.dto;

import com.syeedode.datastructures.linkedlist.LinkedList;

import static com.syeedode.datastructures.linkedlist.LinkedList.MINIMUM_NODES;

/**
 * Data Structures
 * LinkedList - See if there is a match between sublist and main list
 * <p>
 * Author: syeedode
 * Date: 9/18/17
 */
public class SubListMatcherBuilder {
    private LinkedList mainList;
    private LinkedList subList;
    private LinkedList initialSubList;
    private boolean listStarted;
    private boolean foundMatch;
    private int numberOfNnodesInSubListToMatch;
    private int numberOfMatchingNodes;
    private int currentPostionCounter;

    /** Factory method */
    public SubListMatcherDto build(){
        return new SubListMatcherDto(this);
    }



    /** * Contructors */
    public SubListMatcherBuilder(SubListMatcherDto dto) {
        this.mainList = dto.getMainList();
        this.subList = dto.getSubList();
        this.initialSubList = dto.getInitialSubList();
        this.listStarted = dto.isListStarted();
        this.foundMatch = dto.foundMatch();
        this.initialSubList = dto.getInitialSubList();
        this.numberOfNnodesInSubListToMatch = dto.getNumberOfNodesToMatch();
        this.numberOfMatchingNodes = dto.getNumberOfMatchingNodes();
        this.currentPostionCounter = dto.getCurrentPostionCounter();
    }

    public SubListMatcherBuilder(LinkedList main, LinkedList sub) {
        this.mainList = main;
        this.subList = sub;
        this.numberOfNnodesInSubListToMatch = MINIMUM_NODES;
    }

    public SubListMatcherBuilder(LinkedList main, LinkedList sub, int numberOfNodesToMatch) {
        this.mainList = main;
        this.subList = sub;
        this.numberOfNnodesInSubListToMatch = numberOfNodesToMatch;
    }


    /** * Builders */
    public SubListMatcherBuilder mainList(LinkedList mainList){
        this.mainList = mainList;
        return this;
    }
    public SubListMatcherBuilder subList(LinkedList subList){
        this.subList = subList;
        return this;
    }
    public SubListMatcherBuilder initialSubList(LinkedList initialSubList){
        this.initialSubList = initialSubList;
        return this;
    }
    public SubListMatcherBuilder listStarted(boolean listStarted){
        this.listStarted = listStarted;
        return this;
    }
    public SubListMatcherBuilder foundMatch(boolean foundMatch){
        this.foundMatch = foundMatch;
        return this;
    }
    public SubListMatcherBuilder numberOfNnodesInSubListToMatch(int numberOfNnodesInSubListToMatch){
        this.numberOfNnodesInSubListToMatch = numberOfNnodesInSubListToMatch;
        return this;
    }
    public SubListMatcherBuilder numberOfMatchingNodes(int numberOfMatchingNodes){
        this.numberOfMatchingNodes = numberOfMatchingNodes;
        return this;
    }
    public SubListMatcherBuilder incrementNumberOfMatchingNodes(){
        this.numberOfMatchingNodes++;
        return this;
    }
    public SubListMatcherBuilder currentPostionCounter(int currentPostionCounter){
        this.currentPostionCounter = currentPostionCounter;
        return this;
    }
    public SubListMatcherBuilder incCurrentPostionCounter(){
        this.currentPostionCounter++;
        return this;
    }



    /** * Getters */
    public LinkedList getMainList() {
        return mainList;
    }

    public void setMainList(LinkedList mainList) { this.mainList = mainList; }

    public LinkedList getSubList() {
        return subList;
    }

    public LinkedList getInitialSubList() {
        return initialSubList;
    }

    public boolean isListStarted() {
        return listStarted;
    }

    public boolean isFoundMatch() {
        return foundMatch;
    }

    public int getNumberOfNnodesInSubListToMatch() {
        return numberOfNnodesInSubListToMatch;
    }

    public int getNumberOfMatchingNodes() {
        return numberOfMatchingNodes;
    }

    public int getCurrentPostionCounter() {
        return currentPostionCounter;
    }
}
