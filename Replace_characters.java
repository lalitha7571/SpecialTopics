import java.util.Scanner;


public class Solution {
   public String replaceChar(char[] arr, int i, char a, char b) {
       if (i == arr.length) {
           return "";
       } else {
           if(arr[i] == a) {
               return b+replaceChar(arr, i + 1, a, b);
           } else {
               return arr[i]+replaceChar(arr, i + 1, a, b);
           }
       }
   }


   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String str = sc.next();
       char[] arr = new char[str.length()];
       for (int i = 0; i < str.length(); i++) {
           arr[i] = str.charAt(i);
       }
       char a = sc.next().charAt(0);
       char b = sc.next().charAt(0);
       Solution solution = new Solution();
       System.out.println(solution.replaceChar(arr, 0, a, b));
   }
}

