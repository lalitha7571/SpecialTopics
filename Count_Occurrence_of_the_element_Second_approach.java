import java.util.*;
public class Solution {
   int count = 0;
 public int countOccurrence(int[] nums, int i, int n, int m) {
       if(i == m) {
           return 0;
       }
       if(nums[i] == n){
            return 1+countOccurrence(nums, i+1, n, m);
       }
       return countOccurrence(nums, i+1, n, m);
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
    System.out.println(solution.countOccurrence(arr, 0, n, m));
}
}
