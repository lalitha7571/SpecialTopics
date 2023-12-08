import java.util.*;
public class Solution {
   public void print(int[] nums, int i) {
       if(i == nums.length) {
           return;
       } else {
           System.out.println(nums[i]);
           print(nums, i+1);
       }
  }
  public void reversePrint(int[] nums, int i) {
       if(i < 0) {
           return;
       } else {
           System.out.println(nums[i]);
           reversePrint(nums, i-1);
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
   System.out.println("Printing the elements : ");
   solution.print(arr, 0);
   System.out.println("Reverse printing the elements : ");
   solution.reversePrint(arr, n-1);
}
}
