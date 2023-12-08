import java.util.*;

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

   public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        int cur = root.val;
        if (cur < p.val && cur < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (cur > p.val && cur > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = constructTree(sc);
        sc.close();
        sc = new Scanner(System.in);
        TreeNode n = constructTree(sc);
        sc.close();
        sc = new Scanner(System.in);
        TreeNode m = constructTree(sc);
        sc.close();
        TreeNode result = lowestCommonAncestor(root, n, m);
        System.out.println(result.val);
    }
}
