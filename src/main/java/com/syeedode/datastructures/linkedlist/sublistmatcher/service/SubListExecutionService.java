package com.syeedode.datastructures.linkedlist.sublistmatcher.service;

import com.syeedode.datastructures.linkedlist.LinkedList;
import com.syeedode.datastructures.linkedlist.sublistmatcher.dto.SubListMatcherDto;

import static com.syeedode.datastructures.linkedlist.LinkedListService.delete;
import static com.syeedode.datastructures.linkedlist.LinkedListService.printLinkedList;
import static com.syeedode.datastructures.linkedlist.sublistmatcher.file.LinkedListFileService.getProcessingList;

/**
 * Data Structures
 * LinkedList - See if there is a match between sublist and main list
 * <p>
 * Author: syeedode
 * Date: 9/18/17
 */
public class SubListExecutionService {
    public static void executeSublistMatch(){
        SubListMatchingService subListMatchingService = new SubListMatchingService();
        SubListMatcherDto processingList = getProcessingList();
        int i = subListMatchingService.findSublistWithinList(processingList);

        System.out.println("Recevied a match at: " + i + "\r\n\r\n\r\n");
        printLinkedList(processingList.getMainList());

        LinkedList newList = delete(processingList.getMainList(), "roof,");
        printLinkedList(newList);
    }
}
