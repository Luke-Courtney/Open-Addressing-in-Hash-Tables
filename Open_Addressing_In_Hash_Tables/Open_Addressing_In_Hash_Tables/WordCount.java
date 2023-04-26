import java.util.Scanner;
import java.io.*;

public class WordCount{
    public static void lp_OliverTwist() throws FileNotFoundException{
        //Choosing file
        File file = new File("OliverTwist.txt");

        //Creating scanner and setting delimiter to remove non words
        Scanner scan = new Scanner(file); 
        scan.useDelimiter("-{2,}|[^\\p{IsAlphabetic}'-]+");

        SimpleHashMap<String, Integer> lp_map = new SimpleHashMap<String, Integer>(
                16, SimpleHashMap.CollisionStrategy.LINEAR_PROBING);

        int lastProbe = 0;
        double lp_probeCount = 0;
        int lp_longestProbe = 0;
        double totalWords = 0;//Total word count
        int distinctWords = 0;

        while (scan.hasNext()) {
            String word  = scan.next();
            
        //If word does not exist in map, add it with value of 1
        //Else add it with value of old value + 1
        if(lp_map.get(word) == null){
            lp_map.put(word, 1);

            lastProbe = lp_map.probeCount();
            distinctWords++;
        }
        else{
            lp_map.put(word, lp_map.get(word) + 1);
            lastProbe = lp_map.probeCount();
        }
        lp_probeCount += lastProbe;

        //Finding longest probe
        if(lastProbe > lp_longestProbe){
            lp_longestProbe = lastProbe;
        }

        totalWords++;
        }//End while (End at end of file)

        //Finding average number of probes
        double avgProbes = lp_probeCount/totalWords;

        //Creating new scanner and setting delimiter to remove non words
        Scanner scan2 = new Scanner(file); 
        scan2.useDelimiter("-{2,}|[^\\p{IsAlphabetic}'-]+");

        //Looping through file to find most frequently used word
        String mostFrequent = "";
        int mostFrequentCount = 0;
        while (scan2.hasNext()) {
            String word  = scan2.next();
            int count = lp_map.get(word);
            

            if(count > mostFrequentCount){
                mostFrequentCount = count;
                mostFrequent = word;
            }
        }//End while (End at end of file)

        //Printing result
        System.out.println("\n");
        System.out.println("File: " + file + "\tLinear Probing");
        System.out.println("Size: " + lp_map.size() + "\tCapacity: " + lp_map.capacity() + "\t\tLoad factor: " + lp_map.loadFactor);
        System.out.println("Total Probes: " + lp_probeCount + "\tAverage probes: " + avgProbes);
        System.out.println("Words: " + totalWords + "\tDistinct: " + distinctWords);
        System.out.println("The most common word is \"" + mostFrequent + "\" appearing " + mostFrequentCount + " times.");
        System.out.println("-----------------------------------------------------");
    }//End lp_OliverTwist

