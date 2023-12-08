import java.util.*;
public class Solution {
  public boolean isPalindrome(String s) {
  int left = 0;
  int right = s.length()-1;
  while(left<=right) {
      char l = s.charAt(left);
      char r = s.charAt(right);
      if(Character.toLowerCase(l) != Character.toLowerCase(r)){
              return false;
          }
       left++;
       right--;
      }
      return true;
  }
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      Solution solution = new Solution();
      System.out.println(solution.isPalindrome(s));
  }


}
