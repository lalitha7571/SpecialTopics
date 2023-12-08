import java.util.*;
public class Solution {
   public String removeDuplicates(String s, int k) {
       Stack<charAndCount> stack = new Stack<>();
       for(int i=0; i<s.length(); i++){
           char c = s.charAt(i);
           if(!stack.isEmpty() && stack.peek().c == c) {
               if(stack.peek().count < k-1) {
                       stack.peek().count++;
               } else {
                   stack.pop();                      
               }      
           } else{
               stack.push(new charAndCount(c));
           }
       }
       s = "";
      for(charAndCount ch: stack) {
          for(int i=0; i<ch.count; i++){
              s = s+ch.c;
          }
      }
      return s;
   }
class charAndCount{
   char c;
   int count;
   charAndCount(char c){
       this.c = c;
       this.count = 1;
   }
}
public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     String s = sc.nextLine();
     int n = sc.nextInt();
     Solution solution = new Solution();
     System.out.println(solution.removeDuplicates(s, n));
 }

}