    public static void lp_MobyDick() throws FileNotFoundException{
        //Choosing file
        File file2 = new File("MobyDick.txt");

        //Creating scanner and setting delimiter to remove non words
        Scanner scan = new Scanner(file2); 
        scan.useDelimiter("-{2,}|[^\\p{IsAlphabetic}'-]+");

        SimpleHashMap<String, Integer> lp_map = new SimpleHashMap<String, Integer>(
                16, SimpleHashMap.CollisionStrategy.LINEAR_PROBING);

        int lastProbe = 0;
        double lp_probeCount = 0;
        int lp_longestProbe = 0;
        double totalWords = 0;//Total word count
        int distinctWords = 0;

        while (scan.hasNext()) {
            String word  = scan.next();
            
        //If word does not exist in map, add it with value of 1
        //Else add it with value of old value + 1
        if(lp_map.get(word) == null){
            lp_map.put(word, 1);

            lastProbe = lp_map.probeCount();
            distinctWords++;
        }
        else{
            lp_map.put(word, lp_map.get(word) + 1);
            lastProbe = lp_map.probeCount();
        }
        lp_probeCount += lastProbe;

        //Finding longest probe
        if(lastProbe > lp_longestProbe){
            lp_longestProbe = lastProbe;
        }

        totalWords++;
        }//End while (End at end of file)

        //Finding average number of probes
        double avgProbes = lp_probeCount/totalWords;

        //Creating new scanner and setting delimiter to remove non words
        Scanner scan2 = new Scanner(file2); 
        scan2.useDelimiter("-{2,}|[^\\p{IsAlphabetic}'-]+");

        //Looping through file to find most frequently used word
        String mostFrequent = "";
        int mostFrequentCount = 0;
        while (scan2.hasNext()) {
            String word  = scan2.next();
            int count = lp_map.get(word);
            

            if(count > mostFrequentCount){
                mostFrequentCount = count;
                mostFrequent = word;
            }
        }//End while (End at end of file)

        //Printing result
        System.out.println("\n");
        System.out.println("File: " + file2 + "\tLinear Probing");
        System.out.println("Size: " + lp_map.size() + "\tCapacity: " + lp_map.capacity() + "\t\tLoad factor: " + lp_map.loadFactor);
        System.out.println("Total Probes: " + lp_probeCount + "\tAverage probes: " + avgProbes);
        System.out.println("Words: " + totalWords + "\tDistinct: " + distinctWords);
        System.out.println("The most common word is \"" + mostFrequent + "\" appearing " + mostFrequentCount + " times.");
        System.out.println("-----------------------------------------------------");
    }//End lp_MobyDick

    public static void lp_TheHoundOfTheBaskervilles() throws FileNotFoundException{

    
        
        //Choosing file
        File file = new File("TheHoundOfTheBaskervilles.txt");

        //Creating scanner and setting delimiter to remove non words
        Scanner scan = new Scanner(file); 
        scan.useDelimiter("-{2,}|[^\\p{IsAlphabetic}'-]+");

        SimpleHashMap<String, Integer> lp_map = new SimpleHashMap<String, Integer>(
                16, SimpleHashMap.CollisionStrategy.LINEAR_PROBING);

        int lastProbe = 0;
        double lp_probeCount = 0;
        int lp_longestProbe = 0;
        double totalWords = 0;//Total word count
        int distinctWords = 0;

        while (scan.hasNext()) {
            String word  = scan.next();
            
        //If word does not exist in map, add it with value of 1
        //Else add it with value of old value + 1
        if(lp_map.get(word) == null){
            lp_map.put(word, 1);

            lastProbe = lp_map.probeCount();
            distinctWords++;
        }
        else{
            lp_map.put(word, lp_map.get(word) + 1);
            lastProbe = lp_map.probeCount();
        }
        lp_probeCount += lastProbe;

        //Finding longest probe
        if(lastProbe > lp_longestProbe){
            lp_longestProbe = lastProbe;
        }

        totalWords++;
        }//End while (End at end of file)

        //Finding average number of probes
        double avgProbes = lp_probeCount/totalWords;

        //Creating new scanner and setting delimiter to remove non words
        Scanner scan2 = new Scanner(file); 
        scan2.useDelimiter("-{2,}|[^\\p{IsAlphabetic}'-]+");

        //Looping through file to find most frequently used word
        String mostFrequent = "";
        int mostFrequentCount = 0;
        while (scan2.hasNext()) {
            String word  = scan2.next();
            int count = lp_map.get(word);
            

            if(count > mostFrequentCount){
                mostFrequentCount = count;
                mostFrequent = word;
            }
        }//End while (End at end of file)

        //Printing result
        System.out.println("\n");
        System.out.println("File: " + file + "\tLinear Probing");
        System.out.println("Size: " + lp_map.size() + "\tCapacity: " + lp_map.capacity() + "\t\tLoad factor: " + lp_map.loadFactor);
        System.out.println("Total Probes: " + lp_probeCount + "\tAverage probes: " + avgProbes);
        System.out.println("Words: " + totalWords + "\tDistinct: " + distinctWords);
        System.out.println("The most common word is \"" + mostFrequent + "\" appearing " + mostFrequentCount + " times.");
        System.out.println("-----------------------------------------------------");
    }//End lp_TheHoundOfTheBaskerviles
    
