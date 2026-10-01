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
public class DoublyLinkedList<E> implements Iterable<E>{
    // ---------------- nested Node Class ----------------
    protected static class Node<E>{
        private E element;      // reference to the element stored at this node
        private Node<E>prev;    // reference to the previous node in the list
        private Node<E>next;    // reference to the subsequent node in the list
        
        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }
        
        public E getElement(){
            return element;
        }
        
        public Node<E> getPrev(){
            return prev;
        }
        
        public Node<E> getNext(){
            return next;
        }
        
        public void setElement(E e){
            element = e;
        }
        
        public void setPrev(Node<E> p){
            prev = p;
        }
        
        public void setNext(Node<E> n){
            next = n;
        }
    }   // end of the nested class Node

    protected Node<E> header; // header sentinel
    protected Node<E> tailer; // tailer sentinel
    private int size = 0;   // number of elements in the list
    
    // constructors and other methods
    public DoublyLinkedList(){
        header = new Node<>(null, null, null);   // create header
        tailer = new Node<>(null, header, null); // tailer preceded by header
        header.setNext(tailer); // header is followed by tailer
    }
    
    // access methods
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public E first(){   // returns (but does not remove) the first element
        if(isEmpty()) return null;
        return header.getNext().getElement();
    }
    
    public E last(){    // returns (but does not remove) the last element
        if(isEmpty()) return null;
        return tailer.getPrev().getElement();
    }
    
    // update methods
    
    // adds element e to the linked list
    // in between the given nodes
    protected void addBetween(E e, Node<E> predecessor, Node<E> sucessor){
        Node<E> newest = new Node<>(e, predecessor, sucessor);
        predecessor.setNext(newest);
        sucessor.setPrev(newest);
        size++;
    }
    
    public void addFirst(E e){  // adds element e to the front of the list
        addBetween(e,header, header.getNext());
    }
           
    public void addLast(E e){   // adds element e to the end of the list
        addBetween(e,tailer, tailer.getPrev());
    }
    
    protected E remove(Node<E> n){
        Node<E> predecessor = n.getPrev();
        Node<E> sucessor = n.getNext();
        
        predecessor.setNext(sucessor);
        sucessor.setPrev(predecessor);
        size--;
        return n.getElement();
    }
    
    public E removeFirst(){ // removes and returns the first element
        if (isEmpty()) return null; // nothing to remove
        return remove(header.getNext());
    }
    
    public E removeLast(){ // removes and returns the last element
        if (isEmpty()) return null; // nothing to remove
        return remove(tailer.getPrev());
    }
    
    @Override
    public Iterator<E> iterator(){
        return new DLLIterator();   // this is the interface Iterable method
    }
    
    // ==================
    // internal class DLLItertor
    
    private class DLLIterator implements Iterator<E>{
        private Node<E> cursor = header.getNext();  // reference for the Node with the next element to be returned by next method
        
        @Override
        public boolean hasNext(){
            return cursor != tailer;
        }
        
        @Override
        public E next(){
            if (cursor == tailer) throw new NoSuchElementException("Whithout next  element!");
            Node<E> current = cursor;
            cursor=cursor.getNext();
            return current.getElement();
        }
    }   // end of the internal class SLLIteraror
    
}   // END of the DoublyLinkedList
