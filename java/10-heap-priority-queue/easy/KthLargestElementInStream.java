package easy;

import java.util.PriorityQueue;

//  constructor:    Time = O(n*log(k+1))   ,   Space = O(k)
//  add:    Time = O(log(k+1))   ,   Space = O(1)
public class KthLargestElementInStream {

    private PriorityQueue<Integer> min ;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.min = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            this.min.offer(nums[i]);
            if (min.size() > k)     min.poll();
        }
    }
    
    public int add(int val) {
        this.min.offer(val);
        if (min.size() > k)     min.poll();
        return this.min.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
