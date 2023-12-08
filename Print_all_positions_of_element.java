import java.util.*;
public class Solution {
 public void checkElement(int[] nums, int i, int n, int m) {
       if(i > m-1){
           return;
       }
       if(nums[i] == n){
           System.out.println(i);
       }
        checkElement(nums, i+1, n, m);


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
    solution.checkElement(arr, 0, n, m);
}
}