    public static void qp_OliverTwist() throws FileNotFoundException{
        //Choosing file
        File file = new File("OliverTwist.txt");

        //Creating scanner and setting delimiter to remove non words
        Scanner scan = new Scanner(file); 
        scan.useDelimiter("-{2,}|[^\\p{IsAlphabetic}'-]+");

        SimpleHashMap<String, Integer> lp_map = new SimpleHashMap<String, Integer>(
                16, SimpleHashMap.CollisionStrategy.QUADRATIC_PROBING);

        int lastProbe = 0;
        double lp_probeCount = 0;
        int lp_longestProbe = 0;
        double totalWords = 0;//Total word count
        int distinctWords = 0;

        while (scan.hasNext()) {
            String word  = scan.next();
            
        //If word does not exist in map, add it with value of 1
        //Else add it with value of old value + 1
        if(lp_map.get(word) == null){
            lp_map.put(word, 1);

            lastProbe = lp_map.probeCount();
            distinctWords++;
        }
        else{
            lp_map.put(word, lp_map.get(word) + 1);
            lastProbe = lp_map.probeCount();
        }
        lp_probeCount += lastProbe;

        //Finding longest probe
        if(lastProbe > lp_longestProbe){
            lp_longestProbe = lastProbe;
        }

        totalWords++;
        }//End while (End at end of file)

        //Finding average number of probes
        double avgProbes = lp_probeCount/totalWords;

        //Creating new scanner and setting delimiter to remove non words
        Scanner scan2 = new Scanner(file); 
        scan2.useDelimiter("-{2,}|[^\\p{IsAlphabetic}'-]+");

        //Looping through file to find most frequently used word
        String mostFrequent = "";
        int mostFrequentCount = 0;
        while (scan2.hasNext()) {
            String word  = scan2.next();
            int count = lp_map.get(word);
            

            if(count > mostFrequentCount){
                mostFrequentCount = count;
                mostFrequent = word;
            }
        }//End while (End at end of file)

        //Printing result
        System.out.println("\n");
        System.out.println("File: " + file + "\tQuadratic Probing");
        System.out.println("Size: " + lp_map.size() + "\tCapacity: " + lp_map.capacity() + "\t\tLoad factor: " + lp_map.loadFactor);
        System.out.println("Total Probes: " + lp_probeCount + "\tAverage probes: " + avgProbes);
        System.out.println("Words: " + totalWords + "\tDistinct: " + distinctWords);
        System.out.println("The most common word is \"" + mostFrequent + "\" appearing " + mostFrequentCount + " times.");
        System.out.println("-----------------------------------------------------");
    }//End qp_OliverTwist
    
    public static void qp_MobyDick() throws FileNotFoundException{
        //Choosing file
        File file2 = new File("MobyDick.txt");

        //Creating scanner and setting delimiter to remove non words
        Scanner scan = new Scanner(file2); 
        scan.useDelimiter("-{2,}|[^\\p{IsAlphabetic}'-]+");

        SimpleHashMap<String, Integer> lp_map = new SimpleHashMap<String, Integer>(
                16, SimpleHashMap.CollisionStrategy.QUADRATIC_PROBING);

        int lastProbe = 0;
        double lp_probeCount = 0;
        int lp_longestProbe = 0;
        double totalWords = 0;//Total word count
        int distinctWords = 0;

        while (scan.hasNext()) {
            String word  = scan.next();
            
        //If word does not exist in map, add it with value of 1
        //Else add it with value of old value + 1
        if(lp_map.get(word) == null){
            lp_map.put(word, 1);

            lastProbe = lp_map.probeCount();
            distinctWords++;
        }
        else{
            lp_map.put(word, lp_map.get(word) + 1);
            lastProbe = lp_map.probeCount();
        }
        lp_probeCount += lastProbe;

        //Finding longest probe
        if(lastProbe > lp_longestProbe){
            lp_longestProbe = lastProbe;
        }

        totalWords++;
        }//End while (End at end of file)

        //Finding average number of probes
        double avgProbes = lp_probeCount/totalWords;

        //Creating new scanner and setting delimiter to remove non words
        Scanner scan2 = new Scanner(file2); 
        scan2.useDelimiter("-{2,}|[^\\p{IsAlphabetic}'-]+");

        //Looping through file to find most frequently used word
        String mostFrequent = "";
        int mostFrequentCount = 0;
        while (scan2.hasNext()) {
            String word  = scan2.next();
            int count = lp_map.get(word);
            

            if(count > mostFrequentCount){
                mostFrequentCount = count;
                mostFrequent = word;
            }
        }//End while (End at end of file)

        //Printing result
        System.out.println("\n");
        System.out.println("File: " + file2 + "\tLinear Probing");
        System.out.println("Size: " + lp_map.size() + "\tCapacity: " + lp_map.capacity() + "\t\tLoad factor: " + lp_map.loadFactor);
        System.out.println("Total Probes: " + lp_probeCount + "\tAverage probes: " + avgProbes);
        System.out.println("Words: " + totalWords + "\tDistinct: " + distinctWords);
        System.out.println("The most common word is \"" + mostFrequent + "\" appearing " + mostFrequentCount + " times.");
        System.out.println("-----------------------------------------------------");
    }//End qp_MobyDick

