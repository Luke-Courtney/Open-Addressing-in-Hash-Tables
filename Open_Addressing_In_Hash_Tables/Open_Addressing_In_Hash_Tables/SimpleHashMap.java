import java.util.Iterator;

public class SimpleHashMap<K, V> implements SimpleMap<K, V>{

    public static enum CollisionStrategy{
        LINEAR_PROBING, QUADRATIC_PROBING, DOUBLE_HASHING
    }

    protected final static double DEFAULT_LOAD_FACTOR = 1.0;
    protected final static int MIN_TABLE_SIZE = 7;
    protected final static int DEFAULT_CAPACITY = 997; // not used
    protected final static CollisionStrategy DEFAULT_COLLISION_STRATEGY = CollisionStrategy.LINEAR_PROBING;
    protected double loadFactor;
    protected int size;
    protected int capacity;
    protected int probeCount;
    protected MapEntry<K, V>[] table;

    SimpleHashMap<K, V> map;

    protected SimpleHashMap(){
        // this(MIN_TABLE_SIZE, DEFAULT_LOAD_FACTOR,
        // CollisionStrategy.LINEAR_PROBING);
    }

    public SimpleHashMap(int initCapacity){
        this(initCapacity, DEFAULT_LOAD_FACTOR, DEFAULT_COLLISION_STRATEGY);
    }
    
    public SimpleHashMap(double loadFactor){
        this(MIN_TABLE_SIZE, loadFactor, DEFAULT_COLLISION_STRATEGY);
    }

    public SimpleHashMap(CollisionStrategy strategy){
        this(MIN_TABLE_SIZE, DEFAULT_LOAD_FACTOR, strategy);
    }

    public SimpleHashMap(int initCapacity, CollisionStrategy strategy){
            this(initCapacity, DEFAULT_LOAD_FACTOR, strategy);
    }
    
    public SimpleHashMap(double loadFactor, CollisionStrategy strategy){
        this(MIN_TABLE_SIZE, loadFactor, strategy);
    }
    
    public SimpleHashMap(int initCapacity, double loadFactor){
        this(initCapacity, loadFactor, DEFAULT_COLLISION_STRATEGY);
    }

    public SimpleHashMap(int initCapacity, double loadFactor,
            CollisionStrategy strategy){
        this.loadFactor = loadFactor;
        switch(strategy){
            case QUADRATIC_PROBING:
                map = new QuadraticProbingHashMap<K, V>(initCapacity,
                        loadFactor);
                break;
            case DOUBLE_HASHING:
                map = new DoubleHashingHashMap<K, V>(initCapacity, loadFactor);
                break;
            case LINEAR_PROBING:
            default:
                map = new LinearProbingHashMap<K, V>(initCapacity, loadFactor);
                break;
        }
    }

    @Override
    public int size(){
        return map.size;
    }

    @Override
    public boolean isEmpty(){
        return map.size == 0;
    }

    @Override
    public boolean containsKey(K key){
        return get(key) != null;
    }

    @Override
    public V get(K key){
        return map.get(key);
    }

    @Override
    public V put(K key, V value){
        return map.put(key, value);
    }

    @Override
    public V remove(K key){
        return map.remove(key);
    }

    // Clears all entries from the map
    // Haven't tested this but should work - try it!
    @Override
    public void clear(){
        for(int i = 0; i < map.capacity; i++){
            map.table[i] = null;
        }
        map.size = 0;
    }

    @Override
    public Iterator<K> iterator(){
        return new KeyIterator();
    }

    // Computes the primary hash function used by all implementations
    // to determine the "home" slot for a key
    protected int hash(K key){
        return Math.abs(key.hashCode() % capacity);
    }

