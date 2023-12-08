import java.util.*;
public class Solution {
  public int sumOfDigits(int n) {
      if(n == 0){
          return 0;
      } else {
          System.out.println(n%10);
          return n%10 + sumOfDigits(n/10);
      }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Solution solution = new Solution();
    System.out.println(solution.sumOfDigits(n));
}
}
