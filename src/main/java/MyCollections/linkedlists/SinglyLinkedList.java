/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyCollections.linkedlists;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Paulo
 * @param <E>
 */
public class SinglyLinkedList<E> implements Iterable<E>{
    // ---------------- nested Node Class ----------------
    private static class Node<E>{
        private final E element;      // reference to the element stored at this node
        private Node<E>next;    // reference to the subsequent node in the list
        
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
        
        public E getElement(){
            return element;
        }
        
        public Node<E> getNext(){
            return next;
        }
        
        public void setNext(Node<E> n){
            next = n;
        }
    }   // end of the nested class Node

    // instance variables of the SinglyLinkedList
    private Node<E> head = null;    // head node of the list (or null if its empty)
    private Node<E> tail = null;    // last node of the list (or null if its empty)
    private int size = 0;           // the number of nodes in the list
    
    // constructors and methods of SinglyLinkedLÇist
public SinglyLinkedList(){} // constructs an initially empty list
    
    // access methods
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public E first(){   // returns (but does not remove) the first element
        if(isEmpty()) return null;
        return head.getElement();
    }
    
    public E last(){    // returns (but does not remove) the last element
        if(isEmpty()) return null;
        return tail.getElement();
    }
    
    // update methods
    public void addFirst(E e){  // adds element e to the front of the list
        head = new Node<>(e, head); // create and link a new node
        if(size==0){
            tail = head;    // special case: new node becomes tail also
        }
        size++;
    }
           
    public void addLast(E e){   // adds element e to the end of the list
        Node<E> newest = new Node<>(e, null);   // node will eventually be the tail
        if(isEmpty()){
            head = newest;  // special case: previously empty list
        }else {
            tail.setNext(newest);   // new node after existing tail
        }
        tail = newest;  // new node becomes the tail
        size++;
    }
    
    public E removeFirst(){ // removes and returns the first element
        if (isEmpty()) return null; // nothing to remove
        E answer = head.getElement();
        head =head.getNext();   // will become null if the list had only one node
        size--;
        if(size==0){
            tail = null;    // special case: list is now empty
        }
        return answer;
    }
    
    // make the collection iterable

    /**
     *
     * @return
     */
    @Override
    public Iterator<E> iterator(){
        return new SLLIterator();   // this is the interface Iterable method
    }
    
    // ==================
    // internal class SLLItertor
    
    private class SLLIterator implements Iterator<E>{
        private Node<E> cursor = head;  // reference for the Node with the next element to be returned by next method
        
        @Override
        public boolean hasNext(){
            return cursor != null;
        }
        
        @Override
        public E next(){
            if (cursor == null) throw new NoSuchElementException("Whithout next  element!");
            Node<E> current = cursor;
            cursor=cursor.getNext();
            return current.getElement();
        }
    }   // end of the internal class SLLIteraror
}   // end of the SinglyLinkedList class
