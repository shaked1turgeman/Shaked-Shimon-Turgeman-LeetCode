package medium;

import java.util.PriorityQueue;
// Time = O(n*log(k))   ,   Space = O(k)
public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            min.offer(nums[i]);
            if (min.size() > k)     min.poll();
        }
        return min.poll();
    }
}
