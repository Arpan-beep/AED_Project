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
public class ArrayStack<E> implements Stack<E> {
    // default array capacity
    private static int CAPACITY = 1000;
    private E[] data;   // generic array used for storage
    private int t = -1; // index of the top element in the stack
    
    public ArrayStack(){
        // default array capacity
        this(CAPACITY);
    }
    
    public ArrayStack(int capacity){
        // safe cast;compiler may give warning here
        data = (E[]) new Object[capacity];
    }
    
    @Override
    public int size() {
        return (t+1);
    }

    @Override
    public boolean isEmpty() {
       return (t==-1);
    }

    @Override
    public E top() {
        if(isEmpty()) return null;
        return data[t];
    }

    @Override
    public void push(E element) throws IllegalStateException{
        if(size() == data.length) {
            throw new IllegalStateException("Stack is full!");
        }
        data[++t] = element;    // increment t before storing the item
    }

    @Override
    public E pop() {
        if(isEmpty()) return null;
        E answer = data[t];
        data[t] = null; // dereferenced with help of garbage collection
        t--;
        return answer;
    }
    
    /**
     *
     * @return
     */
    @Override
    public Iterator<E> iterator(){
        return new ArrayIterator();
    }
    
    // ==================
    // internal class ArrayItertor
    
    private class ArrayIterator implements Iterator<E>{
        private int j = 0;
        
        @Override
        public boolean hasNext(){
            return j < size();
        }
        
        @Override
        public E next(){
            if (j == size()) throw new NoSuchElementException("Whithout next  element!");
            return data[j++];
        }
    }   // end of the internal class SLLIteraror
    
    
}   // end of the class ArrayStack
