import java.util.*;

public class Solution {

    public static int[] findPermutation(int n, String s) {
        int[] result = new int[n];
        int low = 1;
        int high = n;
        
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == 'I') {
                result[i] = low;
                low++;
            } else {
                result[i] = high;
                high--;
            }
        }
        
        result[n - 1] = low;
        
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.nextLine();
        Solution solution = new Solution();
        int result[] = solution.findPermutation(n, s);
        for(int i : result) {
            System.out.println(i);
        }
    }

}
