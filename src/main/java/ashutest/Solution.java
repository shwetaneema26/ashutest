package ashutest;
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            for (int count=1 ; count <= k ;count++)
            {
                int i =0;
                while (i < nums.length && (i+count) < nums.length)
                {
                    System.out.println(nums[i] + 1);
                    System.out.println(nums[i] + "-" + nums[i+count] + "="+ Math.abs(1L * nums[i]-nums[i+count]));

                    if(Math.abs(1L * nums[i]  - nums[i+count])  <= t )
                        return true;
                    //i=j;
                    //j= i+count;
                    i++;
                }
            }
            return false;

        }
    public static void main(String [] args)
    {
        Solution s = new Solution();
        int [] input = {-2147483648,2147483647};
        if(s.containsNearbyAlmostDuplicate(input,1,1))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
