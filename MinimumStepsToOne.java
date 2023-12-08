import java.util.Arrays;
import java.util.Scanner;

 class MinimumStepsToOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(minSteps(n));
        System.out.println(minSteps2(n));
        System.out.println(minSteps3(n));
    }

    public static int minSteps(int n) {
        // Base case
        if (n <= 1) {
            return 0;
        }

        // Recursive
        int x = minSteps(n - 1);
        int y = Integer.MAX_VALUE;
        int z = Integer.MAX_VALUE;

        if (n % 2 == 0) {
            y = minSteps(n / 2);
        }
        if (n % 3 == 0) {
            z = minSteps(n / 3);
        }

        // Calculate ans
        int ans = Math.min(x, Math.min(y, z)) + 1;
        return ans;
    }

    public static int minSteps2(int n) {
        int[] ans = new int[n + 1];
        Arrays.fill(ans, -1);
        return helper(n, ans);
    }

    public static int helper(int n, int[] ans) {
        // Base case
        if (n <= 1) {
            return 0;
        }

        // Check if output already exists
        if (ans[n] != -1) {
            return ans[n];
        }

        // Recursive
        int x = helper(n - 1, ans);
        int y = Integer.MAX_VALUE;
        int z = Integer.MAX_VALUE;

        if (n % 2 == 0) {
            y = helper(n / 2, ans);
        }
        if (n % 3 == 0) {
            z = helper(n / 3, ans);
        }

        // Calculate ans
        int output = Math.min(x, Math.min(y, z)) + 1;

        // Save ans for future use
        ans[n] = output;

        return output;
    }

    public static int minSteps3(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        // dp[i] = min steps needed to move from i->1, ans = dp[n]

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        return dp[n];
    }
}
