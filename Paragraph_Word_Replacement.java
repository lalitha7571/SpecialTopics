import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Solution {
 private static class Node {
        String word;
        Node[] letters = new Node[26];
    }

    private Node root;

    private void insert(String word, int i, Node node) {
        if (i == word.length()) {
            node.word = word;
            return;
        }

        int index = word.charAt(i) - 'a';
        if (node.letters[index] == null)
            node.letters[index] = new Node();

        insert(word, i + 1, node.letters[index]);
    }

    private String search(String word, int i, Node node) {
        if (i == word.length() || node.word != null) {
            return node.word;
        }

        int index = word.charAt(i) - 'a';
        if (node.letters[index] == null)
            return null;

        return search(word, i + 1, node.letters[index]);
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Node();
        for (String word : dictionary)
            insert(word, 0, root);

        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split(" ")) {
            String rootWord = search(word, 0, root);
            sb.append(rootWord == null ? word : rootWord);
            sb.append(" ");
        }

        return sb.substring(0, sb.length() - 1);
    }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<String> dictionary = new ArrayList<>();
    for(int i=0; i<n; i++){
        dictionary.add(sc.nextLine());
    }
    String sentence = sc.nextLine();
    Solution solution = new Solution();
    System.out.println(solution.replaceWords(dictionary, sentence));
}
}

