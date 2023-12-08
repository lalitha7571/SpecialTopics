import java.util.Scanner;


public class Solution {
   public int lengthOfCharArray(char[] arr, int i) {
       if (arr[i] == '\0') {
           return i;
       } else {
           return lengthOfCharArray(arr, i + 1);
       }
   }


   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String str = sc.next();
       char[] arr = new char[str.length() + 1];
       for (int i = 0; i < str.length(); i++) {
           arr[i] = str.charAt(i);
       }
       Solution solution = new Solution();
       System.out.println(solution.lengthOfCharArray(arr, 0));
   }
}
