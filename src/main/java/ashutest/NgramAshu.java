package ashutest;

import com.sun.javafx.binding.StringFormatter;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NgramAshu {

    public static void main(String[] args){

        // String text = "This IS shweta yo IS more IS none IS more IS done";

        String text = "Mary had a little lamb its fleece was white as snow;" +
                "And everywhere that Mary went, the lamb was sure to go. " +
                "It followed her to school one day, which was against the rule;" +
                "It made the children laugh and play, to see a lamb at school." +
                "And so the teacher turned it out, but still it lingered near," +
                "And waited patiently about till Mary did appear." +
                "Why does the lamb love Mary so?\" the eager children cry;" +
                "\"Why, Mary loves the lamb, you know\" the teacher did reply.";
        //lamb,0.375;teacher,0.250;children,0.125;eager,0.125;rule,0.125

        int n = 2;
        String inputSearcher = "the";

        String[] tokens = tokenizeInput(text);
        Map<String,Integer>  freqMap  = createFrequencyMap1(tokens,inputSearcher,n);


        Map<String,Float> myMap = new LinkedHashMap<>();

        List<Map.Entry<String,Integer>> myList = new LinkedList(freqMap.entrySet());
        //Sort the entires by value
        // myList = myList.stream().sorted((e1,e2)->e2.getValue().compareTo(e1.getValue())).collect(Collectors.toList());
        //total number of ngrams found
        int totalItems = freqMap.values().stream().mapToInt(s->Integer.valueOf(s)).sum();


        System.out.println("freq map = "+freqMap);

        //Map<String, Integer> result = new LinkedHashMap<>();

        Map<String, Integer> result = freqMap.entrySet().stream().sorted((e1,e2)->e2.getValue().compareTo(e1.getValue())).collect(Collectors.toMap(e->e.getKey(),e->e.getValue(),(e1,e2)->e2,
                LinkedHashMap::new));


        //   for (Map.Entry<String, Integer> entry : myList) {
        //    result.put(entry.getKey(), entry.getValue());
        //     }


        System.out.println("final map = "+result);

        printNGram(result,totalItems);

    }
    private static Map<String,Integer> createFrequencyMap(String[] tokens,String inputSearcher,int n) {

        Map<String, Integer> freqMap = new TreeMap<>();

        for (int i = 0; i < tokens.length; i++) {
            int j = 0;
            if (tokens[i].equalsIgnoreCase(inputSearcher)) {
                StringBuilder builder = new StringBuilder();

                for (j = i + 1; j < n + i && j < tokens.length; j++) {

                    builder.append(tokens[j]).append(" ");
                }
                String matched = builder.toString().trim();
                System.out.println(matched);
                if (freqMap.get(matched) != null)
                    freqMap.put(matched, freqMap.get(matched).intValue() + 1);
                else
                    freqMap.put(matched, 1);

            }

        }
        return freqMap;
    }
    private static Map<String,Integer> createFrequencyMap1(String [] tokens ,String input ,int n )
    {
        Map<String, Integer> freqMap = new TreeMap<>();

        for(int i =0 ;i< tokens.length; ++i)
        {
            StringBuilder sb = new StringBuilder((10));
            if(tokens[i].equalsIgnoreCase(input))
            {
                for(int j=i+1;j< n + i ;j++)
                    sb.append(tokens[j]).append(" ");
                String matched = sb.toString().trim();
                freqMap.put(matched,freqMap.getOrDefault(matched,0) +1);
            }
        }
        return freqMap;
    }
    public static String[] tokenizeInput(String text) {
        text = text.trim().replaceAll("[^A-Za-z0-9 ]", " ").replaceAll(" +", " ");
        //System.out.println(text);
        return text.split(" ");
    }


    public static void printNGram(Map<String, Integer> result, int totalItems) {
        Iterator iterator = result.entrySet().iterator();
        boolean applySemicolon = false;
        while (iterator.hasNext()) {
            if (applySemicolon) {
                System.out.print(";");
            }
            Map.Entry pair = (Map.Entry) iterator.next();
            System.out.print(pair.getKey() + "," + getProbability((int) pair.getValue(), totalItems));
            applySemicolon = true;

        }
    }

    public static String getProbability(int countOfWord, int total) {
        Float result = (float)countOfWord/total;
        return String.format("%.3f", result);
    }
}
