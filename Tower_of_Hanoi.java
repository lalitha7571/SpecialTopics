import java.util.Scanner;


public class Solution {
   public int towerOfHanoi(int n) {
       if (n == 1) {
           return 1;
       }
       if (n <= 0) {
           return 0;
       } else {
           return 2*towerOfHanoi(n-1) + 1;
       }
   }


   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       Solution solution = new Solution();
       System.out.println(solution.towerOfHanoi(n));
   }
}
