import java.util.*;

class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return node.isEndOfWord;
    }
}

class HotelReviews {

    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        ArrayList<String> goodWords = new ArrayList<>(Arrays.asList(A.split("_")));
        Trie trie = new Trie();

        for (String word : goodWords) {
            trie.insert(word);
        }

        ArrayList<ReviewWithGoodness> reviewsWithGoodness = new ArrayList<>();
        int index = 0;
        for (String review : B) {
            int goodnessValue = 0;
            String[] words = review.split("_");
            for (String word : words) {
                if (trie.search(word)) {
                    goodnessValue++;
                }
            }
            reviewsWithGoodness.add(new ReviewWithGoodness(index++, goodnessValue));
        }

        Collections.sort(reviewsWithGoodness);

        ArrayList<Integer> result = new ArrayList<>();
        for (ReviewWithGoodness reviewWithGoodness : reviewsWithGoodness) {
            result.add(reviewWithGoodness.index);
        }

        return result;
    }

    static class ReviewWithGoodness implements Comparable<ReviewWithGoodness> {
        int index;
        int goodnessValue;

        ReviewWithGoodness(int index, int goodnessValue) {
            this.index = index;
            this.goodnessValue = goodnessValue;
        }

        @Override
        public int compareTo(ReviewWithGoodness other) {
            return Integer.compare(other.goodnessValue, this.goodnessValue);
        }
    }

    public static void main(String[] args) {
        HotelReviews hotelReviews = new HotelReviews();

        String A = "coolicewifi";
        ArrayList<String> B = new ArrayList<>(Arrays.asList("wateriscool", "coldicedrink", "coolwifispeed"));

        ArrayList<Integer> result = hotelReviews.solve(A, B);
        System.out.println(result); 
    }
}
