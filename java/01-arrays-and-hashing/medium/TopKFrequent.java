import java.util.*;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        //counting and mapping the frequencies
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[k];
        if(nums.length==0) return result;
        for(int i=0; i<nums.length;i++){
            if( map.containsKey(nums[i]) )   map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
        }

        //building and filling a frequencies array
        List<Integer>[] freqs = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int index = map.get(key);
            if (freqs[index] == null) 
                freqs[index] = new ArrayList<>();
            
            freqs[index].add(key);
        }

        //collecting the k most frequent elements
        int index = 0;
        for (int i = freqs.length - 1; i >= 0 && index < k; i--) {
            if (freqs[i] != null) {
                for (int num : freqs[i]) {
                    result[index++] = num;
                    if (index == k) break;
                }
            }
        }

        return result;
    }
}
