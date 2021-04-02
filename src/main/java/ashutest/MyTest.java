package ashutest;

    import java.util.ArrayList;
    import java.util.HashMap;
    public class MyTest {
        public ArrayList<String> letterCombinations(String digits) {
            ArrayList<String> res = new ArrayList<String>();
            ArrayList<String> preres = new ArrayList<String>();
            res.add("");
            for(int i = 0; i < digits.length(); i++) {
                String letters = str[digits.charAt(i) -'0'];
                for(String str : res) {
                    for(int j = 0; j < letters.length(); j++)
                        preres.add(str + letters.charAt(j));
                }
                res = preres;
                preres = new ArrayList<String>();
            }
            return res;
        }


        static final HashMap<Character,String> map = new HashMap<Character,String>(){{
            put('1', "1");
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
            put('0', "0");
        }} ;

        static final String [] str = {"0","1","abc" , "def" ,"ghi","jkl","mno","pqrs","tuv","wxyz"};

        public static void main(String[] args) {
            MyTest t = new MyTest();
            System.out.println(t.letterCombinations("4155230"));
        }
    }
