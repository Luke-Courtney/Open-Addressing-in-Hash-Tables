import java.util.Random;

public class SimpleTest{

    static SimpleHashMap<Integer, Integer> map;
    static int initialCapacity = 100;
    static double loadFactor = 0.7;
    static Random rng = new Random();
    static int[] values = {5, 8, 22, 30, 36};

    // Example of using a HashMap
    // To use Quadratic Probing or Double Hashing change the collision strategy
    // to
    // SimpleHashMap.CollisionStrategy.QUADRATIC_PROBING and
    // SimpleHashMap.CollisionStrategy.DOUBLE_HASHING respectively
    public static void main(String[] args){
        simpleTest();
        randomTest();
        growTest();
        capacityTest();
        loadTest();
    }

    public static void simpleTest(){
        // A HashMap that uses Linear Probing, a default capacity of 7 and a
        // default load factor of 1
        map = new SimpleHashMap<Integer, Integer>(SimpleHashMap.CollisionStrategy.LINEAR_PROBING);

        System.out.println("Simple Test");
        System.out.println("-----------");

        // Print out the values array - can be useful when debugging
        // especially when generating random keys - see example below
        System.out.print("Keys: ");
        for(int i = 0; i < values.length - 1; i++){
            System.out.print(values[i] + ",");
        }
        System.out.print(values[values.length - 1]);
        System.out.println();

        System.out.println("\nLinear Probing");
        map.printTable();       // printTable() prints the underlying table - use only for small examples
        System.out.println();   // printTable() doesn't terminate with a '\n'

        // put all values into the map
        // Here the key and value are the same - all searching is done of keys
        // so I don't care about the value for testing
        System.out.println("\nInsertion: ");
        for(int i = 0; i < values.length; i++){
            map.put(values[i], values[i]); // put() key/value pair in table
            map.printTable();                                       // printTable() after each insertion
            System.out.print(" Inserting: " + values[i] + " ");
            System.out.print(" Probes: " + map.probeCount());       // call probeCount() after each put()/get()
            System.out.print(" Size: " + map.size());               // size() gives the current no. of entries in the table
            System.out.print(" Capacity: " + map.capacity());       // capacity() gives the capacity of the underlying array
            System.out.println(" Load Level: " + map.loadLevel());  // loadLevel() gives the current load of the table
        }

        System.out.println("\nSearching:");
        for(int i = 0; i < values.length; i++){
            map.get(values[i]);
            System.out.println("Key: " + values[i] + " Probe Count: " + map.probeCount());
        }
        System.out.println();
    }

    public static void randomTest(){
        // A HashMap that uses Linear Probing, 
        // a default capacity of 7 and a default load factor of 1
        map = new SimpleHashMap<Integer, Integer>(SimpleHashMap.CollisionStrategy.LINEAR_PROBING);

        System.out.println("Random Test");
        System.out.println("-----------");

        // Generate random keys
        for(int i = 0; i < values.length; i++){
            values[i] = rng.nextInt(100);
        }

        // Print out the values array - can be useful when debugging
        // especially when generating random keys - see example below
        System.out.print("Keys: ");
        for(int i = 0; i < values.length - 1; i++){
            System.out.print(values[i] + ",");
        }
        System.out.print(values[values.length - 1]);
        System.out.println();

        System.out.println("\nLinear Probing");
        map.printTable(); // printTable() prints the underlying table - use only for small examples
        System.out.println(); // printTable() doesn't terminate with a '\n'

        // put all values into the map
        // Here the key and value are the same - all searching is done of keys
        // so I don't care about the value for testing
        System.out.println("\nInsertion: ");
        for(int i = 0; i < values.length; i++){
            map.put(values[i], values[i]); // put() key/value pair in table
            map.printTable();                                       // printTable() after each insertion
            System.out.print(" Inserting: " + values[i] + " ");
            System.out.print(" Probes: " + map.probeCount());       // call probeCount() after each put()/get()
            System.out.print(" Size: " + map.size());               // size() gives the current no. of entries in the table
            System.out.print(" Capacity: " + map.capacity());       // capacity() gives the capacity of the underlying array
            System.out.println(" Load Level: " + map.loadLevel());  // loadLevel() gives the current load of the table
        }

        System.out.println("\nSearching:");
        for(int i = 0; i < values.length; i++){
            map.get(values[i]);
            System.out.println("Key: " + values[i] + " Probe Count: " + map.probeCount());
        }
        System.out.println();
    }

