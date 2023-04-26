public class QuadraticProbingHashMap<K, V> extends SimpleHashMap<K, V>{

    
    // DON'T CHANGE THIS - Bad things might happen
    @SuppressWarnings("unchecked")
    public QuadraticProbingHashMap(int initCapacity, double loadFactor){
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
 
    // Returns the value associated with the specified key
    // if it is present, returns null otherwise
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
            
            //Setting new index after each loop
            if(i%2 == 0){ //If i is even (Every second loop)
                index = (initialIndex - i * i) % capacity;
                if(index < 0){
                    index = index + capacity;
                }
            }else{
                index = (initialIndex + i * i) % capacity;
            }
        }
        probeCount++;
        return null;
    }


    // Inserts the specified key/value pair into this map.
    // If the key is already present, returns the old value associated with the key if it is present,
    // returns null otherwise
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
        int initialIndex = hash(key); //initIndex = hash of given key
        //System.out.println("init Index: " + initialIndex);

        // If key is already present - update value and return old value
        for (index = initialIndex; table[index] != null; i++) {//If index is not empty (collision)
            probeCount++;
            
            if ((table[index].key).equals(key)) { //If key at index == given key
                oldValue = table[index].value;    //oldValue = value at index
                table[index].value = value;       //value at index = given value
                return oldValue;                  //Returns oldValue (End)
            }

            //Setting new index after each loop
            if(i%2 == 0){ //If i is even (Every second loop)
                index = (initialIndex - i * i) % capacity;
                if(index < 0){
                    index = index + capacity;
                }
            }else{
                index = (initialIndex + i * i) % capacity;
            }
            //System.out.println("Index: " + index);
        }
        
        // Otherwise add new entry and increment size
        probeCount++;
        table[index] = new MapEntry<K,V>(key, value);
        size++;
       
        return oldValue; //Returns oldValue (End)
    }
}