import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public ArrayList<Integer> flip(String A) {
        ArrayList<Integer> ans = new ArrayList<>(2);
        ans.add(-1);
        ans.add(-1);
        int left = 0;
        int right = 0;
        int n = A.length();

        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '0') {
                curSum += 1;
            } else {
                curSum -= 1;
            }
            if (curSum > maxSum) {
                maxSum = curSum;
                right = i;
                ans.set(0, left + 1);
                ans.set(1, right + 1);
            }
            if (curSum < 0) {
                curSum = 0;
                left = i + 1;
            }
        }
        if (maxSum == -1) {
            ans.clear();
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Solution solution = new Solution();
        ArrayList<Integer> result = solution.flip(str);
        for(int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
