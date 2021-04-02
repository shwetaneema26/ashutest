import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DecimalToInteger
    {
        public static void main(String[] args) {
            int n, count = 0, a;
            String x = "";
//            Scanner s = new Scanner(System.in);
//            System.out.print("Enter any decimal number:");
//            n = s.nextInt();2;
            n = 7;
            while (n > 0) {
                a = n % 2;
                if (a == 1) {
                    count++;
                }
                x = a + "" + x;
                n = n / 2;
            }
            System.out.println("Binary number:" + x);
            System.out.println("No. of 1s:" + count);


            System.out.println(solution(new int[]{1,7,5,6,3}));

        }
             public static int solution(int[] A) {
                    // write your code in Java SE 8
                Arrays.sort(A);
                int i = 0;
                while(i<A.length-1) {
                    if (A[i] + 1 < A[i + 1]){
                        int j = A[i] + 1;

                        return j;
                    }
i++;
                }
                return -1;
                }


    }




