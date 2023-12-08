import java.util.Scanner;
import java.util.Arrays;

class Knapsack {

    public static int knapsack(int n, int W, int[] price, int[] wts) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (wts[n - 1] > W) {
            return knapsack(n - 1, W, price, wts);
        } else {
            int inc = price[n - 1] + knapsack(n - 1, W - wts[n - 1], price, wts);
            int exl = knapsack(n - 1, W, price, wts);
            return Math.max(inc, exl);
        }
    }

    public static int solve(int[] price, int[] wts, int W) {
        int n = price.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wts[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int inc = price[i - 1] + dp[i - 1][j - wts[i - 1]];
                    int exl = dp[i - 1][j];
                    dp[i][j] = Math.max(inc, exl);
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n];
        int[] wts = new int[n];
        for(int i=0; i<n; i++) {
            price[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++) {
            wts[i] = sc.nextInt();
        }
        int W = sc.nextInt();
        int result = solve(price, wts, W);
        System.out.println("Maximum value that can be obtained: " + result);
    }
}
