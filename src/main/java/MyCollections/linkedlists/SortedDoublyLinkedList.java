/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyCollections.linkedlists;

/**
 *
 * @author paulo
 * @param <E>
 */
public class SortedDoublyLinkedList<E extends Comparable<E>> extends DoublyLinkedList<E>{
    /*
    auxiliary private method that searchs the node with the lower element
    */
    private Node<E> ceilingNode(E e){
        Node<E> n = header.getNext();
        while(n!=tailer && e.compareTo(n.getElement())>0){
            n = n.getNext();
        }
        return n;
    }
    
    // return null if not found any value considered equal
    public E find(E e){
        Node<E> n=ceilingNode(e);
        if(n!=tailer && e.compareTo(n.getElement())==0){
            return n.getElement();
        }else 
            return null;
    }

    // public update methods
    public void add(E e){
        Node<E> n=ceilingNode(e);
        addBetween(e, n.getPrev(), n);  // place just before n
    }
    
    @Override
    public void addFirst(E e){
        throw new UnsupportedOperationException("Inserted method not allowed in an sorted list.");
    }
    
    @Override
    public void addLast(E e){
        throw new UnsupportedOperationException("Inserted method not allowed in an sorted list.");
    }
    
    public E put(E e){
        Node<E> n=ceilingNode(e);
        if(n!=tailer && e.compareTo(n.getElement())==0){
            E old = n.getElement();
            n.setElement(e);
            return old;
        }else{
            addBetween(e, n.getPrev(), n);
            return null;
        }
    }
    
    public E remove(E e){
        Node<E> n = ceilingNode(e);
        if(n!=tailer && e.compareTo(n.getElement())==0){
            return remove(n);
        }else return null;
    }

}





