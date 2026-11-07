import java.util.*;

public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        createTrie(words, root);
        String best = "";
        for (String word : words) {
            TrieNode curr = root;
            boolean valid = true;
            for (int i = 0; i < word.length(); i++) {
                curr = curr.children[word.charAt(i) - 'a'];
                if (!curr.isEndOfWord) {valid = false;  break;}
            }
            if (valid) {
                if (word.length()>best.length() || (word.length()==best.length() &&
                     word.compareTo(best) < 0))  {best = word;}
            }
        }
        return best;
    }

    public void createTrie(String[] words,TrieNode root) {
        for(String word : words){
            TrieNode curr = root;
            for(int i=0; i<word.length(); i++){
                int j = word.charAt(i)-'a';
                if (curr.children[j] == null)   curr.children[j] = new TrieNode();
                curr = curr.children[j];
            }
            curr.isEndOfWord=true;
        }
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}
