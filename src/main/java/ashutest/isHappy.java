package ashutest;

import java.util.HashSet;

class isHappy {
    public  static boolean isHappy(int n, HashSet<Integer> hs ) {

        if (n == 1)
            return true;
        int square = 0;
        while(n >0)
        {
            int digit = n%10;
            square =  square + digit*digit;
            n = n/10;

        }
        boolean rc = hs.add(square);
        System.out.println(square);
        if(rc == false)
            return false;
        return isHappy(square,hs);
    }
    public static void main(String args[])
    {
        HashSet<Integer> hs = new HashSet<>();
        System.out.println(isHappy(1111111,hs));
    }
}
