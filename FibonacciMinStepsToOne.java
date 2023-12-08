import java.util.Scanner;
import java.util.Arrays;

class FibonacciMinStepsToOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        System.out.println(minSteps(n));
        System.out.println(minSteps2(n));
    }

    public static int minSteps(int n) {
        if (n <= 1) {
            return 0;
        }
        int x = minSteps(n - 1);
        int y = Integer.MAX_VALUE;
        int z = Integer.MAX_VALUE;

        if (n % 2 == 0) {
            y = minSteps(n / 2);
        }
        if (n % 3 == 0) {
            z = minSteps(n / 3);
        }

        return Math.min(x, Math.min(y, z)) + 1;
    }

    public static int minSteps2(int n) {
        if (n <= 1) {
            return 0;
        }
        int[] ans = new int[n + 1];
        Arrays.fill(ans, -1);
        return helper(n, ans);
    }

    public static int helper(int n, int[] ans) {
        if (n <= 1) {
            return 0;
        }

        if (ans[n] != -1) {
            return ans[n];
        }

        int x = helper(n - 1, ans);
        int y = Integer.MAX_VALUE;
        int z = Integer.MAX_VALUE;

        if (n % 2 == 0) {
            y = helper(n / 2, ans);
        }
        if (n % 3 == 0) {
            z = helper(n / 3, ans);
        }

        int output = Math.min(x, Math.min(y, z)) + 1;
        ans[n] = output;

        return output;
    }
}