    public static void qp_TheHoundOfTheBaskervilles() throws FileNotFoundException{

    
        
        //Choosing file
        File file = new File("TheHoundOfTheBaskervilles.txt");

        //Creating scanner and setting delimiter to remove non words
        Scanner scan = new Scanner(file); 
        scan.useDelimiter("-{2,}|[^\\p{IsAlphabetic}'-]+");

        SimpleHashMap<String, Integer> lp_map = new SimpleHashMap<String, Integer>(
                16, SimpleHashMap.CollisionStrategy.QUADRATIC_PROBING);

        int lastProbe = 0;
        double lp_probeCount = 0;
        int lp_longestProbe = 0;
        double totalWords = 0;//Total word count
        int distinctWords = 0;

        while (scan.hasNext()) {
            String word  = scan.next();
            
        //If word does not exist in map, add it with value of 1
        //Else add it with value of old value + 1
        if(lp_map.get(word) == null){
            lp_map.put(word, 1);

            lastProbe = lp_map.probeCount();
            distinctWords++;
        }
        else{
            lp_map.put(word, lp_map.get(word) + 1);
            lastProbe = lp_map.probeCount();
        }
        lp_probeCount += lastProbe;

        //Finding longest probe
        if(lastProbe > lp_longestProbe){
            lp_longestProbe = lastProbe;
        }

        totalWords++;
        }//End while (End at end of file)

        //Finding average number of probes
        double avgProbes = lp_probeCount/totalWords;

        //Creating new scanner and setting delimiter to remove non words
        Scanner scan2 = new Scanner(file); 
        scan2.useDelimiter("-{2,}|[^\\p{IsAlphabetic}'-]+");

        //Looping through file to find most frequently used word
        String mostFrequent = "";
        int mostFrequentCount = 0;
        while (scan2.hasNext()) {
            String word  = scan2.next();
            int count = lp_map.get(word);
            

            if(count > mostFrequentCount){
                mostFrequentCount = count;
                mostFrequent = word;
            }
        }//End while (End at end of file)

        //Printing result
        System.out.println("\n");
        System.out.println("File: " + file + "\tLinear Probing");
        System.out.println("Size: " + lp_map.size() + "\tCapacity: " + lp_map.capacity() + "\t\tLoad factor: " + lp_map.loadFactor);
        System.out.println("Total Probes: " + lp_probeCount + "\tAverage probes: " + avgProbes);
        System.out.println("Words: " + totalWords + "\tDistinct: " + distinctWords);
        System.out.println("The most common word is \"" + mostFrequent + "\" appearing " + mostFrequentCount + " times.");
        System.out.println("-----------------------------------------------------");
    }//End qp_TheHoundOfTheBaskerviles