    // Resizes the table to newCapacity by creating a new table
    // and putting all entries into the new table and
    // rehashing them to new table size in the process
    @SuppressWarnings("unchecked")
    protected void resize(int newCapacity){
        MapEntry<K, V>[] temp = table;

        table = (MapEntry<K, V>[]) new MapEntry[newCapacity];
        size = 0;
        capacity = newCapacity;

        for(MapEntry<K, V> entry : temp){
            if(entry != null){
                this.put(entry.key, entry.value);
            }
        }
    }

    public int probeCount(){
        return map.probeCount;
    }

    public int capacity(){
        return map.capacity;
    }

    public double loadLevel(){
        return (double) map.size / map.capacity;
    }

    // Prints the underlying table for a hashmap
    // This can be useful for testing
    // It is only really helpful when the table size is relatively small
    // and the are not to large - ideally integers less than 100
    public void printTable(){
        System.out.print("[");
        int i;
        for(i = 0; i < map.table.length - 1; i++){
            if(map.table[i] != null){
                //System.out.print(map.table[i]);
                 System.out.printf("%3d", map.table[i].key);
                System.out.print(",");
            } else{
                System.out.print("---,");
            }
        }
        if(map.table[i] != null){
            //System.out.print(map.table[i]);
            System.out.printf("%3d", map.table[i].key);
        } else{
            System.out.print("---");
        }
        System.out.print("]");
    }

    /*****************************************************************************
     * Methods for computing various prime numbers for determining table sizes
     * These don't really belong here and should really be refactored out into a
     * suitable external class but it keeps things simple for now
     *****************************************************************************/

    // Returns the next prime number at least as large as n
    // that congruent to 3 mod 4
    protected int nextSuitablePrime(int n){
        int prime = nextPrime(n);
        while(prime % 4 != 3){
            prime = nextPrime(prime + 1);
        }
        return prime;
    }

    // Returns the next prime number at least as large as n
    protected int nextPrime(int n){
        if(n <= 0){
            n = 3;
        }

        if(n % 2 == 0){
            n++;
        }

        for(; !isPrime(n); n += 2){
        }

        return n;
    }

    // Returns true in n is prime false otherwise
    protected boolean isPrime(int n){
        if(n == 2 || n == 3)
            return true;

        if(n == 1 || n % 2 == 0)
            return false;

        for(int i = 3; i * i <= n; i += 2)
            if(n % i == 0)
                return false;

        return true;
    }

    protected static class MapEntry<K, V> {

        protected K key;
        protected V value;
        protected boolean removed;

        public MapEntry(K key, V value){
            this.key = key;
            this.value = value;
            removed = false;
        }

        public String toString(){
            return "<" + key.toString() + "," + value.toString() + ">";
        }
    }

    protected final class KeyIterator implements Iterator<K>{

        int index;
        int found;
        MapEntry<K, V> current = null;

        KeyIterator(){
            index = 0;
            found = 0;
            current = null;

            // Move to first entry
            MapEntry<K, V>[] m = map.table;
            if(m != null && map.size > 0){
                for (index = 0; index < m.length; index++){
                    if ((current = m[index]) != null){          // && !(m[index]).reserved()){
                        //System.out.println("Stopping at: " + index);
                        //System.out.println(current);
                        found++;
                        break;
                    }
                    // For testing only - remove
                    else{
                        //System.out.println("Skipping: " + index);
                    }
                }
            }
        }

        // Okay - new problem
        // If last element is not null call to next() doesn't change it
        // and hasNext() get stuck in infinite loop
        @Override
        public boolean hasNext(){
            //System.out.println("Has next");
            return found != map.size;
        }

        @Override
        public K next(){
            MapEntry<K, V>[] m = map.table;
            for (index++; index < m.length; index++){
                if ((current = m[index]) != null){          // && !(m[index]).reserved()){
                    //System.out.println("Stopping at: " + index);
                    //System.out.println(current);
                    found++;
                    break;
                }
                //    For testing only - remove
                else{
                    //System.out.println("Skipping: " + index);
                }
            }

            return current.key;
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}