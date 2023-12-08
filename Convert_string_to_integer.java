import java.util.Scanner;


public class Solution {
   public int stringToInteger(String s, int i) {
       if(i == 0){
           return s.charAt(0)-'0';
       } else {
           return s.charAt(i)-'0'+ 10*stringToInteger(s, i-1);
       }
   }


   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String str = sc.next();
       Solution solution = new Solution();
       System.out.println(solution.stringToInteger(str, str.length()-1));
   }
}
