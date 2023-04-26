import java.util.Random;

public class Tests{

    // int[] values =
    // {15,71,12,5,64,11,56,5,67,0,93,52,86,61,15,70,40,37,66,31};
    //int[] values = {11,22,33,44,55,66,77,88,99};
    // int[] values =
    // {-1708657533,1074218098,106317263,1180453555,-1189254127,388312624,-1941628381,425435280,2047858472};
    static int[] values = {14, 17, 25, 37, 34, 16, 26};

    //static int[] values = new int[7];

    public static void main(String[] args){
        SimpleHashMap<Integer, Integer> lp_map = new SimpleHashMap<Integer, Integer>(
                11, SimpleHashMap.CollisionStrategy.LINEAR_PROBING);
        SimpleHashMap<Integer, Integer> qp_map = new SimpleHashMap<Integer, Integer>(
                11, SimpleHashMap.CollisionStrategy.QUADRATIC_PROBING);
        SimpleHashMap<Integer, Integer> dh_map = new SimpleHashMap<Integer, Integer>(
                11, SimpleHashMap.CollisionStrategy.DOUBLE_HASHING);
        Random rng = new Random();

        boolean printTables = true;

        int lastProbe = 0;
        int lp_probeCount = 0;
        int qp_probeCount = 0;
        int dh_probeCount = 0;
        int lp_longestProbe = 0;
        int qp_longestProbe = 0;
        int dh_longestProbe = 0;

        int searchValue = 0;
        Integer searchResult;

//        for(int i = 0; i < values.length; i++){
//            values[i] = rng.nextInt(Integer.MAX_VALUE);
//        }

        long start = 0, stop = 0;

        if(printTables){
            for(int z = 0; z < 10; z++){
                lp_map = new SimpleHashMap<Integer, Integer>(
                        11, SimpleHashMap.CollisionStrategy.LINEAR_PROBING);
                qp_map = new SimpleHashMap<Integer, Integer>(
                        11, SimpleHashMap.CollisionStrategy.QUADRATIC_PROBING);
                dh_map = new SimpleHashMap<Integer, Integer>(
                        11, SimpleHashMap.CollisionStrategy.DOUBLE_HASHING);
                
//                for(int i = 0; i < values.length; i++){
//                    values[i] = rng.nextInt(100);
//                }
                
                searchValue = rng.nextInt(100);
                System.out
                        .println("\n----------------------------------------------------------------------");
                printValuesArray();

                System.out.println("\nLinear Probing");
                //printIndices();
                lp_map.printTable();
                System.out.println();

                start = System.nanoTime();
                lp_probeCount = 0;
                for(int i = 0; i < values.length; i++){
                    Integer x = lp_map.put(values[i], values[i]);
                    lastProbe = lp_map.probeCount();
                    lp_probeCount += lastProbe;
                    if(lastProbe > lp_longestProbe){
                        lp_longestProbe = lastProbe;
                    }
                    lp_map.printTable();
                    if(x == null){
                        System.out.print(" Inserting " + values[i] + " ");
                    } else{
                        System.out.print(" Updating " + values[i] + " ");
                    }
                    System.out.println(" Probes: " + lp_map.probeCount());
                }
                stop = System.nanoTime();

                System.out.print("Inserted " + values.length + " values, ");
                System.out.print(lp_map.size() + " distinct");
                System.out.println(" in " + ((stop - start) / 1000000) + " ms");

                System.out.print("Average no. of probes: "
                        + ((double) lp_probeCount / values.length));
                System.out.println(" Longest probe: " + lp_longestProbe);

                searchResult = lp_map.get(searchValue);
                System.out.println("Searching");
                if(searchResult != null){
                    System.out.println("Successful search for " + searchValue
                            + " in " + lp_map.probeCount() + " probes");
                } else{
                    System.out.println("Unsuccessful search for " + searchValue
                            + " in " + lp_map.probeCount() + " probes");
                }

                System.out.println("\nQuadratic Probing");
                qp_map.printTable();
                System.out.println();

                start = System.nanoTime();
                qp_probeCount = 0;
                for(int i = 0; i < values.length; i++){
                    Integer x = qp_map.put(values[i], values[i]);
                    lastProbe = qp_map.probeCount();
                    qp_probeCount += lastProbe;
                    if(lastProbe > qp_longestProbe){
                        qp_longestProbe = lastProbe;
                    }
                    qp_map.printTable();
                    if(x == null){
                        System.out.print(" Inserting " + values[i] + " ");
                    } else{
                        System.out.print(" Updating " + values[i] + " ");
                    }
                    System.out.println(" Probes: " + qp_map.probeCount());
                }
                stop = System.nanoTime();

                System.out.print("Inserted " + values.length + " values, ");
                System.out.print(qp_map.size() + " distinct");
                System.out.println(" in " + ((stop - start) / 1000000) + " ms");

                System.out.print("Average no. of probes: "
                        + ((double) qp_probeCount / values.length));
                System.out.println(" Longest probe: " + qp_longestProbe);

                searchResult = qp_map.get(searchValue);
                System.out.println("Searching");
                if(searchResult != null){
                    System.out.println("Successful search for " + searchValue
                            + " in " + qp_map.probeCount() + " probes");
                } else{
                    System.out.println("Unsuccessful search for " + searchValue
                            + " in " + qp_map.probeCount() + " probes");
                }

                System.out.println("\nDouble Hashing");
                dh_map.printTable();
                System.out.println();

                start = System.nanoTime();
                dh_probeCount = 0;
                for(int i = 0; i < values.length; i++){
                    Integer x = dh_map.put(values[i], values[i]);
                    lastProbe = dh_map.probeCount();
                    dh_probeCount += lastProbe;
                    if(lastProbe > dh_longestProbe){
                        dh_longestProbe = lastProbe;
                    }
                    dh_map.printTable();
                    if(x == null){
                        System.out.print(" Inserting " + values[i] + " ");
                    } else{
                        System.out.print(" Updating " + values[i] + " ");
                    }
                    System.out.println(" Probes: " + dh_map.probeCount());
                }
                stop = System.nanoTime();

                System.out.print("Inserted " + values.length + " values, ");
                System.out.print(dh_map.size() + " distinct");
                System.out.println(" in " + ((stop - start) / 1000000) + " ms");

                System.out.print("Average no. of probes: "
                        + ((double) dh_probeCount / values.length));
                System.out.println(" Longest probe: " + dh_longestProbe);

                searchResult = dh_map.get(searchValue);
                System.out.println("Searching");
                if(searchResult != null){
                    System.out.println("Successful search for " + searchValue
                            + " in " + dh_map.probeCount() + " probes");
                } else{
                    System.out.println("Unsuccessful search for " + searchValue
                            + " in " + dh_map.probeCount() + " probes");
                }
            }
        } else{
            System.out.println("Linear Probing");
            start = System.nanoTime();
            for(int i = 0; i < values.length; i++){
                lp_map.put(values[i], values[i]);
                lastProbe = lp_map.probeCount();
                lp_probeCount += lastProbe;
                if(lastProbe > lp_longestProbe){
                    lp_longestProbe = lastProbe;
                }
            }
            stop = System.nanoTime();

            System.out.print("Inserted " + values.length + " values, ");
            System.out.print(lp_map.size() + " distinct");
            System.out.println(" in " + ((stop - start) / 1000000) + " ms");

            System.out.print("Average no. of probes: "
                    + ((double) lp_probeCount / values.length));
            System.out.println(" Longest probe: " + lp_longestProbe);

            System.out.println("\nQuadratic Probing");
            start = System.nanoTime();
            for(int i = 0; i < values.length; i++){
                qp_map.put(values[i], values[i]);
                lastProbe = qp_map.probeCount();
                qp_probeCount += lastProbe;
                if(lastProbe > qp_longestProbe){
                    qp_longestProbe = lastProbe;
                }
            }
            stop = System.nanoTime();

            System.out.print("Inserted " + values.length + " values, ");
            System.out.print(qp_map.size() + " distinct");
            System.out.println(" in " + ((stop - start) / 1000000) + " ms");

            System.out.print("Average no. of probes: "
                    + ((double) qp_probeCount / values.length));
            System.out.println(" Longest probe: " + qp_longestProbe);

            System.out.println("\nDouble Hashing");
            start = System.nanoTime();
            for(int i = 0; i < values.length; i++){
                dh_map.put(values[i], values[i]);
                lastProbe = dh_map.probeCount();
                dh_probeCount += lastProbe;
                if(lastProbe > dh_longestProbe){
                    dh_longestProbe = lastProbe;
                }
            }
            stop = System.nanoTime();

            System.out.print("Inserted " + values.length + " values, ");
            System.out.print(dh_map.size() + " distinct");
            System.out.println(" in " + ((stop - start) / 1000000) + " ms");

            System.out.print("Average no. of probes: "
                    + ((double) dh_probeCount / values.length));
            System.out.println(" Longest probe: " + dh_longestProbe);
        }
    }
    
    private static void testLinearProbing(){
        
    }
    
    private static void testQuadraticProbing(){
        
    }
    
    private static void testDoubleHashing(){
        
    }

    private static void printValuesArray(){
        System.out.print("Keys: ");
        for(int i = 0; i < values.length - 1; i++){
            System.out.print(values[i] + ",");
        }
        System.out.print(values[values.length - 1]);
        System.out.println();
    }
}