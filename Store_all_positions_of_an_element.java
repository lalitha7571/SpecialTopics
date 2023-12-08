import java.util.*;
public class Solution {
   List<Integer> result = new ArrayList();
public void savePosition(int[] nums, int i, int n, int m) {
      if(i == m){
          System.out.println(result);
          return;
      }
      if(nums[i] == n){
          result.add(i);
      }
       savePosition(nums, i+1, n, m);




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
   solution.savePosition(arr, 0, n, m);
}
}
