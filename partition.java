import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dum1 = new ListNode(0), dum2 = new ListNode(0),
                 front = dum1, back = dum2, curr = head;
        while (curr != null) {
            if (curr.val < x) {
                front.next = curr;
                front = curr;
            } else {
                back.next = curr;
                back = curr;
            }
            curr = curr.next;
        }
        front.next = dum2.next;
        back.next = null;
        return dum1.next;
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
        ListNode partitionedListNode = solution.partition(head, m);

       while(partitionedListNode.next!=null) {
            System.out.println(partitionedListNode.val);
            partitionedListNode = partitionedListNode.next;
        } 
    }
}
