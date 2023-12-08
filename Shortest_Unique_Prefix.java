import java.util.ArrayList;
import java.util.HashMap;

class TrieNode {
    HashMap<Character, TrieNode> children;
    int frequency;

    TrieNode() {
        children = new HashMap<>();
        frequency = 0;
    }
}

class ShortestUniquePrefix {

    public ArrayList<String> prefix(ArrayList<String> A) {
        TrieNode root = new TrieNode();

        for (String word : A) {
            insert(root, word);
        }

        ArrayList<String> result = new ArrayList<>();
        for (String word : A) {
            String uniquePrefix = findUniquePrefix(root, word);
            result.add(uniquePrefix);
        }

        return result;
    }

    private void insert(TrieNode root, String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
            current.frequency++;
        }
    }

    private String findUniquePrefix(TrieNode root, String word) {
        StringBuilder prefix = new StringBuilder();
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            prefix.append(c);
            current = current.children.get(c);
            if (current.frequency == 1) {
                break;
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        ShortestUniquePrefix shortestUniquePrefix = new ShortestUniquePrefix();

        ArrayList<String> input = new ArrayList<>();
        input.add("zebra");
        input.add("dog");
        input.add("duck");
        input.add("dove");

        ArrayList<String> result = shortestUniquePrefix.prefix(input);
        System.out.println(result);
    }
}
