package com.syeedode.datastructures.linkedlist.sublistmatcher.service;

import com.syeedode.datastructures.linkedlist.sublistmatcher.dto.SubListMatcherBuilder;
import com.syeedode.datastructures.linkedlist.sublistmatcher.dto.SubListMatcherDto;

import java.util.Objects;

/**
 * Data Structures
 * LinkedList - See if there is a match between sublist and main list
 * <p>
 * Author: syeedode
 * Date: 9/18/17
 */
public class SubListMatchingService {

    public int findSublistWithinList(SubListMatcherDto dto) {
        Integer temp = 0;
        SubListMatcherBuilder builder = new SubListMatcherBuilder(dto);

        if(!dto.isListStarted()) {
            builder.initialSubList(dto.getSubList())
                    .listStarted(true);
        }

        while(Objects.nonNull(dto.getSubList())) {
            if(Objects.isNull(dto.getMainList())) return dto.getNumberOfMatchingNodes();

            if(dto.getMainList().equals(dto.getSubList())) {
                builder.foundMatch(true)
                        .incCurrentPostionCounter()
                        .incrementNumberOfMatchingNodes();

                temp = hasCompletedSearchingNodes(dto, builder);
                if (Objects.nonNull(temp)) {
                    return builder.getCurrentPostionCounter() - builder.getSubList().getLength();
                }

                builder.mainList(dto.getMainList().getNext())
                        .subList(dto.getSubList().getNext());

                return findSublistWithinList(builder.build());
            } else if(dto.foundMatch()) {
                builder.foundMatch(false)
                        .numberOfMatchingNodes(0)
                        .mainList(dto.getMainList().getNext())
                        .incCurrentPostionCounter()
                        .subList(builder.getInitialSubList());

                return findSublistWithinList(builder.build());
            } else {
                builder.mainList(dto.getMainList().getNext())
                        .incCurrentPostionCounter()
                        .subList(dto.getSubList());

                return findSublistWithinList(builder.build());
            }
        }
        return temp;
    }

    private Integer hasCompletedSearchingNodes(SubListMatcherDto dto, SubListMatcherBuilder builder) {
        int temp;
        if(Objects.isNull(dto.getSubList().getNext()) || matchedMaximNumberOfNodes(dto)) {
            temp = dto.getNumberOfMatchingNodes();
            builder.numberOfMatchingNodes(0);
            return temp;
        }
        return null;
    }

    private boolean matchedMaximNumberOfNodes(SubListMatcherDto dto) {
        return dto.getNumberOfNodesToMatch() > 0 &&
                dto.getNumberOfMatchingNodes() >= dto.getNumberOfNodesToMatch();
    }
}
