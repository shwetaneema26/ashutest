package ashutest;

class LIS {
    public int lengthOfLIS(int[] nums) {
        int start =0;
        int end =0;
        int max = 0;
        int i = 0;
        while (i< nums.length -1)
        {
            if(nums[i]< nums[i+1]) {
                end = i + 1;
                i++;
            }
            else
            {
                System.out.println("start:" + nums[start] + " end:"+ nums[end]);
                int temp_max = end -start;
                if(temp_max > max)
                    max = temp_max;
                start = i+1;
                i = start;
            }
        }
        return max +1;

    }
}
