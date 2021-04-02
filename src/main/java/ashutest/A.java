import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A {

public static void main(String [] args) {

    System.out.println("1A 2F 1C"+solution(2,"1A 2F 1C"));
    System.out.println(" "+solution(1," "));
    System.out.println(" "+solution(3,"1A 2A 3A"));
    System.out.println(" "+solution(1," 1D 1H"));

}
    public static int solution(int N, String S){
        String str[] = S.split(" ");
        List<String> reserved = new ArrayList<>();
        int available = 0;

        reserved = Arrays.asList(str);

        for (int i = 1; i <= N; i++) {

            if (!reserved.contains(i + "A") && !reserved.contains(i + "B") && !reserved.contains(i + "C")) {
                available++;
            }
            if (!(reserved.contains(i + "D") && reserved.contains(i + "G")) && !(reserved.contains(i + "E") || reserved.contains(i + "F"))) {
                available++;
            }
            if (!reserved.contains(i + "H") && !reserved.contains(i + "J") && !reserved.contains(i + "K")) {
                available++;
            }
        }
        return available;
    }



}
