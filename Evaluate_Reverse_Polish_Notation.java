import java.util.*;
public class Solution {
  public int evalRPN(String[] tokens) {
      Stack<Integer> s = new Stack<>();
      String op = "+-*/";
      int n1 = 0;
      int n2 = 0;
      for(String str:tokens) {
          if(op.contains(str) && !s.isEmpty()) {
              n1 = s.pop();
              n2 = s.pop();
              int val = cal(n1, str, n2);
              s.push(val);
          } else {
              s.push(Integer.parseInt(str));
          }
      }
      return s.pop();
  }
  public int cal(int n1, String s, int n2) {
      if(s.equals("+"))
           return n2+n1;
       else if(s.equals("-"))
           return n2-n1;
       else if(s.equals("*"))
           return n2*n1;
       else
           return n2/n1;
  }
}
