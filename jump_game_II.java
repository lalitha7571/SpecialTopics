import java.util.*;

public class Solution {
    public int jump(int[] nums) {
      int jumps = 0, currEnd = 0, currFarthest = 0;
      for(int i = 0; i < nums.length - 1; i ++) {
          currFarthest = Math.max(currFarthest, i + nums[i]);
          if(i == currEnd) {
              currEnd = currFarthest;
              jumps ++;
          }
      }  
      return jumps;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n ;i++){
            arr[i] = sc.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.jump(arr));
    }
}
