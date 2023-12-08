import java.util.*;
public class Solution {
  public int multiply(int m, int n) {
      if(n == 1){
          return m;
      } else {
          return m + multiply(m, n-1);
      }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    Solution solution = new Solution();
    System.out.println(solution.multiply(m,n));
}
}
