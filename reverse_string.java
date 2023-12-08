import java.util.*;
public class Solution {
  public String reverseString(String s) {
      String result = "";
      for(int i=s.length()-1; i>=0; i--) {
          result = result + s.charAt(i);
      }
      return result;
  }
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      Solution solution = new Solution();
      System.out.println(solution.reverseString(s));
  }
}
