public class LinearProbingHashMap<K,V> extends SimpleHashMap<K, V>{
    
    //private final double LOAD_FACTOR = 0.5;
    
    @SuppressWarnings("unused")
    private LinearProbingHashMap(){
    }
     
    @SuppressWarnings("unchecked")
    public LinearProbingHashMap(int initCapacity, double loadFactor){
        size = 0;
        this.loadFactor = loadFactor;
        if (initCapacity < MIN_TABLE_SIZE){
            capacity = MIN_TABLE_SIZE;
        }
        else{
            capacity = nextSuitablePrime(initCapacity);
        }
        table = (MapEntry<K,V> []) new MapEntry[capacity];
    }
    
    @Override
    public V get(K key){
        if (key == null)
            throw new IllegalArgumentException("Keys cannot be null");
        
        probeCount = 0;
        int index;
        int i = 1;
        int initialIndex = hash(key);
        for (index = initialIndex; table[index] != null && i <= capacity; i++){
            probeCount++;
            if((table[index].key).equals(key)){
                return table[index].value;
            }
            index = (initialIndex + i) % capacity;
        }
        probeCount++;
        return null;
    }

    @Override
    public V put(K key, V value){
        V oldValue = null;
        
        if (key == null)
            throw new IllegalArgumentException("Keys cannot be null");
        
        // Check if table is too full first and resize if needed
        if (size >= capacity * loadFactor){
            resize(nextSuitablePrime(2 * capacity));
        }
        
        probeCount = 0;
        int index;
        int i = 1;
        int initialIndex = hash(key);

        // If key is already present - update value and return old value
        for (index = initialIndex; table[index] != null; i++) {
            probeCount++;
            
            if ((table[index].key).equals(key)) {
                oldValue = table[index].value;
                table[index].value = value;
                return oldValue;
            }
            index = (initialIndex + i) % capacity;
        }
        
        // Otherwise add new entry and increment size
        probeCount++;
        table[index] = new MapEntry<K,V>(key, value);
        size++;
       
        return oldValue;
    }
    
    public V remove(K key){
        V removedValue = null;
        
        if (key == null)
            throw new IllegalArgumentException("Keys cannot be null");

        return removedValue;
    }
}