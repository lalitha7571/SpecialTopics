import java.util.*;
public class Solution {
   public String removeDuplicates(String s) {
       Stack<Character> stack = new Stack<>();
       for(int i=0; i<s.length();i++) {
           if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
               stack.pop();   
           } else {
               stack.push(s.charAt(i));
           }
       }
       s = "";
       for(char ch: stack) {
          s = s+ch;
       }
       return s;
   }
public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     String s = sc.nextLine();
     Solution solution = new Solution();
     System.out.println(solution.removeDuplicates(s));
 }
}
