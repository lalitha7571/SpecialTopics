import java.util.Scanner;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int area = islandArea(grid, i, j, 0);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    private int islandArea(int[][] grid, int i, int j, int area) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        return 1 + islandArea(grid, i + 1, j, area) +
               islandArea(grid, i - 1, j, area) +
               islandArea(grid, i, j + 1, area) +
               islandArea(grid, i, j - 1, area);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int arr[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                 arr[i][j] = sc.nextInt();
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.maxAreaOfIsland(arr));
    }
}
