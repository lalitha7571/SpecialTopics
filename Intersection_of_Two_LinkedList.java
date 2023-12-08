import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode headA = new ListNode(sc.nextInt());

        for (int i = 0; i < n; i++) {
            headA.next = new ListNode(sc.nextInt());
            headA = headA.next;
        }
        int m = sc.nextInt();
        ListNode headB = new ListNode(sc.nextInt());

        for (int i = 0; i < m; i++) {
            headB.next = new ListNode(sc.nextInt());
            headB = headB.next;
        }

        Solution solution = new Solution();
        ListNode intersectionNode = solution.getIntersectionNode(headA, headB);

        if (intersectionNode != null) {
            System.out.println("Intersection Node: " + intersectionNode.val);
        } else {
            System.out.println("No intersection node found.");
        }
    }
}
