import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Path {
        int x;
        int y;
        int count;

        Path(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        return BFS(grid, 0, 0, grid.length - 1, grid[0].length - 1);
    }

    public int BFS(int[][] grid, int start_x, int start_y, int target_x, int target_y) {
        Queue<Path> q = new LinkedList<>();
        q.add(new Path(start_x, start_y, 1));

        while (!q.isEmpty()) {
            Path rem = q.remove();
            int x = rem.x;
            int y = rem.y;
            int count = rem.count;

            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] != 1) {
                grid[x][y] = 1;

                if (x == target_x && y == target_y)
                    return rem.count;

                q.add(new Path(x - 1, y, count + 1));
                q.add(new Path(x - 1, y + 1, count + 1));
                q.add(new Path(x, y + 1, count + 1));
                q.add(new Path(x + 1, y + 1, count + 1));
                q.add(new Path(x + 1, y, count + 1));
                q.add(new Path(x + 1, y - 1, count + 1));
                q.add(new Path(x, y - 1, count + 1));
                q.add(new Path(x - 1, y - 1, count + 1));
            }
        }
        return -1;
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
        System.out.println(solution.shortestPathBinaryMatrix(arr));
    }

}
