package ashutest;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class ByValue {

    public static void main(String args [])
    {
        HashMap<String,Integer> hmap= new HashMap<>();
        hmap.put("Ashu",300);
        hmap.put("Avinash",200);
        hmap.put("Shweta",100);


        hmap.entrySet().stream().sorted((k1,k2)->k2.getValue().compareTo(k1.getValue())).forEach(System.out::println);


    }

}
