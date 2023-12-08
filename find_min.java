import java.util.*;

public class Solution {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]>nums[r])
                l=mid+1;
            else
                r=mid;
        }
        return nums[r];
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.findMin(arr));
    }

}
