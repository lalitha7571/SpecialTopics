import java.util.*;
public class Solution {
   public int titleToNumber(String columnTitle) {
       int len = columnTitle.length();
       int result = columnTitle.charAt(len-1)-64;
       int count = len-1;
       for(int i=0; i<len && count >0 ; i++){
           int ascii_val = columnTitle.charAt(i)-64;
           result = result + (int)(Math.pow(26,count)*ascii_val);
           count--;
       }
       return result;
   }
}
