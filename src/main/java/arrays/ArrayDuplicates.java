package arrays;

public class ArrayDuplicates {
    public static void main(String args [])
    {
        String str = "hello";
        char [] str1 = str.toCharArray();
        boolean [] exists = new boolean [256] ;
        boolean flag = false;
        for(int i = 0;i< str1.length;++i)
        {
            int index = str1[i] ;
            if( !exists[index]) {
                exists[index] = true;

            }
            else{
                //System.out.println("String does not have unique values");
                flag = true;
                break;
            }
        }
       if (flag)
       {
           System.out.println("String does not contain unique values");

       }
       else
       {
           System.out.println("String has unique characters");
       }

    }
}
