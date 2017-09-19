package com.syeedode.datastructures.linkedlist;

import java.util.Objects;

/**
 * Data Structures
 * LinkedList
 * <p>
 * Author: syeedode
 * Date: 9/18/17
 */
public class LinkedListService {

    public static LinkedList insert(LinkedList head, String value) {
        if(Objects.isNull(head)) {
            head = new LinkedList(value, 1);
        } else {
            LinkedList end = head;
            while (Objects.nonNull(end.getNext())) {
                end = end.getNext();
            }
            LinkedList node = new LinkedList(value,end.getLength() + 1);
            end.setNext(node);
            head.setLength(end.getNext().getLength());
        }
        return head;
    }

    public static LinkedList delete(LinkedList head, String value) {
        LinkedList node = head;
        if(node.getVal().equals(value)) {
            return head.getNext();
        }
        while (Objects.nonNull(node.getNext())) {
            if (node.getNext().getVal().equals(value)) {
                node.setNext(node.getNext().getNext());
                return head;
            }
            node = node.getNext();
        }
        return head;
    }

    public static void printLinkedList(LinkedList head) {
        if(Objects.nonNull(head)){
            System.out.print(head.getVal() + " ");
        }
        LinkedList end = head;
        while (Objects.nonNull(end.getNext())){
            end = end.getNext();
            System.out.print(end.getVal() + " ");
        }
        System.out.println("\r\n\r\n\r\n");
    }
}
