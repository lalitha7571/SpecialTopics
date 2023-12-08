import java.util.Scanner;


public class Solution {
   public void printPermutations(String s, String result) {
       int n = s.length();
       if (n == 0) {
           System.out.println(result);
       } else {
           for (int i = 0; i < n; i++) {
               printPermutations(s.substring(0, i) + s.substring(i + 1), result + s.charAt(i));
           }
       }
   }


   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String str = sc.next();
       Solution solution = new Solution();
       solution.printPermutations(str, "");
   }
}
