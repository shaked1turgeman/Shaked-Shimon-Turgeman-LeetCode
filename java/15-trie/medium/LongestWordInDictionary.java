public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        createTrie(words,root);
        Arrays.sort(words, (a, b) -> {  if (a.length() != b.length())
            return Integer.compare(b.length(), a.length());
            return a.compareTo(b);});
        
        for(String word : words){
            int i=0;
            TrieNode curr = root;
            while(i<word.length() && curr.children[word.charAt(i)-'a'].isEndOfWord){
                if(i==word.length()-1)  return word;
                curr=curr.children[word.charAt(i)-'a'];
                i++;
            }
            
        }
        return "";
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
