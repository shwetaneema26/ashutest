package ashutest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class MagicNumerAshu {
    public static void main(String args[]) {
        int start =147;
        int end = 1000;
        for (int i = start; i <= end; i++) {

             String str = String.valueOf(i);
             char arr [] = str.toCharArray();

             int nextIdx = 0;
             boolean [] visited =  new boolean[10];
             int x = 0 ;
             boolean flag = true;
             while(x<arr.length)
             {
                 if (!visited[arr[nextIdx] - '0'])
                     visited[arr[nextIdx] -'0']  = true;
                 else {
                     flag = false;
                     break;
                 }
                     nextIdx = (arr[nextIdx] -'0' + nextIdx ) % arr.length;
                 x++;
             }
             if(flag && nextIdx == 0)
             {
                 int count= 0;
                 for(char c : arr)
                 {
                     if (visited[c - '0'])
                         count++;
                 }
                 System.out.println(new String(arr));
                 if(count == arr.length) {
                     System.out.println("Magic no:" + new String(arr));
                     //return true;
                 }

             }
             else
                 System.out.println("Skipping number:" + new String(arr));
        }
    }
}
