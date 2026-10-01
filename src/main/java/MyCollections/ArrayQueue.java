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
public class ArrayQueue<E> implements Queue<E> {
    private static int CAPACITY = 1000;
    private E[] data;
    private int f = 0;  // index of the FRONT element
    private int sz = 0;
    
    public ArrayQueue(){
        this(CAPACITY);
    }
    
    public ArrayQueue(int capacity){
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
    public void enqueue(E element) throws IllegalStateException{
        if (sz == data.length) throw new IllegalStateException("Queue is full!");
        int avail = (f+sz)%data.length; // use modular aritmetic
        data[avail] = element;
        sz++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E answer = data[f];
        data[f] = null;     // dereference to help garbage collection
        f = (f+1)%data.length;
        sz--;
        return answer;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }
    
    // nested class ArrayIterator
    private class ArrayIterator implements Iterator<E>{
        private int j;
        
        public ArrayIterator(){
            if (sz==0){
                j = -1; // marks the end of iteration
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
            if (j==-1) throw new NoSuchElementException("Whithout next element!");
            int j_actual = j;
            j = (j+1)%data.length;
            if(j==(f+sz)%data.length){
                j = -1;
            }
            return data[j_actual];
        }
    }   // end of the nested class
    
}
