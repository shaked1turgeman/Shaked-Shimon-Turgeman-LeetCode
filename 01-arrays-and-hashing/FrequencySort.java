import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class FrequencySort {
    public String frequencySort(String s) {

        //counting and mapping the frequencies of chars
        HashMap <Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length; i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

         //building and filling a frequencies array
        List<Character>[] freqs = new List [s.length+1];
        for (char key : map.keySet()){
            int index = map.get(key);
            if(freqs[index]==null)   freqs[index] = new ArrayList<>();
            freqs[index].add(key);
        }

        //String Rearrangement
        StringBuilder sb = new StringBuilder();
        for(int i=freqs.length-1; i>0; i--){
            
            if(freqs[i]!=null){
                for(char c : freqs[i]) { 
                    int count=0;
                    while(count<i){
                         sb.append(c);
                         count++;
                    }
                }
            }
        }
        return sb.toString();
    }
}
