public class MapSumPairs {
    TrieNode root;
    
    public MapSumPairs() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode curr = root;
        for(int i=0; i<key.length(); i++){
            int j = key.charAt(i)-'a';
            if (curr.children[j] == null)   curr.children[j] = new TrieNode();
            curr = curr.children[j];
        }
        int delta = val - curr.value;
        curr.value=val;
        curr.sum+=delta;
        TrieNode c = root;
        int i=0;
        while(c!=curr)  {c.sum+=delta; c=c.children[key.charAt(i)-'a']; i++;}
    }

    public int sum(String prefix) {
        TrieNode curr = root;
        for(int i=0; i<prefix.length(); i++){
            int j = prefix.charAt(i)-'a';
            if (curr.children[j] == null)   return 0;
            curr = curr.children[j];
        }
        return curr.sum;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
    int sum = 0;
    int value = 0;
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
