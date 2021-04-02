import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;

public class Sentence {

    public static void main(String[] args) {
       String s =  "my :((((( shweta):):()))".replaceAll(":\\(|:\\)","F").replaceAll("[a-zA-Z :]","");
        boolean result = isBalancedSmily(s);

       System.out.println(s);
        System.out.println(result);




    }

    static boolean isBalancedSmily(String text) {
        Stack<Character> bracketStack = new Stack<>();

        if ((text.length() % 2) == 1) return false;


        for (char bracket : text.toCharArray()) {
            if (bracket == '(') {
                bracketStack.push(bracket);
            } else {
                if (!bracketStack.isEmpty()) {
                    bracketStack.pop();
                } else {
                    return false;
                }


            }
        }
        return bracketStack.isEmpty();
    }
}





