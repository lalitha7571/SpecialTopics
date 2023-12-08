import java.util.*;
public class Solution {
  public int pow(int m, int n) {
      if(n == 0){
          return 1;
      } else {
          return m * pow(m,n-1);
      }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    Solution solution = new Solution();
    System.out.println(solution.pow(m,n));
}
}
