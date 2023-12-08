import java.util.PriorityQueue;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (ListNode node : lists) {
            while (node != null) {
                p.add(node.val);
                node = node.next;
            }
        }
        ListNode helper = new ListNode(-1);
        ListNode tail = helper;
        while (!p.isEmpty()) {
            ListNode temp = new ListNode(p.poll());
            tail.next = temp;
            tail = tail.next;
        }
        return helper.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode[] lists = new ListNode[n];

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            ListNode head = new ListNode(m);
            ListNode current = head;
            for (int j = 1; j < n; j++) {
                int val = sc.nextInt();
                current.next = new ListNode(val);
                current = current.next;
            }
            lists[i] = head;
        }

        Solution solution = new Solution();
        ListNode middleListNode = solution.mergeKLists(lists);

        while (middleListNode != null) {
            System.out.print(middleListNode.val + " ");
            middleListNode = middleListNode.next;
        }
    }
}
