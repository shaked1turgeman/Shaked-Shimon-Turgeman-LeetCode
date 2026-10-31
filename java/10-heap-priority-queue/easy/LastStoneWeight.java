package easy;

import java.util.PriorityQueue;
import java.util.Collections;
// Time = O(n*log(n))   ,   Space = O(n)
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<stones.length; i++)   max.offer(stones[i]);
        int res=max.poll();
        while(!max.isEmpty()){
            res-=max.poll();
            if (res!=0) max.offer(res);
            if(!max.isEmpty())  res=max.poll();
        }   
        return res;
    }
}
