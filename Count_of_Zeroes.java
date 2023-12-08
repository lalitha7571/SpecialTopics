import java.util.*;
public class Solution {
   int zeroes = 0;
  public int countZeroes(int n) {
      if(n == 0){
          return 1;
      } else if(n < 10) {
          return 0;
      } else {
          if(n%10 == 0){
              return 1 + countZeroes(n/10);
           } else {
               return countZeroes(n/10);
           }
      }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Solution solution = new Solution();
    System.out.println(solution.countZeroes(n));
}
}
