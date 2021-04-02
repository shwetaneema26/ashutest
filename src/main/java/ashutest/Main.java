import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {

    volatile boolean b = false;
    public static void main(String[] args) {

        String s = "shweta";
        List<String> lstString = new ArrayList<>();
        lstString.add("Shweta");
        lstString.add("Neema");

        List<Integer> lstInt = new ArrayList<>();
        lstInt.add(1);

        List<?> unbounded = lstString;




        lstString.stream().
                filter(s1 -> s1.startsWith("S")).
                collect(Collectors.toCollection(ArrayList::new)).
                forEach(System.out::println);

        Collections.sort(lstString, (s1, s2) -> s2.compareTo(s1));
        System.out.println(lstString);
       // ConcurrentHashMap

        //Files.readAllBytes();
        List<Integer> intList = Arrays.asList(3, 5, 8, 9, 45, 2, 12);
        System.out.println(intList.stream().count());

        System.out.println(intList.stream().mapToInt(x -> x).max().orElse(0));
        System.out.println(intList.stream().mapToInt(x -> x).summaryStatistics().getMax());

        LocalDate date = LocalDate.now();
        // add 1 date next
        System.out.println(date.plusDays(1));
        System.out.println(date.plusMonths(1));
        System.out.println(date.plus(1, ChronoUnit.DAYS));


        Spliterator spitr = intList.spliterator();

        List<String> str1 = Arrays.asList("shweta", "neema", "Neema", "Ram", "Shyam", " ", " ", " ");


        System.out.println("Shwtea output" + str1.stream().filter(s1 -> !s1.isEmpty()).collect(Collectors.toList()));


        System.out.println(Optional.ofNullable(null).isPresent());
        reverse();
        charCount();

    }
    static public void reverse()
    {
    String s1[] = new String[]{"Shweta","Neema"};
    char[] c = s1[0].toCharArray();
    int j = c.length-1;
    int i = 0;

    while(i<j){

     char temp = c[j];
     c[j]=c[i];
     c[i]=temp;
     j--;
     i++;

    }

   System.out.println(String.valueOf(c));

    }


public static void charCount(){

        String str = "dfgdfgdfsg";
       /* Map<Character,Integer> map1= new HashMap<Character,Integer>();

        char[] c = s.toCharArray();
        for (char c1:c){
            if(!map1.containsKey(c1))
            map1.put(c1,1);
            else{
                Integer i1 = map1.get(c1);
                map1.put(c1, i1.intValue()+1);

            }



        }
        System.out.println(map1);
*/  final int NO_OF_CHARS = 256;
     char count[] = new char[NO_OF_CHARS];

   for (int i = 0; i < str.length();  i++)
            count[str.charAt(i)]++;


    /* The method returns index of first non-repeating
       character in a string. If all characters are repeating
       then returns -1 */

        int index = -1, i;

        for (i = 0; i < str.length();  i++)
        {
            if (count[str.charAt(i)] == 1)
            {
                index = i;
                break;
            }
        }

       System.out.println("index"+index);



    }
    }

