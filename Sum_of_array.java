import java.util.*;
public class Solution {
 public int sum(int[] nums, int n) {
       if(n == 0){
           return nums[0];
       } else {
           return nums[n] + sum(nums, n-1);
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
    System.out.println(solution.sum(arr, n-1));
}
}