    public static void growTest(){
        // A HashMap that uses Linear Probing, a default capacity of 7 and a
        // default load factor of 1
        map = new SimpleHashMap<Integer, Integer>(SimpleHashMap.CollisionStrategy.LINEAR_PROBING);
        values = new int[10]; // make a new larger array

        System.out.println("Grow Test");
        System.out.println("-----------");

        // Generate random keys
        for(int i = 0; i < values.length; i++){
            values[i] = rng.nextInt(100);
        }

        // Print out the values array - can be useful when debugging
        // especially when generating random keys - see example below
        System.out.print("Keys: ");
        for(int i = 0; i < values.length - 1; i++){
            System.out.print(values[i] + ",");
        }
        System.out.print(values[values.length - 1]);
        System.out.println();

        System.out.println("\nLinear Probing");
        map.printTable(); // printTable() prints the underlying table - use only
                          // for small examples
        System.out.println(); // printTable() doesn't terminate with a '\n'

        // put all values into the map
        // Here the key and value are the same - all searching is done of keys
        // so I don't care about the value for testing
        System.out.println("\nInsertion: ");
        for(int i = 0; i < values.length; i++){
            map.put(values[i], values[i]); // put() key/value pair in table
            map.printTable();                                       // printTable() after each insertion
            System.out.print(" Inserting: " + values[i] + " ");
            System.out.print(" Probes: " + map.probeCount());       // call probeCount() after each put()/get()
            System.out.print(" Size: " + map.size());               // size() gives the current no. of entries in the table
            System.out.print(" Capacity: " + map.capacity());       // capacity() gives the capacity of the underlying array
            System.out.println(" Load Level: " + map.loadLevel());  // loadLevel() gives the current load of the table
        }

        System.out.println("\nSearching:");
        for(int i = 0; i < values.length; i++){
            map.get(values[i]);
            System.out.println("Key: " + values[i] + " Probe Count: " + map.probeCount());
        }
        System.out.println();
    }
    
    public static void capacityTest(){
        // A HashMap that uses Linear Probing, 
        // capacity AT LEAST as large as initialCapcity and a default load factor of 1
        map = new SimpleHashMap<Integer, Integer>(initialCapacity, SimpleHashMap.CollisionStrategy.LINEAR_PROBING);
        values = new int[initialCapacity]; 

        System.out.println("Capacity Test");
        System.out.println("-----------");

        // Generate random keys
        for(int i = 0; i < values.length; i++){
            values[i] = rng.nextInt(100);
        }

        // Print out the values array - can be useful when debugging
        // especially when generating random keys - see example below
        System.out.print("Keys: ");
        for(int i = 0; i < values.length - 1; i++){
            System.out.print(values[i] + ",");
        }
        System.out.print(values[values.length - 1]);
        System.out.println();

        System.out.println("\nLinear Probing");
        //map.printTable(); // printTable() prints the underlying table - use only for small examples
        //System.out.println(); // printTable() doesn't terminate with a '\n'

        // put all values into the map
        // Here the key and value are the same - all searching is done of keys
        // so I don't care about the value for testing
        System.out.println("\nInsertion: ");
        for(int i = 0; i < values.length; i++){
            map.put(values[i], values[i]); // put() key/value pair in table
            //map.printTable();                                       // printTable() after each insertion
            System.out.print(" Inserting: " + values[i] + " ");
            System.out.print(" Probes: " + map.probeCount());       // call probeCount() after each put()/get()
            System.out.print(" Size: " + map.size());               // size() gives the current no. of entries in the table
            System.out.print(" Capacity: " + map.capacity());       // capacity() gives the capacity of the underlying array
            System.out.println(" Load Level: " + map.loadLevel());  // loadLevel() gives the current load of the table
        }

//        System.out.println("\nSearching:");
//        for(int i = 0; i < values.length; i++){
//            map.get(values[i]);
//            System.out.println("Key: " + values[i] + " Probe Count: " + map.probeCount());
//        }
        System.out.println();
    }
    
    public static void loadTest(){
        // A HashMap that uses Linear Probing, a capacity AT LEAST as large as initialCapcity and a default load factor of loadFactor
        //map = new SimpleHashMap<Integer, Integer>(initialCapacity, loadFactor, SimpleHashMap.CollisionStrategy.LINEAR_PROBING);
        
        // A HashMap that uses Linear Probing, capacity of 7 and a default load factor of loadFactor
        map = new SimpleHashMap<Integer, Integer>(loadFactor, SimpleHashMap.CollisionStrategy.LINEAR_PROBING);
        
        values = new int[initialCapacity * 2]; 

        System.out.println("Load Test");
        System.out.println("---------");

        // Generate random keys
        for(int i = 0; i < values.length; i++){
            values[i] = rng.nextInt(1000);
        }

        // Print out the values array - can be useful when debugging
        // especially when generating random keys - see example below
        System.out.print("Keys: ");
        for(int i = 0; i < values.length - 1; i++){
            System.out.print(values[i] + ",");
        }
        System.out.print(values[values.length - 1]);
        System.out.println();

        System.out.println("\nLinear Probing");
        //map.printTable(); // printTable() prints the underlying table - use only for small examples
        //System.out.println(); // printTable() doesn't terminate with a '\n'

        // put all values into the map
        // Here the key and value are the same - all searching is done of keys
        // so I don't care about the value for testing
        System.out.println("\nInsertion: ");
        for(int i = 0; i < values.length; i++){
            map.put(values[i], values[i]); // put() key/value pair in table
            //map.printTable();                                       // printTable() after each insertion
            System.out.print(" Inserting: " + values[i] + " ");
            System.out.print(" Probes: " + map.probeCount());       // call probeCount() after each put()/get()
            System.out.print(" Size: " + map.size());               // size() gives the current no. of entries in the table
            System.out.print(" Capacity: " + map.capacity());       // capacity() gives the capacity of the underlying array
            System.out.println(" Load Level: " + map.loadLevel());  // loadLevel() gives the current load of the table
        }

//        System.out.println("\nSearching:");
//        for(int i = 0; i < values.length; i++){
//            map.get(values[i]);
//            System.out.println("Key: " + values[i] + " Probe Count: " + map.probeCount());
//        }
        System.out.println();
    }
}
