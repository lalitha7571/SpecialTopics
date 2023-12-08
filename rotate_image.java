import java.util.*;

public class Solution {
    public void rotate(int[][] matrix, int row) {
       for(int i=0; i<row; i++){
           for(int j=row-1; j>=0; j--) {
               System.out.println(matrix[j][i]);
           }
       }
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[][] = new int[n][n];
    for(int i=0;i<n ;i++){
         for(int j=0;j<n ;j++) {
            arr[i][j] = sc.nextInt(); 
         }
    }
    Solution solution = new Solution();
    solution.rotate(arr, n);
    }
}
