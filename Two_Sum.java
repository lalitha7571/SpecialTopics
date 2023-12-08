import java.util.*;

class Solution {
    
   public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int result[] = new int[2];

        Map <Integer,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            if(map.containsKey(target-nums[i])){
                result[0]=i;
                result[1]=map.get(target-nums[i]);
            }
            map.put(nums[i],i);
        }
        return result;
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
