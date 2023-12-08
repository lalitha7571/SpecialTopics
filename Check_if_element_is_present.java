import java.util.*;
public class Solution {
 public boolean checkElement(int[] nums, int i, int n) {
       if(i > nums.length - 1){
           return false;
       }
       if(nums[i] == n){
           return true;
       } else {
           return checkElement(nums, i+1, n);
       }
   }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int arr[] = new int[m];
    for(int i=0;i<m ;i++){
        arr[i] = sc.nextInt();
    }
    int n = sc.nextInt();
    Solution solution = new Solution();
    System.out.println(solution.checkElement(arr, 0, n));
}
}

