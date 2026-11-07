// D = total length of dictionary words
// S = sentence length
//
// Time: O(D + S)
// Space: O(D + S)
public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        createTrie(dictionary,root);
        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split(" ")) {
            sb.append(chooseWord(root,word));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public String chooseWord(TrieNode root, String word){
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<word.length(); i++){
            int j = word.charAt(i)-'a';
            if (curr.children[j] == null)   return word;
            sb.append(word.charAt(i));
            if(curr.children[j].isEndOfWord)    return sb.toString(); 
            curr = curr.children[j];
        }
        return word;
    }

    public void createTrie(List<String> dictionary,TrieNode root) {
        for(String word : dictionary){
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
