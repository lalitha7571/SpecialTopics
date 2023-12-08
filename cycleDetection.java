import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow= head;
        ListNode fast= head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                return true;
            }
        }  
        return false;
    }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode head = new ListNode(sc.nextInt());
        for (int i = 0; i < n; i++) {
            head.next = new ListNode(sc.nextInt());
            head = head.next;
        }
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(head));
    } 
}
