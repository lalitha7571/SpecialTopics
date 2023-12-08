import java.util.*;

class Solution {
   public int[] searchRange(int[] nums, int target) {
       int ans[] = {-1,-1};
       int start = search(nums, target, true);
       int end = search(nums,target,false);
       ans[0] = start;
       ans[1] = end;


       return ans;
   }


   public int search(int[] nums, int target, boolean findStartIndex){
           int ans = -1;
           int start = 0;
           int end = nums.length - 1;


       while(start <= end){
           int mid = start + (end - start) / 2;


           if(target < nums[mid]){
               end = mid - 1;
           }
           else if(target > nums[mid]){
               start = mid + 1;
           }
           else{
               ans = mid;


               if(findStartIndex){
                   end = mid -1;
               }
               else{
                   start = mid + 1;
               }
           }
       }
       return ans; 
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int arr[] = new int[n];
       for (int i = 0; i < n; i++) {
           arr[i] = sc.nextInt();
       }
       int m = sc.nextInt();
       Solution solution = new Solution();
       int result[] = solution.searchRange(arr, m);
       for(int i: result) {
		System.out.println(i);
   }
}
