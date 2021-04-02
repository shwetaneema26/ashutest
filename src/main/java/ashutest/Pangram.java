import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Pangram {
    public static void main(String[] args) {

        String input = "A quick brown fox jumps over the lazy do";

        if(input==null || input.isEmpty()) System.out.println("No Pangram");

        //
        int[] asciiCharArray= input.toLowerCase().chars().filter(c->c>=97&&c<=122).toArray();

       Supplier<IntStream> myStreamSupplier = ()->Arrays.stream(asciiCharArray);
       long distinctCount = Arrays.stream(asciiCharArray).distinct().count();
       //if(myStreamSupplier.get().distinct().count()!=26)
        if(distinctCount !=26 )
           System.out.println("Not Strictly Pangram");
       else
           System.out.println("Panagram");

      String resultFinal = IntStream.range(97,123).filter(i->myStreamSupplier.get().noneMatch(j->j==i)).collect(StringBuilder::new,
              StringBuilder::appendCodePoint, StringBuilder::append).toString();


      System.out.println(resultFinal);




    }
}
