package ashutest;


import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.*;


public class Streams {
    @FunctionalInterface
    interface mycallable
    {
        void call();
    }
    static  private CharSequence preprocess(String str)
    {
        StringBuilder r = new StringBuilder( );
        for (int i = 0; i < str.length(); i ++) {
            char cur = str.charAt(i);
            if (cur == '.')
            {
                continue;
            }
            else if (cur == '+')
            {
                while(str.charAt(i)!= '@')
                {
                    i++;
                }
                r.append(str.charAt(i));
            }
            else
            {
                r.append(str.charAt(i));
            }

        }
        return r;
    }
    public static void main (String args [] )
    {
     int arr [] = {1,10,13,15,17,17,2,4};
     String [] emails  = {"ashu.agrawal@gmail.com","av.gr.bc@gmail.com","avinash_cat+amazon@gmail.com","avg.rbc@gmail.com"};
     HashSet<CharSequence > hmap = new HashSet<>();
     for ( String email : emails)
     {
        CharSequence processed_email_add =  preprocess(email);
        hmap.add(processed_email_add);

     }
     hmap.add("ashuterasoft@gmail.com");
     for (CharSequence email : hmap)
     {
         if (email.equals("avinash_cat@gmail.com"))
         System.out.println(email);
     }
        Arrays.stream(arr).filter(x-> x >10 )
             .distinct()
             .sorted()
             .map( x -> x *x )
             .forEach(System.out::println);
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        //executor.scheduleAtFixedRate(TimeUnit.MILLISECONDS)

        /*Callable <Integer> runnable  = (x) ->
        {
                System.out.println("Abc:" + x);
                return x*x;
        };*/
        //int x= 10;
        //executor.submit();
        executor.shutdown();
    }

}
