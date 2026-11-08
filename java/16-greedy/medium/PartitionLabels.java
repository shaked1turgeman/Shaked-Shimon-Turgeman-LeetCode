// Time = O(n)   ,   Space = O(1)
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        if(s.length()==1)   {res.add(1); return res;}
        int[] last = new int[26];
        for(int i=0; i<s.length(); i++)    last[s.charAt(i) - 'a'] = i;
        int size=1, i=1, end=last[s.charAt(0) - 'a'];
        while(i<s.length()){
            while(i<=end){
                end=Math.max(end,last[s.charAt(i) - 'a']);
                i++;
                size++;
            }
            res.add(size);
            size=0;
            if (i < s.length())     end = last[s.charAt(i) - 'a']; 
        }
        return res;
    }
}
