import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans =0;
        for(Integer i : nums)
            map.put(i, map.getOrDefault(i,0)+1);

        for(Integer i : map.keySet()){
            if(map.get(i) > (nums.length)/2)
                return i;
        }

        return -1;
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i=0;i<n ;i++){
        arr[i] = sc.nextInt();
    }
    Solution solution = new Solution();
    System.out.println(solution.majorityElement(arr));
}
}
