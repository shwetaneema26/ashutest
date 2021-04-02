import java.util.Arrays;

public class tedt {

    public static void main(String[] args) {
        for (Character c : "Ab%".toCharArray()) {
            c.toString().matches("[a-z :()]");

        }

        String s = "abve2";
        StringBuilder b = new StringBuilder();
     int j = 97;
     char c = (char)j;

       System.out.println(b.append(Character.toString(c)).toString());


    }
}
