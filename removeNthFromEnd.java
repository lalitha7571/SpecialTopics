import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode head = new ListNode(sc.nextInt());
        for (int i = 0; i < n; i++) {
            head.next = new ListNode(sc.nextInt());
            head = head.next;
        }
        int m = sc.nextInt();
        Solution solution = new Solution();
        ListNode nthFromEnd = solution.removeNthFromEnd(head, m);

        if (nthFromEnd != null) {
            System.out.println(nthFromEnd.val);
        } else {
             System.out.println("Empty ListNode");
        }
    }
}
