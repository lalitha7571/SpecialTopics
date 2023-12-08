import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static List<Integer> findRepeatAndMissing(List<Integer> arr) {
        long sum = 0; // A - B
        long squareSum = 0;
        long temp;
        
        for (int i = 0; i < arr.size(); i++) {
            temp = arr.get(i);
            sum += temp;
            sum -= (i + 1);

            squareSum += (temp * temp);
            squareSum -= (long) (i + 1) * (long) (i + 1);
        }
        
        long sumAB = squareSum / sum; // A + B
        int A = (int) ((sum + sumAB) / 2);
        int B = (int) (sumAB - A);

        List<Integer> ans = new ArrayList<>();
        ans.add(A);
        ans.add(B);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List <Integer> nums = new ArrayList<>();
        for(int i=0; i<n; i++) {
            nums.add(sc.nextInt());
        }
        List<Integer> result = findRepeatAndMissing(nums);
        System.out.println("Output: [" + result.get(0) + ", " + result.get(1) + "]");
    }
}
