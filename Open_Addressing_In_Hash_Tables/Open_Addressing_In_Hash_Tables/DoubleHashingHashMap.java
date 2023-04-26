public class DoubleHashingHashMap<K, V> extends SimpleHashMap<K, V>{
  
    @SuppressWarnings("unchecked")
    public DoubleHashingHashMap(int initCapacity, double loadFactor){
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
            index = (initialIndex + (hash2(key) * i)) % capacity;
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
        for (index = initialIndex; table[index] != null; i++) { //If theres a collision
            probeCount++;
            
            if ((table[index].key).equals(key)) { //If the key is already in the table
                oldValue = table[index].value;
                table[index].value = value;
                return oldValue;
            } 
            index = (initialIndex + (hash2(key) * i)) % capacity;
            //System.out.println(hash2(key) + " * " + i + "\t\t" + initialIndex + " > " + index); //Prints double hash result and change to initialIndex
        }
        
        // Otherwise add new entry and increment size
        probeCount++;
        table[index] = new MapEntry<K,V>(key, value);
        size++;
       
        return oldValue;
    }
    
    protected int hash2(K key){
        int R = 7;
        int keyHash = key.hashCode();
        int hash2 = (R - (keyHash % R)) + 1;
        return hash2;
    }
}