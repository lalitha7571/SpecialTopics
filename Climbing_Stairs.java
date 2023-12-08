import java.util.*;
public class Solution {
   public int climbStairs(int n) {
       // 5
       if(n<=2){
           return n;
       } else{
           int x = 1;
           int y = 2;
           int z = 0;
           for( int i=2;i<n;i++){
               z = x;
               x = y;
               y = z+y;


           }
           // 5
           // 5 - 2 0 = 1
           // 5 - 2 1 = 1112 = 4
           // 5 - 2 2 = 112 = 3
           // // i=2 -- r = 1; o = 2; t = 1+2 = 3
           // // i=3 -- r = 2; o = 3; t = 2+3 = 5
           // // i=4 -- r = 3; o = 5; t = 3+5 = 8
           35/2 =
           return y;
       }
   }
}
