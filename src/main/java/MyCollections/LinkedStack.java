/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyCollections;

import MyCollections.linkedlists.SinglyLinkedList;
import java.util.Iterator;

/**
 *
 * @author Paulo
 * @param <E>
 */
public class LinkedStack<E> implements Stack<E>{
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();    // an empty list
    
    public LinkedStack(){}  // new stack relies on the initially empty list
    
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public E top() {
        return list.first();
    }

    /**
     *
     * @param element
     */
    @Override
    public void push(E element) {
        list.addFirst(element);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }
    
    @Override
    public Iterator<E> iterator(){
        return list.iterator();
    }
    
}
