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
 */
public class LinkedQueue<E> implements Queue<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    
    public LinkedQueue(){}; // initial empty list
    
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public void enqueue(E element) {
        list.addLast(element);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
    
}