    public static void dh_OliverTwist() throws FileNotFoundException{
        //Choosing file
        File file = new File("OliverTwist.txt");

        //Creating scanner and setting delimiter to remove non words
        Scanner scan = new Scanner(file); 
        scan.useDelimiter("-{2,}|[^\\p{IsAlphabetic}'-]+");

        SimpleHashMap<String, Integer> lp_map = new SimpleHashMap<String, Integer>(
                16, SimpleHashMap.CollisionStrategy.DOUBLE_HASHING);

        int lastProbe = 0;
        double lp_probeCount = 0;
        int lp_longestProbe = 0;
        double totalWords = 0;//Total word count
        int distinctWords = 0;

        while (scan.hasNext()) {
            String word  = scan.next();
            
        //If word does not exist in map, add it with value of 1
        //Else add it with value of old value + 1
        if(lp_map.get(word) == null){
            lp_map.put(word, 1);

            lastProbe = lp_map.probeCount();
            distinctWords++;
        }
        else{
            lp_map.put(word, lp_map.get(word) + 1);
            lastProbe = lp_map.probeCount();
        }
        lp_probeCount += lastProbe;

        //Finding longest probe
        if(lastProbe > lp_longestProbe){
            lp_longestProbe = lastProbe;
        }

        totalWords++;
        }//End while (End at end of file)

        //Finding average number of probes
        double avgProbes = lp_probeCount/totalWords;

        //Creating new scanner and setting delimiter to remove non words
        Scanner scan2 = new Scanner(file); 
        scan2.useDelimiter("-{2,}|[^\\p{IsAlphabetic}'-]+");

        //Looping through file to find most frequently used word
        String mostFrequent = "";
        int mostFrequentCount = 0;
        while (scan2.hasNext()) {
            String word  = scan2.next();
            int count = lp_map.get(word);
            

            if(count > mostFrequentCount){
                mostFrequentCount = count;
                mostFrequent = word;
            }
        }//End while (End at end of file)

        //Printing result
        System.out.println("\n");
        System.out.println("File: " + file + "\tQuadratic Probing");
        System.out.println("Size: " + lp_map.size() + "\tCapacity: " + lp_map.capacity() + "\t\tLoad factor: " + lp_map.loadFactor);
        System.out.println("Total Probes: " + lp_probeCount + "\tAverage probes: " + avgProbes);
        System.out.println("Words: " + totalWords + "\tDistinct: " + distinctWords);
        System.out.println("The most common word is \"" + mostFrequent + "\" appearing " + mostFrequentCount + " times.");
        System.out.println("-----------------------------------------------------");
    }//End dh_OliverTwist
    
    public static void dh_MobyDick() throws FileNotFoundException{
        //Choosing file
        File file2 = new File("MobyDick.txt");

        //Creating scanner and setting delimiter to remove non words
        Scanner scan = new Scanner(file2); 
        scan.useDelimiter("-{2,}|[^\\p{IsAlphabetic}'-]+");

        SimpleHashMap<String, Integer> lp_map = new SimpleHashMap<String, Integer>(
                16, SimpleHashMap.CollisionStrategy.DOUBLE_HASHING);

        int lastProbe = 0;
        double lp_probeCount = 0;
        int lp_longestProbe = 0;
        double totalWords = 0;//Total word count
        int distinctWords = 0;

        while (scan.hasNext()) {
            String word  = scan.next();
            
        //If word does not exist in map, add it with value of 1
        //Else add it with value of old value + 1
        if(lp_map.get(word) == null){
            lp_map.put(word, 1);

            lastProbe = lp_map.probeCount();
            distinctWords++;
        }
        else{
            lp_map.put(word, lp_map.get(word) + 1);
            lastProbe = lp_map.probeCount();
        }
        lp_probeCount += lastProbe;

        //Finding longest probe
        if(lastProbe > lp_longestProbe){
            lp_longestProbe = lastProbe;
        }

        totalWords++;
        }//End while (End at end of file)

        //Finding average number of probes
        double avgProbes = lp_probeCount/totalWords;

        //Creating new scanner and setting delimiter to remove non words
        Scanner scan2 = new Scanner(file2); 
        scan2.useDelimiter("-{2,}|[^\\p{IsAlphabetic}'-]+");

        //Looping through file to find most frequently used word
        String mostFrequent = "";
        int mostFrequentCount = 0;
        while (scan2.hasNext()) {
            String word  = scan2.next();
            int count = lp_map.get(word);
            

            if(count > mostFrequentCount){
                mostFrequentCount = count;
                mostFrequent = word;
            }
        }//End while (End at end of file)

        //Printing result
        System.out.println("\n");
        System.out.println("File: " + file2 + "\tLinear Probing");
        System.out.println("Size: " + lp_map.size() + "\tCapacity: " + lp_map.capacity() + "\t\tLoad factor: " + lp_map.loadFactor);
        System.out.println("Total Probes: " + lp_probeCount + "\tAverage probes: " + avgProbes);
        System.out.println("Words: " + totalWords + "\tDistinct: " + distinctWords);
        System.out.println("The most common word is \"" + mostFrequent + "\" appearing " + mostFrequentCount + " times.");
        System.out.println("-----------------------------------------------------");
    }//End dh_MobyDick

