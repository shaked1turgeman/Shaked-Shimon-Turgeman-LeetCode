package medium;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> min = new PriorityQueue<>((a,b)->{
            long sum1 = (long)nums1[a[0]]+nums2[a[1]];
            long sum2 = (long)nums1[b[0]]+nums2[b[1]];
            return Long.compare(sum1,sum2);
        });
        for(int i=0;i<Math.min(k,nums1.length);i++) min.offer(new int[]{i,0});
        List<List<Integer>> res = new ArrayList<>();
        while (res.size() < k && !min.isEmpty()) {
            int[] pair = min.poll();
            if (pair[1] + 1 < nums2.length)   min.offer(new int[]{pair[0], pair[1] + 1});
            res.add(Arrays.asList(nums1[pair[0]], nums2[pair[1]]));
        }
        return res;
    }
}
