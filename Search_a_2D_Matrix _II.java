import java.util.Scanner;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int numRows = matrix.length, numCols = matrix[0].length, row = 0, col = numCols - 1;

        while (row < numRows && col >= 0) {
            int currentValue = matrix[row][col];
            if (target == currentValue) {
                return true;
            } else if (target < currentValue) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int target = sc.nextInt();
        Solution solution = new Solution();
        boolean result = solution.searchMatrix(arr, target);
        System.out.println(result);
    }
}
