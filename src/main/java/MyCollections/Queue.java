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
public interface Queue<E> extends Iterable<E>{
    int size();
    boolean isEmpty();
    E first();
    void enqueue(E element);
    E dequeue();
}
