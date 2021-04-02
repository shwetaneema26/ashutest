import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class BalancedSmily {

    public static void main(String[] args) {

         int counter = 0;

        try {
            Scanner in = new Scanner(new File("/Users/shwetaneema/IdeaProjects/Sample/src/temp.txt"));
            int testCaseCount = in.nextInt();
            System.out.println("testCaseCount"+testCaseCount);
            if(!(testCaseCount<=50 && testCaseCount>=1)) {
                System.out.println("Invalid teset case range");
                return;
            }

            for (int i = 0; i < testCaseCount; i++) {
                String nextLine = in.nextLine();
                System.out.println("Next input-"+nextLine);
                System.out.printf("Case #%d: %s%n", ++counter, isBalancedSmily(nextLine) ? "YES" : "NO");
            }




    }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }
        static boolean isValidInput(String input) {
        boolean result = true;
            for (Character c : input.toCharArray()) {
                result = result & c.toString().matches("[a-z :()]");

            }
        return result;
        }

   static boolean isBalancedSmily(String text){

        if(text.isEmpty()) return true;
       boolean result = isValidInput(text);

       if(result){

           String onlyBracketString =  text.replaceAll(":\\(|:\\)","F").
                   replaceAll("[a-zA-Z :]","");

           if ((onlyBracketString.length() % 2) == 1) return false;

           Stack<Character> bracketStack = new Stack<>();


           for (char bracket : onlyBracketString.toCharArray()) {
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
            return false;
       }




}
