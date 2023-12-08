import java.util.*;
public class Solution {
   public int singleNumber(int[] nums) {
       Map<Integer, Integer> map = new HashMap<>();
       int result = 0;
       for(int i=0; i<nums.length; i++) {
           if(map.containsKey(nums[i])) {
               map.put(nums[i], map.get(nums[i])+1);
           } else {
               map.put(nums[i], 1);
           }
       }
       for (Map.Entry<Integer, Integer> set : map.entrySet()) {
           if(set.getValue() == 1)
               result = set.getKey();
       }
       return result;
   }
}


import java.util.*;
public class Solution {
   public int singleNumber(int[] nums) {
       int result = 0;
       for(int i=0; i<nums.length; i++) {
           result = result ^ nums[i];
       }
       return result;
   }
}
