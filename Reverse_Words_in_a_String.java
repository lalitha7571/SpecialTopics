import java.util.*;
public class Solution {
   public String reverseWords(String s) {
       s = s.trim();
       while(s.contains("  "))
       s = s.replace("  "," ");
       String reverse[] = s.split(" ");
       String result = reverse[reverse.length-1];
       for(int i=reverse.length-2 ; i>=0; i--) {
               result = result+" "+reverse[i];
       }
       return result;
   }
}


import java.util.*;
public class Solution {
   public String reverseWords(String s) {
       String str[] = s.split("\s+");
       s = "";
       for(int i=str.length-1; i>=0; i--) {
           s= s + str[i].trim()+" ";
       }
       return s.trim();
   }
}
