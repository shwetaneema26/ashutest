import java.util.*;

public class MagicNumber{

        public static void main(String[] args) {
            String inputStr = "151 1000";
            String[] range = inputStr.split(" ");

            int start = Integer.parseInt(range[0]);
            int end = Integer.parseInt(range[1]);

            for (int i=start; i<=end; i++) {
                int[] digits = getDigits(i);
                if (isMagicNumber(digits)) {
                    System.out.println(i);
                }
            }
        }

        public static int[] getDigits(int number) {
            String input = Integer.toString(number);
            int[] digits = new int[input.length()];
            for (int i=0; i<input.length(); i++) {
                digits[i] = Integer.parseInt(input.substring(i, i+1));
            }
            return digits;
        }

        public static boolean isMagicNumber(int[] digits) {

            boolean[] values = new boolean[10];
            boolean[] nextIndexes = new boolean[10];


            int nextIndex = 0;
                for (int j=0; j<digits.length; j++) {
                    if (!isRepetative(values, digits[nextIndex])) {
                        nextIndex = (digits[nextIndex] + nextIndex) % digits.length;
                        if (!nextIndexes[nextIndex]) {
                            nextIndexes[nextIndex] = true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                return nextIndex == 0;

            }


        public static boolean isRepetative(boolean[]values,int digit) {

                if (values[digit]) {
                    return true;
                }
                else{
                    values[digit] = true;

            }
            return false;
        }

}

