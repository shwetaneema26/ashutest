package ashutest;

import java.util.*;

public class TopKFrequent {
        public static int[] topKFrequent(int[] nums, int k) {
            // O(1) time
            if (k == nums.length) {
                return nums;
            }

            // 1. build hash map : character and how often it appears
            // O(N) time
            Map<Integer, Integer> count = new HashMap<>();
            for (int n: nums) {
                count.put(n, count.getOrDefault(n, 0) + 1);
            }

            // init heap 'the less frequent element first'
            Queue<Integer> heap = new PriorityQueue<>(
                    Comparator.comparingInt(count::get));

            // 2. keep k top frequent elements in the heap
            // O(N log k) < O(N log N) time
            for (int n: count.keySet()) {
                heap.add(n);
                if (heap.size() > k) heap.poll();
            }

            // 3. build an output array
            // O(k log k) time
            int[] top = new int[k];
            for(int i = k - 1; i >= 0; --i) {
                top[i] = heap.poll();
                //System.out.println(top[i]);
            }
            return top;
        }
        public static void main(String args [])
        {
            int a [] = topKFrequent(new int [] {1,1,1,1,2,2,2,3,4,5,6,7,8,9,9,9,9},3);
            for (int x : a)
                System.out.println(x);
        }

    }
