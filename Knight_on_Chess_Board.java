import java.util.*;

class Solution {
    class Cell {
        int x;
        int y;
        int moves;

        Cell(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }

    public int knight(int m, int n, int sx, int sy, int tx, int ty) {
        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        boolean[][] visited = new boolean[m + 1][n + 1];
        Queue<Cell> q = new LinkedList<>();
        q.offer(new Cell(sx, sy, 0));
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            Cell t = q.poll();
            if (t.x == tx && t.y == ty) {
                return t.moves;
            }

            for (int i = 0; i < 8; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];

                if (x >= 1 && x <= m && y >= 1 && y <= n && !visited[x][y]) {
                    q.offer(new Cell(x, y, t.moves + 1));
                    visited[x][y] = true;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 8;
        int n = 8;
        int sx = 1;
        int sy = 1;
        int tx = 8;
        int ty = 8;
        int result = solution.knight(m, n, sx, sy, tx, ty);
        System.out.println("Minimum moves required: " + result);
    }
}
