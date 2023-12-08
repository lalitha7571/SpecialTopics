import java.util.*;
public class Solution {
   int count = 0;
 public void countOccurrence(int[] nums, int i, int n, int m) {
       if(i > m-1){
           System.out.println(count);
           return;
       }
       if(nums[i] == n){
           count++;
       }
        countOccurrence(nums, i+1, n, m);


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
    solution.countOccurrence(arr, 0, n, m);
}
}
