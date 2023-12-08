import java.util.*;
public class Solution {
 public boolean check(int[] nums, int n) {
       if(n == nums.length-1){
           return true;
       }
       if(nums[n] > nums[n+1]) {
           return false;
       } else {
           return check(nums, n+1);
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
    System.out.println(solution.check(arr, 0));
}
}
