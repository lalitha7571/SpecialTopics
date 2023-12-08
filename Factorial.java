import java.util.*;
public class Solution {
  public int fac(int n) {
      if(n <= 1){
          return 1;
      } else {
          return n * fac(n-1);
      }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Solution solution = new Solution();
    System.out.println(solution.fac(n));
}
}
