import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    public static TreeNode constructTree(Scanner sc) {
        TreeNode root = null;
        if (sc.hasNextInt()) {
            int val = sc.nextInt();
            if (val != -1) {
                root = new TreeNode(val);
                root.left = constructTree(sc);
                root.right = constructTree(sc);
            }
        }
        return root;
    }
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return buildBST(head, null);
    }

    public static TreeNode buildBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;

        if (head == tail) return null;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = buildBST(head, slow);
        node.right = buildBST(slow.next, tail);

        return node;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
        ListNode head = new ListNode(sc.nextInt());
        for (int i = 0; i < n; i++) {
            head.next = new ListNode(sc.nextInt());
            head = head.next;
        }
        TreeNode result = sortedListToBST(head);
        System.out.println(result.val);
    }
}
