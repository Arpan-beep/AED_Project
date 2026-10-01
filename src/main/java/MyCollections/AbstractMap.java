/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyCollections;

/**
 *
 * @author Paulo
 * @param <K>
 * @param <V>
 */
public abstract class AbstractMap<K, V> implements Map<K, V>{
    @Override
    public boolean isEmpty(){
        return size()==0;
    }
    
    // ===== nested class Entry definition
    protected class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K, V>>{
        private K k; // key
        private V v; // value
        
        Entry(K key, V value){
            k = key;
            v = value;
        }
        
        // public methods
        public K getKey(){
            return k;
        }
        
        public V getValue(){
            return v;
        }
        
        public void setKey(K key){
            k = key;
        }
        
        public V setValue(V value){
            V old = v;
            v = value;
            return old;
        }
        
        @Override
        public int compareTo(Entry<K, V> other){
            return k.compareTo(other.k);
        }
    }
}
