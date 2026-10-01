/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyCollections;

import MyCollections.linkedlists.SortedDoublyLinkedList;
import java.util.Iterator;

/**
 *
 * @author paulo
 * @param <K>
 * @param <V>
 */
public class LinkedMap<K extends Comparable<K>, V> extends AbstractMap<K, V>{
    private SortedDoublyLinkedList<Entry<K, V>> list;
    
    public LinkedMap(){
        list = new SortedDoublyLinkedList<>();
    }
    
    @Override
    public int size(){
        return list.size();
    }
    
    @Override
    public V get(K key){
        Entry<K, V> e = new Entry<>(key, null);
        Entry<K,V> f = list.find(e);
        if(f==null) return null;
        else return f.getValue();
    }

    @Override
    public V put(K key, V value) {
        Entry<K, V> e = new Entry<>(key, value);
        Entry<K,V> f = list.put(e);
        if(f==null) return null;
        else return f.getValue();
    }

    @Override
    public V remove(K key) {
        Entry<K, V> e = new Entry<>(key, null);
        Entry<K,V> f = list.remove(e);
        if(f==null) return null;
        else return f.getValue();
    }
    
    private class KeyIterator implements Iterator<K>{
        private Iterator<Entry<K,V>> entries = list.iterator();
        @Override
        public boolean hasNext(){
            return entries.hasNext();
        }
        @Override
        public K next(){
            return entries.next().getKey();
        }
    }   // END of KeyIterator class
    
    private class KeyIterable implements Iterable<K>{
        @Override
        public Iterator<K> iterator(){
            return new KeyIterator();
        }
    }

    @Override
    public Iterable<K> keySet() {
        return new KeyIterable();
    }
  
} // end of LinkedMap class














