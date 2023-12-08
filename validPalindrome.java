import java.util.*;
public class Solution {
   public boolean isValidPalindrome(String s) {
   StringBuilder sb = new StringBuilder(s.toLowerCase().replaceAll("[^a-z0-9]",""));
   return sb.toString().equals(sb.reverse().toString());
   }
 public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      Solution solution = new Solution();
      System.out.println(solution.isValidPalindrome(s));
  }


}
// Alternate Solution
/*
import java.util.*;
public class Solution {
   public boolean isValidPalindrome(String s) {
   int left = 0;
   int right = s.length()-1;
   while(left<=right) {
       char l = s.charAt(left);
       char r = s.charAt(right);
       if(!Character.isLetterOrDigit(l)){
           left++;
       }
       else if (!Character.isLetterOrDigit(r)){
           right--;
       }
       else
       {
           if(Character.toLowerCase(l) != Character.toLowerCase(r)){
               return false;
           }
           left++;
           right--;
       }
   }
   return true;
   }
 public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      Solution solution = new Solution();
      System.out.println(solution.isValidPalindrome(s));
  }
}
*/
