import java.util.*;
public class Solution {
   public boolean checkPalindrome(int[] nums, int i, int n) {
       if(i > n) {
           return true;
       }
       if(nums[i] != nums[n]) {
           return false;
       }
       else {
           return checkPalindrome(nums, i+1, n-1);
       }
  }
 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   int n = sc.nextInt();
   int arr[] = new int[n];
   for(int i=0;i<n ;i++){
       arr[i] = sc.nextInt();
   }
   Solution solution = new Solution();
   System.out.println(solution.checkPalindrome(arr, 0, n-1));
}
}
