package com.syeedode.datastructures.collection;

/**
 * Data Structures
 * Concurrent Set
 * <p>
 * Author: syeedode
 * Date: 9/16/17
 */
public class SyeedsConcurrentSet<E> {
    private E [] array = (E[]) new Object[0];
    private int size;

    public void add(E element) {
        if(contains(element)){
            return;
        }
        if(size < array.length - 1) {
            synchronized (array) {
                array[size] = element;
                size++;
            }
        } else {
            increaseArraySize();
            add(element);
        }
    }

    private void increaseArraySize() {
        int sizeIncrease = array.length == 0 ? 1 : array.length * 2;
        E [] tempArray = array;
        synchronized(array) {
            array = (E[]) new Object[sizeIncrease];
            System.arraycopy(tempArray,0, array,0, tempArray.length);
        }
    }

    public boolean contains(E element){
        synchronized (array) {
            for(int i = 0; i < array.length; i++) {
                if(array[i] == element){
                    return true;
                }
            }
            return false;
        }
    }

    public void remove(E element) {
        boolean reshuffle = false;
        synchronized (array) {
            for(int i = 0; i < array.length; i++){
                if(reshuffle) {
                    array[i - 1] = array[i];
                } else if(array[i] == element) {
                    array[i] = null;
                    reshuffle = true;
                }
            }
        }
    }
}
