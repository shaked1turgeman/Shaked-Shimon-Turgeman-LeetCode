public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            int j = word.charAt(i)-'a';
            if (curr.children[j] == null)   curr.children[j] = new TrieNode();
            curr = curr.children[j];
        }
        curr.isEndOfWord=true;
    }
    
    public boolean search(String word) {
        return dfs(root,word,0);
    }

    boolean dfs(TrieNode curr, String word, int i){
        if(curr==null) return false;
        if (i == word.length()) return curr.isEndOfWord;
        char c = word.charAt(i);
        if (c == '.') {
            for(int j=0; j<26; j++)     {if(dfs(curr.children[j],word,i+1))return true;}
            return false;
        }
        return dfs(curr.children[c-'a'],word,i+1);
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
