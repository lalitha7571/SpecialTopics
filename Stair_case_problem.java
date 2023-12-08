import java.util.Scanner;


public class Solution {
   public int stairCase(int n) {
       if (n == 0 || n == 1) {
           return 1;
       }
       if (n < 0) {
           return 0;
       } else {
           return stairCase(n-1) + stairCase(n-2) + stairCase(n-3);
       }
   }


   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       Solution solution = new Solution();
       System.out.println(solution.stairCase(n));
   }
}
