package com.syeedode.datastructures.linkedlist.sublistmatcher.file;

import com.syeedode.datastructures.linkedlist.LinkedList;
import com.syeedode.datastructures.linkedlist.sublistmatcher.dto.SubListMatcherBuilder;
import com.syeedode.datastructures.linkedlist.sublistmatcher.dto.SubListMatcherDto;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import static com.syeedode.datastructures.linkedlist.LinkedListService.insert;

/**
 * Data Structures
 * LinkedList
 * <p>
 * Author: syeedode
 * Date: 9/18/17
 */
public class LinkedListFileService {
    public static final String FILE_NAME = "/Users/syeedode/java_projects/data-structures/src/main/resources/linkedList";

    public static SubListMatcherDto getProcessingList() {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(FILE_NAME));
            String value, originalListLine = br.readLine();
            LinkedList currentList = null;

            for(String listItem : originalListLine.split(" ")) {
                value = listItem.replaceAll(" ", "");
                if(StringUtils.isEmpty(value)) continue;
                currentList = insert(currentList, value);
            }

            if(currentList.getLength() < 2) {
                System.out.println("Must be at least two nodes");
                System.exit(0);
            }
            System.out.println(originalListLine);

            String secondLine = br.readLine();
            LinkedList nextList = null;
            for(String listItem : secondLine.split(" ")) {
                value = listItem.replaceAll(" ", "");
                if(StringUtils.isEmpty(value)) continue;
                nextList = insert(nextList, value);
            }
            int minumLentth = nextList.getLength();
            if(minumLentth < 2) {
                System.out.println("Must be at least two nodes");
                System.exit(0);
            }
            System.out.println(secondLine);
            if(currentList.getLength() > nextList.getLength()) {
                if(minumLentth > 2) {
                    minumLentth = 3;
                }
                return new SubListMatcherBuilder(currentList, nextList, minumLentth).build();
            } else {
                return new SubListMatcherBuilder(nextList, currentList).build();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(Objects.nonNull(br)) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new SubListMatcherBuilder(null, null).build();
    }
}
