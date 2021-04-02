package ashutest;

import java.util.HashMap;
//https://leetcode.com/problems/subarray-sum-equals-k/
public class SubArraySum {
        public int subarraySum(int[] nums, int k) {
            int count = 0, sum = 0;
            HashMap < Integer, Integer > map = new HashMap< >();
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum - k))
                {
                    System.out.println(count);
                    count += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
        public static void main(String args [])
        {
            SubArraySum ss = new SubArraySum();
            ss.subarraySum(new int[] {0,0,0,0,0,0,0,0,0,0},0);
        }
    }
