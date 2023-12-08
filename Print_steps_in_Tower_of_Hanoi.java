import java.util.Scanner;


public class Solution {
   public void printStepsTowerOfHanoi(int n, String a, String b, String c) {
       if (n == 0) {
           return;
       } else {
           printStepsTowerOfHanoi(n-1,a, c , b);
           System.out.println("Moving disks "+n+" from "+a+" to "+c);
           printStepsTowerOfHanoi(n-1,b, c, a);
       }
   }


   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       Solution solution = new Solution();
       solution.printStepsTowerOfHanoi(n, "A", "B", "C");
   }
}
