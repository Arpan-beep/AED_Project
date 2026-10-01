/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyCollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Paulo
 * @param <E>
 */
public class ArrayDeque<E> implements Deque<E> {
    private static int CAPACITY = 1000;
    private E[] data;
    private int f = 0;  // the index for the front element
    private int sz = 0;
    
    public ArrayDeque(){
        this(CAPACITY);
    }
    
    public ArrayDeque(int capacity){
        data = (E[]) new Object[capacity];
    }
    
    @Override
    public int size() {
        return sz;
    }

    @Override
    public boolean isEmpty() {
        return (sz == 0);
    }

    @Override
    public E first() {
        if (isEmpty()) return null;
        return data[f];
    }

    @Override
    public E last() {
        if (isEmpty()) return null;
        return data[(f+sz-1)%data.length];
    }

    @Override
    public void addFirst(E e) throws IllegalStateException {
        if (sz == data.length){
            throw new IllegalStateException("Deque is full!!");
        }
        f = (f+data.length-1) % data.length;
        data[f] = e;
        sz++;
    }

    @Override
    public void addLast(E e) throws IllegalStateException {
        if (sz == data.length){
            throw new IllegalStateException("Deque is full!!");
        }
        int avail = (f+sz) % data.length;
        data[avail] = e;
        sz++;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()) return null;
        E answer = data[f];
        data[f] = null;
        f = (f+1) % data.length;
        sz--;
        return answer;
    }

    @Override
    public E removeLast() {
        if(isEmpty()) return null;
        int r = (f+sz-1)%data.length;
        E answer = data[r];
        data[r] = null;
        sz--;
        return answer;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }
    
    // ----------------
    // neste class ArrayIterator
    private class ArrayIterator implements Iterator<E>{
        private int j;
        
        public ArrayIterator(){
            if (sz==0){
                j=-1;
            }else {
                j = f;
            }
        }
        
        @Override
        public boolean hasNext(){
            return j != -1;
        }
        
        @Override
        public E next(){
            if (j==-1){
                throw new NoSuchElementException("Without next element");
            }
            int j_actual = j;
            j = (j+1)%data.length;
            if(j==(f+sz)%data.length){
                j=-1;
            }
            return data[j_actual];
        }
    }   // end of ArrayIterator class
    
}
