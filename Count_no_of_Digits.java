import java.util.*;
public class Solution {
  public int countNoOfDigits(int n) {
      if(n == 0){
          return 0;
      } else {
          return 1+countNoOfDigits(n/10);
      }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Solution solution = new Solution();
    System.out.println(solution.countNoOfDigits(n));
}
}
