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
 * @param <K>
 * @param <V>
 */
public class ArrayMap<K extends Comparable<K>, V> extends AbstractMap<K, V>{
    private static final int CAPACITY = 1000;
    private Entry<K, V>[] data;     // array used to save the entries
    private int sz = 0;
    
    // auxiliary method to compare one key with one entry
    private int compKE(K key, Entry<K,V> e){
        return key.compareTo(e.getKey());
    }
    
    public ArrayMap(){
        this(CAPACITY);
    }
    
    public ArrayMap(int capacity){
        data = (Entry<K, V>[]) new Entry[capacity];
    }
    
    @Override
    public int size(){
        return sz;
    }
    
    // returns the entry position with lower key
    private int ceilingEntry(K key){
        int i;
        for(i=0; i<sz && compKE(key, data[i])>0; i++){}
        return i;
    }
    
    /**
     *
     * @param key
     * @return
     */
    @Override
    public V get(K key){
        int i = ceilingEntry(key);
        if (i==sz) return null;
        else {
            if (compKE(key, data[i])==0){
                return data[i].getValue();
            } else return null;
        }
    }
    
    @Override
    public V put(K key, V value){
        if (size() == data.length && get(key)==null){
            throw new IllegalStateException("Map is full");
        }
        Entry<K, V> e = new Entry<>(key, value);
        int i = ceilingEntry(key);  // i: insert position
        
        V old;  // object to return 
        if(i==sz) old = null;
        else {
            if(compKE(key, data[i])==0){
                // the key already exists, the element 
                // in that position will be relaced
                old = data[i].getValue();
            }else {
                // the key doesn't exist yet.
                // the element is inserted into the position
                old = null;
                for(int k=sz; k>=i+1; k--){
                    data[k]=data[k-1];
                }
            }
        }
        data[i]=e;
        if(old==null) sz++;
        return old; 
    }
    
    @Override
    public V remove(K key){
        if(isEmpty()) return null;
        int i = ceilingEntry(key);
        if(i<sz && compKE(key, data[i])==0){
            // the element was found
            V old = data[i].getValue();
            for(int k=i; k<sz-2; k++){
                // move all entries to the left
                // after the position i+1
                data[k]=data[k+1];
            }
            sz--;
            data[sz]=null;
            return old;
        }else return null;
    }
    
    // nested class for keyset support
    private class KeyIterator implements Iterator<K>{
        private int j=0;
        
        @Override
        public boolean hasNext(){
            return (j<size());
        }
        
        @Override
        public K next(){
            if (j== size()) throw new NoSuchElementException("Without next element.");
            return data[j++].getKey();
        }
    }   // end KeyIterator class
    
    private class KeyIterable implements Iterable<K>{
        @Override
        public Iterator<K> iterator(){
            return new KeyIterator();
        }  
    }   // end KeyIterable class
    
    /**
     *
     * @return
     */
    @Override
    public Iterable<K> keySet(){
        return new KeyIterable();
    }
    
}   // end of the ArrayMap class





