package ashutest;

import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class DataStructure {

    // Create an array
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];
    ArrayList<Integer> arrayList;
    ConcurrentHashMap<String, Integer> cmap = new ConcurrentHashMap();
    TreeSet<Integer>  ts = new TreeSet<>();



    public DataStructure(int size) {
        arrayList = new ArrayList<>(100);
        // fill the array with ascending integer values
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
        }
        for (Integer elem : arrayList) {
            System.out.println(elem);
        }
        arrayList.forEach(System.out::println);

    }

    public void printEven() {

        // Print out values of even indices of the array
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        String name =  "Hello";
        String name1 = "Bye";
        System.out.println(Objects.equals(name,name1));
    }

    interface DataStructureIterator extends java.util.Iterator<Integer> { }

    // Inner class implements the DataStructureIterator interface,
    // which extends the Iterator<Integer> interface

    private class EvenIterator implements DataStructureIterator {

        // Start stepping through the array from the beginning
        private int nextIndex = 0;

        public boolean hasNext() {

            // Check if the current element is the last in the array
            return (nextIndex <= SIZE - 1);
        }

        public Integer next() {

            // Record a value of an even index of the array
            int retValue = arrayOfInts[nextIndex];

            // Get the next even element
            nextIndex += 2;
            return retValue;
        }
    }

    public static void main(String s[]) {

        // Fill the array with integer values and print out only
        // values of even indices
        DataStructure ds = new DataStructure(5);
        ds.printEven();
    }
}