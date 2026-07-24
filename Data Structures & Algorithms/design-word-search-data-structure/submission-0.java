public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }

        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (node == null) return false;

        if (index == word.length()) {
            return node.endOfWord;
        }

        char c = word.charAt(index);

        if (c != '.') {
            int idx = c - 'a';
            return dfs(word, index + 1, node.children[idx]);
        }

        // CASE 2: '.' → try all possible children
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                if (dfs(word, index + 1, node.children[i])) {
                    return true;
                }
            }
        }

        return false;
    }
}
