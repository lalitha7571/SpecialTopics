import java.util.Scanner;


public class Solution {
   public void printSubsequence(String s, String result) {
       if(s.length() == 0){
           System.out.println(result);
           return;
       }
       printSubsequence(s.substring(1),result);
       printSubsequence(s.substring(1),result+s.charAt(0));
   }


   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String str = sc.next();
       String result = "";
       Solution solution = new Solution();
       solution.printSubsequence(str, result);
   }
}
