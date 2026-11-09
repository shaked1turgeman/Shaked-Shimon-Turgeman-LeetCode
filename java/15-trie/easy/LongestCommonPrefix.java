// Time = O(S)   ,Space = O(S)      *S = sum of all strs[] Strings length
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode();
        for (String word : strs) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                int j = word.charAt(i) - 'a';
                if (curr.children[j] == null)  curr.children[j] = new TrieNode();
                curr = curr.children[j];
                curr.count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        TrieNode curr = root;
        for (int i = 0; i < strs[0].length(); i++) {
            int j = strs[0].charAt(i) - 'a';
            curr = curr.children[j];
            if (curr.count != strs.length)  break;
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int count = 0;
}
