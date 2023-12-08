import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Solution {
   public void storeSubsequence(String s, String result,  List<String> output) {
       if(s.length() == 0){
           output.add(result);
           return;
       } else {
           storeSubsequence(s.substring(1),result, output);
           storeSubsequence(s.substring(1),result+s.charAt(0), output);
       }
   }


   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String str = sc.next();
       String result = "";
       Solution solution = new Solution();
       List<String> output = new ArrayList<>();
       solution.storeSubsequence(str, result, output);
       System.out.println(output);
   }
}
