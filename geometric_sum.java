import java.util.*;
public class Solution {
  public double geoSum(int n) {
      if(n == 0){
          return 1;
      } else {
           return 1/Math.pow(2,n) + geoSum(n-1);
      }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Solution solution = new Solution();
    System.out.println(solution.geoSum(n));
}
}
