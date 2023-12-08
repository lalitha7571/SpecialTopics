import java.util.Scanner;


public class Solution {
   public String removeChar(String s, int i, char a) {
       if (i == s.length()) {
           return "";
       } else {
           if(s.charAt(i) == a) {
               return removeChar(s, i + 1, a);
           } else {
               return s.charAt(i)+removeChar(s, i + 1, a);
           }
       }
   }


   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String str = sc.next();
       char a = sc.next().charAt(0);
       Solution solution = new Solution();
       System.out.println(solution.removeChar(str, 0, a));
   }
}
