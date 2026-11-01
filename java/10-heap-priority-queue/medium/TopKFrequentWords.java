package medium;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map <String,Integer> map = new HashMap<>();
        for(int i=0; i<words.length;i++)  map.put(words[i],map.getOrDefault(words[i],0)+1);
        PriorityQueue<String> min = new PriorityQueue<>((a,b)->{
            int freqA=map.get(a);
            int freqB=map.get(b);
            if(freqA!=freqB)    return Integer.compare(freqA,freqB);
            return b.compareTo(a);
        });
        for(String key : map.keySet())  {
            min.offer(key);
            if(min.size()>k) min.poll();
        }
        List<String> res = new ArrayList<>(Collections.nCopies(k, null));
        for (int i=k-1; i>=0; i--)  {if(!min.isEmpty())  res.set(i,min.poll());}
        return res;
    }
}
