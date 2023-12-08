import java.util.*;

class Solution {
    
   public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;
        int left = 0, right = n-1;
        while( left < right ){
            if(nums[left] + nums[right] == target){
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            }else if( nums[left] + nums[right] < target)
                left++;
            else
                right--;
        }
        
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = sc.nextInt();
        }
        int result[] = twoSum(nums, n);
        for(int i=0; i<n; i++) {
            System.out.println(result[i]);
        }
    }
}