    public static void dh_TheHoundOfTheBaskervilles() throws FileNotFoundException{

        //Choosing file
        File file = new File("TheHoundOfTheBaskervilles.txt");

        //Creating scanner and setting delimiter to remove non words
        Scanner scan = new Scanner(file); 
        scan.useDelimiter("-{2,}|[^\\p{IsAlphabetic}'-]+");

        SimpleHashMap<String, Integer> lp_map = new SimpleHashMap<String, Integer>(
                16, SimpleHashMap.CollisionStrategy.DOUBLE_HASHING);

        int lastProbe = 0;
        double lp_probeCount = 0;
        int lp_longestProbe = 0;
        double totalWords = 0;//Total word count
        int distinctWords = 0;

        while (scan.hasNext()) {
            String word  = scan.next();
            
        //If word does not exist in map, add it with value of 1
        //Else add it with value of old value + 1
        if(lp_map.get(word) == null){
            lp_map.put(word, 1);

            lastProbe = lp_map.probeCount();
            distinctWords++;
        }
        else{
            lp_map.put(word, lp_map.get(word) + 1);
            lastProbe = lp_map.probeCount();
        }
        lp_probeCount += lastProbe;

        //Finding longest probe
        if(lastProbe > lp_longestProbe){
            lp_longestProbe = lastProbe;
        }

        totalWords++;
        }//End while (End at end of file)

        //Finding average number of probes
        double avgProbes = lp_probeCount/totalWords;

        //Creating new scanner and setting delimiter to remove non words
        Scanner scan2 = new Scanner(file); 
        scan2.useDelimiter("-{2,}|[^\\p{IsAlphabetic}'-]+");

        //Looping through file to find most frequently used word
        String mostFrequent = "";
        int mostFrequentCount = 0;
        while (scan2.hasNext()) {
            String word  = scan2.next();
            int count = lp_map.get(word);
            

            if(count > mostFrequentCount){
                mostFrequentCount = count;
                mostFrequent = word;
            }
        }//End while (End at end of file)

        //Printing result
        System.out.println("\n");
        System.out.println("File: " + file + "\tLinear Probing");
        System.out.println("Size: " + lp_map.size() + "\tCapacity: " + lp_map.capacity() + "\t\tLoad factor: " + lp_map.loadFactor);
        System.out.println("Total Probes: " + lp_probeCount + "\tAverage probes: " + avgProbes);
        System.out.println("Words: " + totalWords + "\tDistinct: " + distinctWords);
        System.out.println("The most common word is \"" + mostFrequent + "\" appearing " + mostFrequentCount + " times.");
        System.out.println("-----------------------------------------------------");
    }//End dh_TheHoundOfTheBaskerviles
    public static void main(String[] args) throws IOException
    {
        //Linear Probing
        System.out.println("Linear Probing");
        lp_OliverTwist();
        lp_MobyDick();
        lp_TheHoundOfTheBaskervilles();

        //Quadratic Probing
        System.out.println("\nQuadratic Probing");
        qp_OliverTwist();
        qp_MobyDick();
        qp_TheHoundOfTheBaskervilles();

        //Double Hashing
        System.out.println("\nDouble Hashing");
        dh_OliverTwist();
        dh_MobyDick();
        dh_TheHoundOfTheBaskervilles();
        
    }//End main
}//End class