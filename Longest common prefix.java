import java.util.*;
public class Solution {
public String longestCommonPrefix(String[] strs) {
       String result = strs[0];
       for(int i=1; i<strs.length; i++) {
           int len = result.length()<strs[i].length()?result.length():strs[i].length();
           for(int j=0; j<len ; j++) {
               if(result.charAt(j) != strs[i].charAt(j)) {
                   result = result.substring(0,j);
                   len = result.length()<strs[i].length()?result.length():strs[i].length();
               }
               if(result.length() ==0) {
                   break;
               }
           }
           if(result.length() > strs[i].length()){
               result = result.substring(0,strs[i].length());
           }
           if(result.length() ==0) {
                   break;
           }
       }
       return result;
   }
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int size = sc.nextInt();
     String s[] = new String[size];
     for(int i=0; i<size; i++) {
        s[i] = sc.next();
     }
     Solution solution = new Solution();
     System.out.println(solution.longestCommonPrefix(s));
 }
}
