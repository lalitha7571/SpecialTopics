import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Arrays;

class Solution {
     class Path {
        int index;
        int count;

        Path(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    int answer = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int n = wordList.size();
        boolean visited[] = new boolean[n];
        Queue<Path> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (checkDistance(beginWord, wordList.get(i))) {
                visited[i] = true;
                q.offer(new Path(i, 1));
            }
        }

        while (!q.isEmpty()) {
            Path temp = q.poll();
            int index = temp.index;
            int count = temp.count;

            if (wordList.get(index).equals(endWord)) {
                return count + 1;
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i] && checkDistance(wordList.get(index), wordList.get(i))) {
                    visited[i] = true;
                    q.offer(new Path(i, count + 1));
                }
            }
        }

        return 0;
    }

    public boolean checkDistance(String word1, String word2) {

        int n = word1.length();
        int temp = 0;
        for (int j = 0; j < n; j++) {
            if (word1.charAt(j) != word2.charAt(j)) {
                temp++;
                if (temp > 1)
                    return false;
            }
        }

        return temp == 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String beginWord = sc.nextLine();
        String endWord  = sc.nextLine();
        String dictionary = sc.nextLine();
        String[] strSplit = dictionary.split(" ");
        List<String> wordList = new ArrayList<String>(Arrays.asList(strSplit));
        Solution solution = new Solution();
        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }

}
