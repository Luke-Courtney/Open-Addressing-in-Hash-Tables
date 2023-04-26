public interface SimpleMap<K, V> extends Iterable<K>{
    
    public int size();
    
    public boolean isEmpty();
    
    public boolean containsKey(K key);
    
    public void clear();
    
    public V get(K key);
    
    public V put(K key, V value);
    
    public V remove(K key);
}