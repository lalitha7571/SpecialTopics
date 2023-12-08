import java.util.Scanner;


public class Solution {
   public String removeChar(String s, int i) {
       if (i == s.length()) {
           return "";
       }
       if (i == 0) {
           return s.charAt(0) + removeChar(s, i + 1);
       } else {
           if(s.charAt(i) == s.charAt(i-1)) {
               return removeChar(s, i + 1);
           } else {
               return s.charAt(i)+removeChar(s, i + 1);
           }
       }
   }


   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String str = sc.next();
       Solution solution = new Solution();
       System.out.println(solution.removeChar(str, 0));
   }
}
