import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Arrays;

class Solution {
    static class Edge{
        int s,d,t;
        Edge(int src,int dest,int time){
            this.s = src;
            this.d = dest;
            this.t = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int min=0,totalO=0,rottenO=0;
        Queue<Edge> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Edge(i,j,min));
                    rottenO++;
                }
                if(grid[i][j]==1 || grid[i][j]==2){
                    totalO++;
                }
            }
        }
        System.out.println("Rotten "+rottenO);
        System.out.println("Total "+totalO);
        while(!q.isEmpty()){
            Edge e = q.poll();
            int i = e.s;
            int j = e.d;

            if(i>0){
                if(grid[i-1][j]==1){
                    q.add(new Edge(i-1,j,e.t+1));
                    grid[i-1][j] = 2;
                    rottenO++;
                }
            }

            if(j>0){
                if(grid[i][j-1]==1){
                    q.add(new Edge(i,j-1,e.t+1));
                    grid[i][j-1]=2;
                    rottenO++;
                }
            }

            if(i<grid.length-1 && i+1>=0){
                if(grid[i+1][j]==1){
                    q.add(new Edge(i+1,j,e.t+1));
                    grid[i+1][j]=2;
                    rottenO++;
                }
            }

            if(j<grid[0].length-1 && j+1>=0){
                if(grid[i][j+1]==1){
                    q.add(new Edge(i,j+1,e.t+1));
                    grid[i][j+1]=2;
                    rottenO++;
                }
            }
            min = e.t;
            System.out.println(min);
        }
        if(totalO!=rottenO){
            return -1;
        }
        return min;
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
        System.out.println(solution.orangesRotting(arr));
    }

}
