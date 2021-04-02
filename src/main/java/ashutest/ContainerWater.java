package ashutest;
//https://leetcode.com/problems/container-with-most-water/
public class ContainerWater {
        public int maxArea(int[] height) {
            int i = 0;
            int j = height.length -1;
            int maxarea = 0;
            while(i < j)
            {
                maxarea = Math.max(maxarea ,Math.min(height[i],height[j]) * (j-i));
                if (height[i] < height[j])
                    i++;
                else
                    j--;
            }
            return maxarea;
        }
    }
