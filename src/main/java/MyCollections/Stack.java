/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package MyCollections;

/**
 *
 * @author Paulo
 * @param <E>
 */
public interface Stack<E> extends Iterable<E>{
    int size();
    boolean isEmpty();
    E top();
    void push(E element);
    E pop();
}
