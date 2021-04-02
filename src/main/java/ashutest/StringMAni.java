import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringMAni {

    public static void main(String args[]){

       // sortMapByKey();
       // generateNgrams(2);

    }

    public static void findKthSmallest(){

        int[] inputArray;
        int k = -1;

        Supplier<IntStream> supplier = null;
        try(Scanner scanner = new Scanner(System.in);){

            k = Integer.parseInt(scanner.nextLine());
            String input2 = scanner.nextLine();

            if(input2!=null && !input2.isEmpty())
            {
                String[] inputStringArray =  input2.split(" ");
                inputArray = Arrays.stream(inputStringArray).mapToInt(Integer::parseInt).toArray();
                System.out.println(Arrays.toString(inputArray));
                supplier = ()->Arrays.stream(inputArray).sorted().distinct();

     }
        } catch (Exception e) {
            System.out.println("Invalid Inputs");
            return;
        }



        System.out.println("distinctStream size"+supplier.get().count());


        if(supplier.get().count()<k){
            System.out.println("dumb");
        }else{
            OptionalInt returnVal =  supplier.get().limit(k).skip(k-1).
                    findFirst();
            if(!returnVal.isPresent()) System.out.println("dumb");
            else
                System.out.println(returnVal.getAsInt());

        }

    }


    public static void generateNgrams(int N, String sent, List ngramList) {
        String[] tokens = sent.split("\\s+"); //split sentence into tokens

        //GENERATE THE N-GRAMS
        for(int k=0; k<(tokens.length-N+1); k++){
            String s="";
            int start=k;
            int end=k+N;
            for(int j=start; j<end; j++){
                s=s+""+tokens[j];
            }
            //Add n-gram to a list
            ngramList.add(s);

            Map<String,Integer> ngramMap = new HashMap<>();
            if(ngramMap.get(s)!=null)
            ngramMap.put(s,ngramMap.get(s)+1);
            else
                ngramMap.put(s,1);


            System.out.println(ngramMap);

        }
    }//End of method



    public static void sortMapByKey(){

        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("Shweta",90);
        map.put("Ashu",80);
        map.put("Reyaan",980);
        map.put("Kishi",10);


       Map<String,Integer> sortedMap =  map.entrySet().stream().
                sorted(Map.Entry.comparingByKey()).
                collect(Collectors.toMap(e->e.getKey(),e->e.getValue(),(e1,e2)->e2,LinkedHashMap::new));

        Map<String,Integer> sortedMapByKeyReverse =  map.entrySet().stream().
                sorted(Map.Entry.<String,Integer>comparingByKey().reversed()).
                collect(Collectors.toMap(e->e.getKey(),e->e.getValue(),(e1,e2)->e2,LinkedHashMap::new));

        Map<String,Integer> sortedMapByvalReverseUsingCollection =  map.entrySet().stream().
                sorted(Map.Entry.<String, Integer>comparingByValue(Collections.reverseOrder())).
                collect(Collectors.toMap(e->e.getKey(),e->e.getValue(),(e1,e2)->e2,LinkedHashMap::new));


        Map<String,Integer> sortedMapByValue = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));


        Map<String,Integer> sortedMapByValueNoOrder = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));


        System.out.println("Sorted Map"+sortedMap);
        System.out.println("Sorted Map sortedMapByKeyReverse"+sortedMapByKeyReverse);
        System.out.println("Sorted Map sortedMapByvalReverseUsingCollection "+sortedMapByvalReverseUsingCollection);
        System.out.println("Sorted Map sortedMapByValue"+sortedMapByValue);

        System.out.println("Sorted Map sortedMapByValueNoOrder"+sortedMapByValueNoOrder);
    }
}
